package com.ziheng.system.sysdept.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门排序 DTO（树形结构，结构与 /list 接口返回一致）
 */
@Data
public class SysDeptSortDTO {

    /**
     * 部门ID
     */
    @NotNull(message = "部门ID不能为空")
    private Long deptId;

    /**
     * 显示排序
     */
    @NotNull(message = "排序不能为空")
    @Min(value = 0, message = "排序值不能小于0")
    private Integer sortOrder;

    /**
     * 子部门
     */
    private List<SysDeptSortDTO> children = new ArrayList<>();
}
