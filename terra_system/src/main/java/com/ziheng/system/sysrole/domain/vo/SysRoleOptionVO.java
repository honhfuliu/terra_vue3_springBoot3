package com.ziheng.system.sysrole.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色选项VO（用于前端角色选择框，仅含角色ID与名称）
 */
@Data
public class SysRoleOptionVO implements Serializable {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;
}
