package com.ziheng.system.sysuser.domain.dto;

import com.ziheng.common.core.domain.PageQuery;

public class SysUserQuery extends PageQuery {
    /**
     * 用户名称（模糊查询）
     */
    private String username;
    /**
     * 手机号（模糊查询）
     */
    private String phone;
    /**
     * 状态：0禁用 1正常
     */
    private String status;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 创建时间-开始
     */
    private String startTime;
    /**
     * 创建时间-结束
     */
    private String endTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
