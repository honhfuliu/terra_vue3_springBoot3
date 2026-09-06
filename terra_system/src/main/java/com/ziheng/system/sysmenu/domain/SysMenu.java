package com.ziheng.system.sysmenu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单权限表
 * @TableName sys_menu
 */
@Data
@TableName(value ="sys_menu")
public class SysMenu implements Serializable {
    /**
     * 菜单ID
     */
    @TableId(type = IdType.AUTO)
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID
     */
    private Long parentId;


    /**
     * 路由名称
     */
    private String name;

    /**
     * 显示顺序
     */
    private Integer menuSort;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 菜单类型 M目录 C菜单 F按钮
     */
    private String menuType;

    /**
     * 是否可见 0隐藏 1显示
     */
    private String visible;

    /**
     * 状态 0禁用 1正常
     */
    private String status;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标志 0存在 1删除
     */
    private String delFlag;

    /**
     * 子菜单（非表字段）
     */
    @TableField(exist = false)
    private List<SysMenu> children;

    /**
     * 是否缓存
     */
    private String redirect;

    /**
     * 重定向地址
     */
    private String keepAlive;



}