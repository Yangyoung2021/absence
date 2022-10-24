package com.yang.absence.controller;

import com.yang.absence.entity.Result;
import com.yang.absence.entity.ResultCode;
import com.yang.absence.exception.BusinessException;
import com.yang.absence.service.impl.ProcessServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 流程控制的controller
 * @author 19816
 */
@CrossOrigin
@RestController
@Api(tags = "请假流程")
@RequestMapping(value="/user/process")
public class ProcessController {

	@Autowired
	private ProcessServiceImpl processService;
	private static final String COMPANY_ID = "XYY";

	/**
	 * 部署新流程
	 *     前端将绘制好的流程模型图(bpmn)文件上传到方法中
	 *     参数 : 上传的文件
	 *          MultipartFile
	 */
	@PostMapping(value = "/deploy")
	@ApiOperation(value = "流程部署接口")
	public Result deployProcess(@RequestParam("file") MultipartFile file) throws IOException {
		processService.deployProcess(file,COMPANY_ID);
		return new Result(ResultCode.SUCCESS);
	}

	/**
	 * 查询登录用户对应的所有流程
	 */
	@GetMapping(value = "/processDefinitionList")
	@ApiOperation(value = "查询流程定义列表")
	public Result processDefinitionList(@RequestParam("tenantId") String tenantId) {
		return new Result(processService.processDefinitionList(tenantId));
	}

	/**
	 * 修改某个流程的状态
	 */
	@PutMapping(value = "/updateProcessStatus")
	@ApiOperation(value = "更新指定的流程状态")
	public Result updateProcessStatus(@RequestParam List<String> processDefinitionIds) {
		processService.updateProcessStatus(processDefinitionIds, COMPANY_ID);
		return new Result();
	}

}
