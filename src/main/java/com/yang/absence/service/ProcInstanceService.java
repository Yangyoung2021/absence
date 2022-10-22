package com.yang.absence.service;

import com.yang.absence.entity.page.PageQueryParam;
import com.yang.absence.entity.page.PageResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.yang.absence.entity.process.ProcInstance;

 /**
 * ;(proc_instance)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2022-10-22
 */
public interface ProcInstanceService{
    /** 
     * 通过ID查询单条数据 
     *
     * @param procId 主键
     * @return 实例对象
     */
    ProcInstance queryById(String procId);
    /** 
     * 分页查询
     *
     * @param pageQueryParam 筛选条件
     * @return 查询结果
     */
    PageResultVO<ProcInstance> pageQuery(PageQueryParam pageQueryParam);
    /** 
     * 新增数据
     *
     * @param procInstance 实例对象
     */
    void insert(ProcInstance procInstance);
    /** 
     * 更新数据
     *
     * @param procInstance 实例对象
     */
    void update(ProcInstance procInstance);
    /** 
     * 通过主键删除数据
     *
     * @param procId 主键
     * @return 是否成功
     */
    void deleteById(String procId);
}