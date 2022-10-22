package com.yang.absence.entity.page;

import lombok.Data;

import java.util.List;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/22 22:04
 */
@Data
public class PageResultVO<T> {

    private static final long serialVersionUID = -1242493063071740L;
    private long totalCount;
    private List<T> data;
}
