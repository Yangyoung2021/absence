package com.yang.absence.entity.dto;

import lombok.Data;

/**
 * @author xiongyangyang
 * @version 2.1.2.0
 * @date 2022/10/24 10:15
 */

@Data
public class TaskDTO {
    private String processId;
    private String taskId;
    private String taskKey;
    private String taskName;
    private String handleOpinion;
    private String handleType;
}
