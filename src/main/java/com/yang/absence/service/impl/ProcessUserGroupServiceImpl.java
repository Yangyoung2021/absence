package com.yang.absence.service.impl;

import com.yang.absence.entity.process.ProcessUserGroup;
import com.yang.absence.mapper.ProcessUserGroupMapper;
import com.yang.absence.service.ProcessUserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 14:58
 */
@Slf4j
@Service
public class ProcessUserGroupServiceImpl implements ProcessUserGroupService {

    @Autowired
    private ProcessUserGroupMapper processUserGroupMapper;

    @Override
    public List<ProcessUserGroup> listAll() {
        return processUserGroupMapper.listAllGroup();
    }
}
