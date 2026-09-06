package com.ziheng.system.sysmenu.domain.dto;

import lombok.Data;

/**
 * 菜单查询条件
 */
@Data
public class SysMenuQuery {

    /**
     * 菜单名称（模糊查询）
     */
    private String menuName;

    /**
     * 状态：1正常，0停用
     */
    private String status;
}
