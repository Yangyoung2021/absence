package com.yang.absence.mapper;


import com.yang.absence.entity.ProcessUserGroup;

import java.util.List;

/**
 * @author 19816097
 */
public interface ProcessUserGroupMapper {

    /**
     * 查询所有用户分组信息
     * @return 用户分组列表
     */
    List<ProcessUserGroup> listAllGroup();
}
