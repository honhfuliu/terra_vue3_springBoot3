package com.ziheng.common.core.domain;

import java.io.Serial;
import java.io.Serializable;

public class PageQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_PAGE_NUM = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int MAX_PAGE_SIZE = 100;

    private Integer pageNum = DEFAULT_PAGE_NUM;
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    public Integer getPageNum() {
        return pageNum == null || pageNum < 1 ? DEFAULT_PAGE_NUM : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1) {
            return DEFAULT_PAGE_SIZE;
        }
        return Math.min(pageSize, MAX_PAGE_SIZE);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
