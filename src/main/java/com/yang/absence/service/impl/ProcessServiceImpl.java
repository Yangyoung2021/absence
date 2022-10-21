package com.yang.absence.service.impl;

import com.yang.absence.exception.BusinessException;
import com.yang.absence.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 流程部署
	 * @param file  上传bpmn文件
	 * @param companyId  企业id
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
}
