package com.ziheng.system.sysmenu.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单排序 DTO（树形结构，结构与 /list 接口返回一致）
 */
@Data
public class SysMenuSortDTO {

    /**
     * 菜单ID
     */
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;

    /**
     * 显示排序
     */
    @NotNull(message = "排序不能为空")
    @Min(value = 0, message = "排序值不能小于0")
    private Integer menuSort;

    /**
     * 子菜单
     */
    private List<SysMenuSortDTO> children = new ArrayList<>();
}
