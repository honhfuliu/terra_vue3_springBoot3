package com.ziheng.system.auth.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPermissionVO {
    /**
     * 当前用户权限
     */
    private List<String> permissions;

    /**
     * 当前用户角色
     */
    private List<String> roles;
}
