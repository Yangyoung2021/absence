package com.yang.absence.controller;

import com.yang.absence.entity.ProcessUserGroup;
import com.yang.absence.entity.Result;
import com.yang.absence.service.ProcessUserGroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 14:51
 */
@CrossOrigin
@Api(tags = "用户分组")
@RequestMapping("/user/group")
@RestController
public class ProcessUserGroupController {

    @Autowired
    private ProcessUserGroupService processUserGroupService;

    @GetMapping("/listAll")
    public Result listAll() {
        return new Result(processUserGroupService.listAll());
    }

}
