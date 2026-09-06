package com.ziheng.system.sysuser.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * 用户新增/修改 DTO
 * 字段对应前端 UserAddType（userId 为空表示新增，不为空表示修改）
 */
@Data
public class SysUserAddDTO {

    /**
     * 用户ID，为空表示新增，不为空表示修改
     */
    private Long userId;

    /**
     * 用户名（登录账号）
     * 仅新增时必填；修改时不允许变更，后端会忽略该字段
     */
    @Size(max = 64, message = "用户名长度不能超过64个字符")
    private String username;

    /**
     * 用户昵称
     */
    @NotBlank(message = "用户昵称不能为空")
    @Size(max = 64, message = "用户昵称长度不能超过64个字符")
    private String nickname;

    /**
     * 部门ID
     */
    @NotNull(message = "部门不能为空")
    private Long deptId;

    /**
     * 手机号
     */
    @Size(max = 20, message = "手机号长度不能超过20个字符")
    private String phone;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 64, message = "邮箱长度不能超过64个字符")
    private String email;

    /**
     * 密码（新增时必填；修改时为空表示不修改原密码）
     */
    @Size(max = 100, message = "密码长度不能超过100个字符")
    private String password;

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
    @Size(max = 500, message = "备注长度不能超过500个字符")
    private String remark;
}
