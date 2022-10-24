package com.yang.absence.service;

import com.yang.absence.entity.dto.TaskDTO;
import com.yang.absence.entity.process.ProcInstancePO;
import com.yang.absence.entity.process.ProcTaskInstance;
import com.yang.absence.entity.process.ProcessDefinitionPo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 0:25
 */
public interface ProcessService {

    /**
     * 部署流程
     *
     * @param file      流程文件（bpmn流程定义文件）
     * @param companyId 租客id
     * @throws IOException 异常
     */
    void deployProcess(MultipartFile file, String companyId) throws IOException;

    /**
     * 查询当前登录用户的流程定义列表
     *
     * @param tenantId 租客id
     * @return 流程定义列表
     */
    List<ProcessDefinitionPo> processDefinitionList(String tenantId);

    /**
     * 修改某个公司的某些流程状态
     *
     * @param processDefinitionIds 需要修改的流程id
     * @param companyId            公司id
     */
    void updateProcessStatus(List<String> processDefinitionIds, String companyId);

    /**
     * 完成选中的任务
     *
     * @param tasks 任务id列表
     */
    void completeTasks(List<TaskDTO> tasks);

    /**
     * 开启流程
     *
     * @param procInstance 流程id列表
     */
    void startProcess(ProcInstancePO procInstance);

    /**
     * 查询代办
     *
     * @return  userId    代办列表
     */
    List<ProcTaskInstance> taskList();
}
