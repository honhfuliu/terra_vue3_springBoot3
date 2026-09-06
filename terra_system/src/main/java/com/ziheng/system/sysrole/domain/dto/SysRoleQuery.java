package com.ziheng.system.sysrole.domain.dto;

import com.ziheng.common.core.domain.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色分页查询条件
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleQuery extends PageQuery {

    /**
     * 角色名称（模糊查询）
     */
    private String name;

    /**
     * 角色标识（模糊查询）
     */
    private String roleKey;

    /**
     * 状态 0禁用 1正常
     */
    private String status;

    /**
     * 创建时间-开始（含当天则传 yyyy-MM-dd，精确到时分秒则传 yyyy-MM-dd HH:mm:ss）
     */
    private String startTime;

    /**
     * 创建时间-结束（含当天则传 yyyy-MM-dd，精确到时分秒则传 yyyy-MM-dd HH:mm:ss）
     */
    private String endTime;
}
