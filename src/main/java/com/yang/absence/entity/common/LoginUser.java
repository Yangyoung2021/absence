package com.yang.absence.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/23 23:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {

    private String userId;
    private String username;
    private String deptId;
    private String deptName;
}
