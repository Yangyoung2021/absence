package com.yang.absence.service.impl;

import com.yang.absence.entity.page.PageQueryParam;
import com.yang.absence.entity.page.PageResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yang.absence.entity.process.ProcTaskInstance;
import com.yang.absence.mapper.ProcTaskInstanceMapper;
import com.yang.absence.service.ProcTaskInstanceService;

import java.util.List;

/**
 * 流程任务实例表;(proc_task_instance)表服务实现类
 *
 * @author : http://www.chiner.pro
 * @date : 2022-10-23
 */

@Slf4j
@Service
public class ProcTaskInstanceServiceImpl implements ProcTaskInstanceService {
    @Autowired
    private ProcTaskInstanceMapper procTaskInstanceMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param taskId 主键
     * @return 实例对象
     */
    public ProcTaskInstance queryById(String taskId) {
        return procTaskInstanceMapper.queryById(taskId);
    }

    /**
     * 分页查询
     *
     * @param pageQueryParam 筛选条件
     * @return 查询结果
     */
    public PageResultVO<ProcTaskInstance> pageQuery(PageQueryParam pageQueryParam) {
        PageResultVO<ProcTaskInstance> pageResult = new PageResultVO<>();
        pageResult.setTotalCount(procTaskInstanceMapper.count(pageQueryParam.getParam()));
        int pageSize = pageQueryParam.getSize();
        int startIndex = (pageQueryParam.getPage() - 1) * pageSize;
        List<ProcTaskInstance> data = procTaskInstanceMapper.queryAllByLimit(startIndex,
                pageSize,
                pageQueryParam.getParam());
        pageResult.setData(data);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param procTaskInstance 实例对象
     */
    public void insert(ProcTaskInstance procTaskInstance) {
        procTaskInstanceMapper.insert(procTaskInstance);
    }

    /**
     * 更新数据
     *
     * @param procTaskInstance 实例对象
     */
    public void update(ProcTaskInstance procTaskInstance) {
        procTaskInstanceMapper.update(procTaskInstance);
    }

    /**
     * 通过主键删除数据
     *
     * @param taskId 主键
     */
    public void deleteById(String taskId) {
        int total = procTaskInstanceMapper.deleteById(taskId);
        log.info("跟新数据{}条", total);
    }
}