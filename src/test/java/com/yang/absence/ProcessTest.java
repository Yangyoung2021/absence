package com.yang.absence;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 0:15
 */
@Slf4j
@SpringBootTest
public class ProcessTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void queryProcessDefinition() {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> definitionList =
                processDefinitionQuery.processDefinitionTenantId("XYY").latestVersion().list();
        for (ProcessDefinition processDefinition : definitionList) {
            log.info("processDefinition.Id() --> {}", processDefinition.getId());
            log.info("processDefinition.Name() --> {}", processDefinition.getName());
            log.info("processDefinition.Key() --> {}", processDefinition.getKey());
            log.info("processDefinition.DeploymentId() --> {}", processDefinition.getDeploymentId());
            log.info("processDefinition.TenantId() --> {}", processDefinition.getTenantId());
            log.info("processDefinition.EngineVersion() --> {}", processDefinition.getEngineVersion());
            log.info("processDefinition.ResourceName() --> {}", processDefinition.getResourceName());
        }
    }
}
