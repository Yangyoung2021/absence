package com.yang.absence.service.impl;

import com.yang.absence.entity.page.PageQueryParam;
import com.yang.absence.entity.page.PageResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yang.absence.entity.process.ProcInstancePO;
import com.yang.absence.mapper.ProcInstanceMapper;
import com.yang.absence.service.ProcInstanceService;

import java.util.List;

/**
 * ;(proc_instance)表服务实现类
 *
 * @author : http://www.chiner.pro
 * @date : 2022-10-22
 */
@Slf4j
@Service
public class ProcInstanceServiceImpl implements ProcInstanceService {
    @Autowired
    private ProcInstanceMapper procInstanceMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param procId 主键
     * @return 实例对象
     */
    public ProcInstancePO queryById(String procId) {
        return procInstanceMapper.queryById(procId);
    }

    /**
     * 分页查询
     *
     * @param pageQueryParam 筛选条件
     * @return 查询结果
     */
    public PageResultVO<ProcInstancePO> pageQuery(PageQueryParam pageQueryParam) {
        PageResultVO<ProcInstancePO> pageResult = new PageResultVO<>();
        pageResult.setTotalCount(procInstanceMapper.count(pageQueryParam.getParam()));
        int pageSize = pageQueryParam.getSize();
        int startIndex = (pageQueryParam.getPage() - 1) * pageSize;
        List<ProcInstancePO> data = procInstanceMapper.queryAllByLimit(startIndex,
                pageSize,
                pageQueryParam.getParam());
        pageResult.setData(data);
        return pageResult;
    }

    /**
     * 新增数据
     *
     * @param procInstance 实例对象
     */
    public void insert(ProcInstancePO procInstance) {
        procInstanceMapper.insert(procInstance);
    }

    /**
     * 更新数据
     *
     * @param procInstance 实例对象
     */
    public void update(ProcInstancePO procInstance) {
        procInstanceMapper.update(procInstance);
    }

    /**
     * 通过主键删除数据
     *
     * @param procId 主键
     */
    public void deleteById(String procId) {
        int total = procInstanceMapper.deleteById(procId);
        log.info("删除数据{}条", total);
    }
}