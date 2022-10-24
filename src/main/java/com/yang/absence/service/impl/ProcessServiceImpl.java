package com.yang.absence.service.impl;

import com.yang.absence.entity.common.LoginUser;
import com.yang.absence.entity.dto.TaskDTO;
import com.yang.absence.entity.process.ProcInstancePO;
import com.yang.absence.entity.process.ProcTaskInstance;
import com.yang.absence.entity.process.ProcessDefinitionPo;
import com.yang.absence.exception.BusinessException;
import com.yang.absence.mapper.ProcInstanceMapper;
import com.yang.absence.mapper.ProcTaskInstanceMapper;
import com.yang.absence.service.ProcessService;
import com.yang.absence.utils.LoginUserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 14:51
 */

@Slf4j
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcTaskInstanceMapper procTaskInstanceMapper;

    @Autowired
    private ProcInstanceMapper procInstanceMapper;

    @Autowired
    private RuntimeService runtimeService;

    /**
     * 流程部署
     *
     * @param file      上传bpmn文件
     * @param companyId 企业id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deployProcess(MultipartFile file, String companyId) throws IOException {
        //1.获取上传的文件名
        String fileName = file.getOriginalFilename();
        if (StringUtils.isBlank(fileName)) {
            throw new BusinessException("文件名称不能为空！");
        }
        //2.通过repositoryService进行流程部署
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment()
                //文件名称,文件的bytes数组
                .addBytes(fileName, file.getBytes())
                //部署名称
                .name(fileName)
                .key(fileName.split("\\.")[0])
                // 租户id
                .tenantId(companyId);
        Deployment deploy = deploymentBuilder.deploy();
        //3.打印部署结果
        log.info("{}", deploy);
    }

    @Override
    public List<ProcessDefinitionPo> processDefinitionList(String tenantId) {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> processDefinitions =
                processDefinitionQuery.processDefinitionTenantId(tenantId).latestVersion().list();
        List<ProcessDefinitionPo> data = new ArrayList<>();
        for (ProcessDefinition processDefinition : processDefinitions) {
            ProcessDefinitionPo definitionPo = new ProcessDefinitionPo();
            BeanUtils.copyProperties(processDefinition, definitionPo);
            data.add(definitionPo);
        }
        return data;
    }

    @Override
    public void updateProcessStatus(List<String> processDefinitionIds, String companyId) {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> processDefinitions =
                processDefinitionQuery.processDefinitionTenantId(companyId).latestVersion().list();
        processDefinitions.forEach(p -> {
            String processDefinitionId = p.getId();
            if (processDefinitionIds.contains(processDefinitionId)) {
                boolean isSuspend = repositoryService.isProcessDefinitionSuspended(processDefinitionId);
                if (isSuspend) {
                    repositoryService.activateProcessDefinitionById(processDefinitionId);
                    log.info("激活{}的{}流程", p.getTenantId(), p.getName());
                } else {
                    repositoryService.suspendProcessDefinitionById(processDefinitionId);
                    log.info("挂起{}的{}流程", p.getTenantId(), p.getName());
                }
            }
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void completeTasks(List<TaskDTO> tasks) {
        if (!CollectionUtils.isEmpty(tasks)) {
            throw new BusinessException("请选择需要完成的代办！");
        }
        List<String> taskIds = tasks.stream().map(TaskDTO::getTaskId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(taskIds)) {
            throw new BusinessException("请选择需要完成的代办！");
        }
        // 完成任务流程
        taskIds.forEach(taskId -> taskService.complete(taskId));
        List<ProcTaskInstance> taskInstances = new ArrayList<>();
        // 保存任务完成数据
        for (TaskDTO task : tasks) {
            ProcTaskInstance taskInstance = new ProcTaskInstance();
            LoginUser loginUser = LoginUserThreadLocal.getLoginUser();
            BeanUtils.copyProperties(task, taskInstance);
            taskInstance.setHandleUserId(loginUser.getUserId());
            taskInstance.setHandleUserName(loginUser.getUsername());
            taskInstance.setHandleTime(new Date());
            taskInstances.add(taskInstance);
        }
        procTaskInstanceMapper.insertOrUpdateBatch(taskInstances);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void startProcess(ProcInstancePO procInstance) {
        // 启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKeyAndTenantId("Absence", "XYY");
        // 封装启动流程的实例对象
        ProcInstancePO instance = new ProcInstancePO();
        BeanUtils.copyProperties(procInstance, instance);
        LoginUser loginUser = LoginUserThreadLocal.getLoginUser();
        BeanUtils.copyProperties(loginUser, instance);
        instance.setProcApplyTime(new Date());
        instance.setProcCurrNodeUserId(loginUser.getUserId());
        instance.setProcCurrNodeUserName(loginUser.getUsername());
        instance.setProcId(processInstance.getId());
        instance.setProcDefinitionId(procInstance.getProcDefinitionId());
        instance.setProcKey(processInstance.getProcessDefinitionKey());
        instance.setProcState("1");
        procInstanceMapper.insert(instance);
    }

    @Override
    public List<ProcTaskInstance> taskList() {
        LoginUser loginUser = LoginUserThreadLocal.getLoginUser();
        return procTaskInstanceMapper.queryByUserId(loginUser.getUserId());
    }
}
