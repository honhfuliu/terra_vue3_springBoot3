package com.ziheng.system.sysdept.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门树VO（用于选择上级部门）
 */
@Data
public class SysDeptTreeVO implements Serializable {

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 子部门
     */
    private List<SysDeptTreeVO> children = new ArrayList<>();
}
