package com.yang.absence.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

 /**
 * 流程任务实例表;
 * @author : http://www.chiner.pro
 * @date : 2022-10-23
 */
@ApiModel(value = "流程任务实例表",description = "流程任务实例表")
@Data
public class ProcTaskInstance implements Serializable {
    /** 流程id */
    @ApiModelProperty(name = "流程id")
    private String processId ;
    /** 任务id */
    @ApiModelProperty(name = "任务id")
    private String taskId ;
    /** 任务节点key */
    @ApiModelProperty(name = "任务节点key")
    private String taskKey ;
    /** 任务名称 */
    @ApiModelProperty(name = "任务名称")
    private String taskName ;
    /** 应审批用户id */
    @ApiModelProperty(name = "应审批用户id")
    private String shouldUserId ;
    /** 应审批用户名称 */
    @ApiModelProperty(name = "应审批用户名称")
    private String shouldUserName ;
    /** 实际处理用户id */
    @ApiModelProperty(name = "实际处理用户id")
    private String handleUserId ;
    /** 实际处理用户名称 */
    @ApiModelProperty(name = "实际处理用户名称")
    private String handleUserName ;
    /** 处理时间 */
    @ApiModelProperty(name = "处理时间")
    private Date handleTime ;
    /** 审批已将 */
    @ApiModelProperty(name = "审批意见")
    private String handleOpinion ;
    /** 处理类型（2审批通过3审批不通过） */
    @ApiModelProperty(name = "处理类型（2审批通过3审批不通过）")
    private Integer handleType ;
}