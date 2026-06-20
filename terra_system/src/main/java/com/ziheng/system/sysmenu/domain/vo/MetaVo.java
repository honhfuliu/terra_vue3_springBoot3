package com.ziheng.system.sysmenu.domain.vo;

import java.io.Serializable;

public class MetaVo implements Serializable {
    // 标题
    private String title;
    // 图标
    private String icon;
    // 是否缓存
//    private Boolean noCache;


    public MetaVo() {
    }

    public MetaVo(String title, String icon) {
        this.title = title;
        this.icon = icon;
//        this.noCache = noCache;

    }

    @Override
    public String toString() {
        return "MetaVo{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +

                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }




}
