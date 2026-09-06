package com.ziheng.system.sysmenu.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaVo implements Serializable {
    /**
     * 菜单标题
     */
    private String title;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 是否隐藏菜单
     */
    private boolean hidden;

    /**
     * 是否缓存
     */
    private Boolean keepAlive;

}
