package com.ziheng.system.sysmenu.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 菜单新增/修改 DTO
 */
@Data
public class SysMenuAddDTO {

    /**
     * 菜单ID，为空表示新增，不为空表示修改
     */
    private Long menuId;

    /**
     * 上级菜单ID，0表示根节点（主类目）
     */
    private Long parentId;

    /**
     * 菜单类型 M目录 C菜单 F按钮
     */
    @NotBlank(message = "菜单类型不能为空")
    private String menuType;

    /**
     * 显示排序
     */
    @NotNull(message = "显示排序不能为空")
    @Min(value = 0, message = "排序值不能小于0")
    private Integer menuSort;

    /**
     * 菜单图标
     */
    @Size(max = 100, message = "菜单图标长度不能超过100个字符")
    private String icon;

    /**
     * 菜单名称
     */
    @NotBlank(message = "菜单名称不能为空")
    @Size(max = 64, message = "菜单名称长度不能超过64个字符")
    private String menuName;

    /**
     * 路由地址
     */
    @Size(max = 200, message = "路由地址长度不能超过200个字符")
    private String path;

    /**
     * 显示状态 0隐藏 1显示
     */
    private String visible;

    /**
     * 菜单状态 0禁用 1正常
     */
    private String status;

    /**
     * 路由名称
     */
    @Size(max = 100, message = "路由名称长度不能超过100个字符")
    private String name;

    /**
     * 组件地址
     */
    @Size(max = 255, message = "组件地址长度不能超过255个字符")
    private String component;

    /**
     * 权限字符
     */
    @Size(max = 100, message = "权限字符长度不能超过100个字符")
    private String perms;

    /**
     * 是否缓存 0否 1是
     */
    private Integer keepAlive;
}
