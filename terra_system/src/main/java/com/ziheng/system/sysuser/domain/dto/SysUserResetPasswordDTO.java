package com.ziheng.system.sysuser.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 重置密码 DTO
 * 与前端 ResetPasswordType 保持一致：userId + username(二次确认) + password(新密码)
 */
@Data
public class SysUserResetPasswordDTO {

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 用户名（用于二次确认，需与数据库一致）
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 新密码（原文，后端将重新生成盐值并加密存储）
     */
    @NotBlank(message = "新密码不能为空")
    @Size(min = 6, max = 32, message = "密码长度需在6-32位之间")
    private String password;
}
