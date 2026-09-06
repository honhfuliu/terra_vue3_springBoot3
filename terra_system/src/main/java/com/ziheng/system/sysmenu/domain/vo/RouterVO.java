package com.ziheng.system.sysmenu.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RouterVO implements Serializable {
    /**
     * 路由名称
     */
    private String name;

    /**
     * 路由路径
     */
    private String path;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 权限标识
     */
    private ArrayList<String> perms;
    /**
     * 路由元数据
     */
    private MetaVo meta;
    /**
     * 子路由
     */
    private List<RouterVO> children;
    /**
     * 重定向
     */
    private String redirect;

}
