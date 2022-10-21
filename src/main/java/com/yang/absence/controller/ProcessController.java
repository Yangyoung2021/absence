package com.yang.absence.controller;

import com.yang.absence.entity.Result;
import com.yang.absence.entity.ResultCode;
import com.yang.absence.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 流程控制的controller
 * @author 19816
 */
@CrossOrigin
@RestController
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
	public Result deployProcess(@RequestParam("file") MultipartFile file) throws IOException {
		processService.deployProcess(file,COMPANY_ID);
		return new Result(ResultCode.SUCCESS);
	}
}
