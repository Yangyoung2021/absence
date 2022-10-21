package com.yang.absence.entity.process;

import lombok.Data;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 0:58
 */
@Data
public class ProcessDefinitionPo {

    private String id;
    private String name;
    private String tenantId;
    private String deploymentId;
    private String key;
    private String EngineVersion;
    private String resourceName;
    private String category;
    private String description;
    private String diagramResourceName;
    private String version;
}
