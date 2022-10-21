package com.yang.absence;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class AbsenceApplicationTests {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void contextLoads() {
    }


    @Test
    void testRepositoryService() {
        log.info("----------------------------------------");
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        repositoryService.createDeploymentQuery().list();
        log.info("{}", list.size());
    }
}
