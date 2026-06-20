package com.ziheng.system.sysmenu.domain.vo;

import java.io.Serializable;
import java.util.List;

public class SysMenuVO implements Serializable {

    private String name;
    private String path;
    private String component;
    private String visible;
    private String perms;
    private MetaVo meta;
    private List<SysMenuVO> children;

    @Override
    public String toString() {
        return "SysMenuVO{" +
                "menuName='" + name + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", visible='" + visible + '\'' +
                ", perms='" + perms + '\'' +
                ", meta=" + meta +
                ", children=" + children +
                '}';
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public MetaVo getMeta() {
        return meta;
    }

    public void setMeta(MetaVo meta) {
        this.meta = meta;
    }

    public List<SysMenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuVO> children) {
        this.children = children;
    }

    public SysMenuVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysMenuVO(String name, String path, String component, String visible, String perms, MetaVo meta, List<SysMenuVO> children) {
        this.name = name;
        this.path = path;
        this.component = component;
        this.visible = visible;
        this.perms = perms;
        this.meta = meta;
        this.children = children;
    }
}
