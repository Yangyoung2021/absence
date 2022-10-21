package com.yang.absence.controller;

import com.yang.absence.entity.Result;
import com.yang.absence.entity.ResultCode;
import com.yang.absence.exception.BusinessException;
import com.yang.absence.service.ProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

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
	private ProcessService processService;
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

	@GetMapping(value = "/test")
	@ApiOperation(value = "测试统一处理接口")
	public Result test(@RequestParam("message") String message) {
		if ("测试".equals(message)) {
			throw new BusinessException("测试异常信息！");
		}
		if ("未知异常".equals(message)) {
			int a = 1 / 0;
		}
		return new Result(ResultCode.SUCCESS);
	}
}
