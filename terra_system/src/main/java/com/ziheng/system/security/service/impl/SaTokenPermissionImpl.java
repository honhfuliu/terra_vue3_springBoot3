package com.ziheng.system.security.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.ziheng.system.sysmenu.mapper.SysMenuMapper;
import com.ziheng.system.sysrole.mapper.SysRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaTokenPermissionImpl implements StpInterface {
    private final SysMenuMapper sysMenuMapper;
    private final SysRoleMapper sysRoleMapper;

    private static final Logger log = LoggerFactory.getLogger(SaTokenPermissionImpl.class);

    public SaTokenPermissionImpl(SysMenuMapper sysMenuMapper, SysRoleMapper sysRoleMapper) {
        this.sysMenuMapper = sysMenuMapper;
        this.sysRoleMapper = sysRoleMapper;
    }


//    /**
//     * 获取权限列表
//     * @param userId
//     * @return
//     */
//    @Override
//    public List<String> getPermissionList(Long userId) {
//        List<String> permissions = sysMenuMapper.findPermissionsByUserId(userId);
//        if (permissions.isEmpty()){
//            return List.of();
//        }
//        log.info("用户{}的权限列表:{}", userId, permissions);
//        return permissions;
//    }
//
//    /**
//     * 获取角色列表
//     * @param userId
//     * @return
//     */
//    @Override
//    public List<String> getRoleList(Long userId) {
//        List<String> roles = sysRoleMapper.findRolesByUserId(userId);
//        if (roles.isEmpty()){
//            return List.of();
//        }
//        log.info("用户{}的角色列表:{}", userId, roles);
//        return roles;
//    }
    /**
     * 获取权限列表
     * @param loginId
     * @param loginType
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.info("loginId:{},loginType:{}", loginId, loginType);
        Long userId = Long.valueOf(loginId.toString());
        List<String> permissions = sysMenuMapper.findPermissionsByUserId(userId);
        if (permissions.isEmpty()){
            return List.of();
        }
        log.info("用户ID{}登录类型{}的权限列表:{}", loginId, loginType, permissions);
        return permissions;
    }

    /**
     * 获取角色列表
     * @param loginId
     * @param loginType
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        log.info("loginId:{},loginType:{}", loginId, loginType);
        Long userId = Long.valueOf(loginId.toString());
        List<String> roles = sysRoleMapper.findRolesByUserId(userId);
        if (roles.isEmpty()){
            return List.of();
        }
        log.info("用户{}登录类型{}的角色列表:{}", loginId, loginType, roles);
        return roles;
    }
}
