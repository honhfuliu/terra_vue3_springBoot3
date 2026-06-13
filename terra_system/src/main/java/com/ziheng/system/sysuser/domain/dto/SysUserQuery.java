package com.ziheng.system.sysuser.domain.dto;

import com.ziheng.common.core.domain.PageQuery;

public class SysUserQuery extends PageQuery {
    private String username;
    private String nickname;
    private Integer status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
