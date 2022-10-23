package com.yang.absence.controller;

import com.yang.absence.entity.Result;
import com.yang.absence.entity.page.PageQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yang.absence.entity.process.ProcInstancePO;
import com.yang.absence.service.ProcInstanceService;

/**
 * ;(proc_instance)表控制层
 *
 * @author : http://www.chiner.pro
 * @date : 2022-10-22
 */
@Api(tags = "流程实例对象功能接口")
@Slf4j
@RestController
@RequestMapping("/procInstance")
public class ProcInstanceController {

    @Autowired
    private ProcInstanceService procInstanceService;

    /**
     * 通过ID查询单条数据
     *
     * @param procId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{procId}")
    public Result queryById(@PathVariable() String procId) {
        return new Result(procInstanceService.queryById(procId));
    }

    /**
     * 分页查询
     *
     * @param pageQueryParam 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("/list")
    public Result pageQuery(@RequestBody PageQueryParam pageQueryParam) {
        return new Result(procInstanceService.pageQuery(pageQueryParam));
    }

    /**
     * 新增数据
     *
     * @param procInstance 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result add(@RequestBody ProcInstancePO procInstance) {
        procInstanceService.insert(procInstance);
        return new Result();
    }

    /**
     * 更新数据
     *
     * @param procInstance 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public Result edit(@RequestBody ProcInstancePO procInstance) {
        log.info("接收到的参数对象：{}", procInstance);
        procInstanceService.update(procInstance);
        return new Result();
    }

    /**
     * 通过主键删除数据
     *
     * @param procId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public Result deleteById(String procId) {
        procInstanceService.deleteById(procId);
        return new Result();
    }
}