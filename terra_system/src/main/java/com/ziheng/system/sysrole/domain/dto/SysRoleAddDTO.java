package com.ziheng.system.sysrole.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * 角色新增/修改 DTO
 */
@Data
public class SysRoleAddDTO {

    /**
     * 角色ID，为空表示新增，不为空表示修改
     */
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 64, message = "角色名称长度不能超过64个字符")
    private String roleName;

    /**
     * 角色标识
     */
    @NotBlank(message = "角色标识不能为空")
    @Size(max = 100, message = "角色标识长度不能超过100个字符")
    private String roleKey;

    /**
     * 显示顺序
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    /**
     * 状态 0禁用 1正常
     */
    private String status;

    /**
     * 菜单权限ID集合（sys_role_menu 关联表）
     */
    private List<Long> menuPermissions;

    /**
     * 备注
     */
    @Size(max = 500, message = "备注长度不能超过500个字符")
    private String remark;
}
