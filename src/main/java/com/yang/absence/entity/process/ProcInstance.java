package com.yang.absence.entity.process;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ;
 * @author : http://www.chiner.pro
 * @date : 2022-10-22
 */
@ApiModel(value = "流程实例对象",description = "流程实例对象")
@Data
public class ProcInstance implements Serializable{
    private static final long serialVersionUID = -1242493306307174690L;
    /**  */
    @ApiModelProperty(name = "主键id",notes = "null")
    private String procId ;
    /** 主键id */
    @ApiModelProperty(name = "流程定义id")
    private String procDefinitionId ;
    /** 流程标识主键 */
    @ApiModelProperty(name = "流程标识主键")
    private String procKey ;
    /** 流程名称 */
    @ApiModelProperty(name = "流程名称")
    private String procName ;
    /** 流程状态（1、审批中;2、审批通过 3、审批不通过 4、撤销） */
    @ApiModelProperty(name = "流程状态（1、审批中",notes = "2、审批通过 3、审批不通过 4、撤销）")
    private String procState ;
    /** 申请人id */
    @ApiModelProperty(name = "申请人id")
    private String userId ;
    /** 申请人姓名 */
    @ApiModelProperty(name = "申请人姓名")
    private String username ;
    /** 申请人部门id */
    @ApiModelProperty(name = "申请人部门id")
    private String deptId ;
    /** 申请人部门名称 */
    @ApiModelProperty(name = "申请人部门名称")
    private String deptName ;
    /** 入职时间 */
    @ApiModelProperty(name = "入职时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeOfEntry ;
    /** 当前节点审批人id */
    @ApiModelProperty(name = "当前节点审批人id")
    private String procCurrNodeUserId ;
    /** 当前节点审批人姓名 */
    @ApiModelProperty(name = "当前节点审批人姓名")
    private String procCurrNodeUserName ;
    /** 流程申请时间 */
    @ApiModelProperty(name = "流程申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date procApplyTime ;
    /** 流程结束时间 */
    @ApiModelProperty(name = "流程结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date procEndTime ;
    /** 流程的业务数据 */
    @ApiModelProperty(name = "流程的业务数据")
    private String procData ;
}
