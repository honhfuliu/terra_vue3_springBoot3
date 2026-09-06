package com.ziheng.system.sysdept.domain.dto;

import lombok.Data;

/**
 * 部门查询条件
 */
@Data
public class SysDeptQuery {

    /**
     * 部门名称（模糊查询）
     */
    private String deptName;

    /**
     * 状态：1正常，0停用
     */
    private String status;
}
