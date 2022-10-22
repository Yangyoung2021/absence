package com.yang.absence.entity.page;

import lombok.Data;

import java.util.Map;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 22:02
 */
@Data
public class PageQueryParam {
    private static final long serialVersionUID = -12424933063071740L;
    private int page;
    private int size;
    private String sortBy;
    private Map<String, Object> param;
}
