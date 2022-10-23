package com.yang.absence.controller;

import com.yang.absence.entity.Result;
import com.yang.absence.entity.page.PageQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yang.absence.entity.process.ProcTaskInstance;
import com.yang.absence.service.ProcTaskInstanceService;

 /**
 * 流程任务实例表;(proc_task_instance)表控制层
 * @author : http://www.chiner.pro
 * @date : 2022-10-23
 */
@Api(tags = "流程任务实例表对象功能接口")
@RestController
@RequestMapping("/procTaskInstance")
public class ProcTaskInstanceController{
    @Autowired
    private ProcTaskInstanceService procTaskInstanceService;
    
    /** 
     * 通过ID查询单条数据 
     *
     * @param taskId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{taskId}")
    public Result queryById(@PathVariable("taskId") String taskId){
        return new Result(procTaskInstanceService.queryById(taskId));
    }
    
    /** 
     * 分页查询
     *
     * @param pageQueryParam 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("list")
    public Result pageQuery(@RequestBody PageQueryParam pageQueryParam){
        return new Result(procTaskInstanceService.pageQuery(pageQueryParam));
    }
    
    /** 
     * 新增数据
     *
     * @param procTaskInstance 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result add(ProcTaskInstance procTaskInstance){
        procTaskInstanceService.insert(procTaskInstance);
        return new Result();
    }
    
    /** 
     * 更新数据
     *
     * @param procTaskInstance 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public Result edit(ProcTaskInstance procTaskInstance){
        procTaskInstanceService.update(procTaskInstance);
        return new Result();
    }
    
    /** 
     * 通过主键删除数据
     *
     * @param taskId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public Result deleteById(String taskId){
        procTaskInstanceService.deleteById(taskId);
        return new Result();
    }
}