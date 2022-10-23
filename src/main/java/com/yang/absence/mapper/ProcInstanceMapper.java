package com.yang.absence.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.yang.absence.entity.process.ProcInstancePO;

 /**
 * ;(proc_instance)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2022-10-22
 */
@Mapper
public interface ProcInstanceMapper{
    /** 
     * 通过ID查询单条数据 
     *
     * @param procId 主键
     * @return 实例对象
     */
    ProcInstancePO queryById(String procId);

     /**
      * 分页查询
      * @param starIndex 起始行数
      * @param size 每页显示条数
      * @param param 参数
      * @return 列表
      */
    List<ProcInstancePO> queryAllByLimit(@Param("startIndex") int starIndex,
                                         @Param("size") int size,
                                         @Param("param") Map<String, Object> param);
    /** 
     * 统计总行数
     *
     * @param procInstance 查询条件
     * @return 总行数
     */
    long count(Map<String, Object> procInstance);
    /** 
     * 新增数据
     *
     * @param procInstance 实例对象
     * @return 影响行数
     */
    int insert(ProcInstancePO procInstance);
    /** 
     * 批量新增数据
     *
     * @param entities List<ProcInstance> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProcInstancePO> entities);
    /** 
     * 批量新增或按主键更新数据
     *
     * @param entities List<ProcInstance> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ProcInstancePO> entities);
    /** 
     * 更新数据
     *
     * @param procInstance 实例对象
     * @return 影响行数
     */
    int update(ProcInstancePO procInstance);
    /** 
     * 通过主键删除数据
     *
     * @param procId 主键
     * @return 影响行数
     */
    int deleteById(String procId);
}