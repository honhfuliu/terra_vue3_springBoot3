package com.ziheng.system.sysuser.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * 用户编辑回显 VO
 * 字段与新增/编辑提交的 SysUserAddDTO 一致，但不返回用户名与密码
 */
@Data
public class SysUserEditVO {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别 0未知 1男 2女
     */
    private String sex;

    /**
     * 状态 0禁用 1正常
     */
    private String status;

    /**
     * 角色ID集合（sys_user_role 关联表）
     */
    private List<Long> roleIds;

    /**
     * 备注
     */
    private String remark;
}
