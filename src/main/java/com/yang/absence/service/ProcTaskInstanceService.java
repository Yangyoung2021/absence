package com.yang.absence.service;

import com.yang.absence.entity.page.PageQueryParam;
import com.yang.absence.entity.page.PageResultVO;
import com.yang.absence.entity.ProcTaskInstance;

 /**
 * 流程任务实例表;(proc_task_instance)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2022-10-23
 */
public interface ProcTaskInstanceService{
    /** 
     * 通过ID查询单条数据 
     *
     * @param taskId 主键
     * @return 实例对象
     */
    ProcTaskInstance queryById(String taskId);
    /** 
     * 分页查询
     *
     * @param pageQueryParam 筛选条件
     * @return 查询结果
     */
    PageResultVO<ProcTaskInstance> pageQuery(PageQueryParam pageQueryParam);
    /** 
     * 新增数据
     *
     * @param procTaskInstance 实例对象
     */
    void insert(ProcTaskInstance procTaskInstance);
    /** 
     * 更新数据
     *
     * @param procTaskInstance 实例对象
     */
    void update(ProcTaskInstance procTaskInstance);
    /** 
     * 通过主键删除数据
     *
     * @param taskId 主键
     */
    void deleteById(String taskId);
}