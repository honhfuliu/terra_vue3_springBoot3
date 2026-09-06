package com.ziheng.system.sysmenu.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单树VO（用于选择上级菜单）
 */
@Data
public class SysMenuTreeVO implements Serializable {

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 子菜单
     */
    private List<SysMenuTreeVO> children = new ArrayList<>();
}
