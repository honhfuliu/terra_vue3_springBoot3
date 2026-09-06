package com.ziheng.system.sysmenu.domain.vo;

import com.ziheng.system.sysmenu.domain.SysMenu;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单列表树VO（用于菜单管理表格展示）
 */
@Data
public class SysMenuListVO implements Serializable {

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单类型 M目录 C菜单 F按钮
     */
    private String menuType;

    /**
     * 显示顺序
     */
    private Integer menuSort;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 状态：1正常，0停用
     */
    private String status;

    /**
     * 子菜单
     */
    private List<SysMenuListVO> children = new ArrayList<>();

    public static SysMenuListVO from(SysMenu menu) {
        SysMenuListVO vo = new SysMenuListVO();
        vo.setMenuId(menu.getMenuId());
        vo.setMenuName(menu.getMenuName());
        vo.setMenuType(menu.getMenuType());
        vo.setMenuSort(menu.getMenuSort());
        vo.setPerms(menu.getPerms());
        vo.setComponent(menu.getComponent());
        vo.setStatus(menu.getStatus());
        return vo;
    }
}
