package com.yang.absence.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.yang.absence.entity.process.ProcTaskInstance;

/**
 * 流程任务实例表;(proc_task_instance)表数据库访问层
 *
 * @author : http://www.chiner.pro
 * @date : 2022-10-23
 */
@Mapper
public interface ProcTaskInstanceMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param taskId 主键
     * @return 实例对象
     */
    ProcTaskInstance queryById(String taskId);

    /**
     * 分页查询数据
     *
     * @param starIndex 起始索引
     * @param size      每页展示条数
     * @param param     查询参数
     * @return 列表数据
     */
    List<ProcTaskInstance> queryAllByLimit(@Param("startIndex") int starIndex,
                                           @Param("size") int size,
                                           @Param("param") Map<String, Object> param);

    /**
     * 统计总行数
     *
     * @param param 查询条件
     * @return 总行数
     */
    long count(Map<String, Object> param);

    /**
     * 新增数据
     *
     * @param procTaskInstance 实例对象
     * @return 影响行数
     */
    int insert(ProcTaskInstance procTaskInstance);

    /**
     * 批量新增数据
     *
     * @param entities List<ProcTaskInstance> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProcTaskInstance> entities);

    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<ProcTaskInstance> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ProcTaskInstance> entities);

    /**
     * 更新数据
     *
     * @param procTaskInstance 实例对象
     * @return 影响行数
     */
    int update(ProcTaskInstance procTaskInstance);

    /**
     * 通过主键删除数据
     *
     * @param taskId 主键
     * @return 影响行数
     */
    int deleteById(String taskId);

    /**
     * 通过用户id查询代办
     *
     * @param userId 登录用户id
     * @return 代办列表
     */
    List<ProcTaskInstance> queryByUserId(String userId);
}