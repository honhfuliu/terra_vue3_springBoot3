package com.ziheng.system.sysmenu.domain.enums;

public enum MenuType {
    DIRECTORY("目录", "M"),
    MENU("菜单", "M"),
    BUTTON("按钮", "F"),
    LINK("外链", "L"),
    PERMISSION("权限", "P");

    private final String name;
    private final String code;

    MenuType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
