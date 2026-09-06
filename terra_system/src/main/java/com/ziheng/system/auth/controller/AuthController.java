package com.ziheng.system.auth.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.ziheng.common.core.domain.R;
import com.ziheng.system.auth.domain.dto.LoginBody;
import com.ziheng.system.auth.domain.vo.LoginVo;
import com.ziheng.system.auth.domain.vo.UserPermissionVO;
import com.ziheng.system.auth.service.AuthService;
import com.ziheng.system.sysmenu.domain.SysMenu;
import com.ziheng.system.sysmenu.domain.vo.RouterVO;
import com.ziheng.system.sysmenu.service.SysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "认证管理")
public class AuthController {
    private final AuthService authService;
    private final SysMenuService sysMenuService;

    public AuthController(AuthService authService,  SysMenuService sysMenuService) {
        this.authService = authService;
        this.sysMenuService =sysMenuService;
    }
    @GetMapping("getRouters")
    @Operation(summary = "获取动态路由")
    public R<RouterVO> test(){
        List<SysMenu> sysMenuVOS = sysMenuService.selectMenuTreeByUserId(null);
        return R.ok(sysMenuService.convertToRouteTree(sysMenuVOS));
    }
    @GetMapping("permissions")
    @Operation(summary = "获取权限")
    @SaCheckLogin()
    public R<UserPermissionVO> getPermissions(){
        List<String> permissions = StpUtil.getPermissionList();
        List<String> roleList = StpUtil.getRoleList();
        UserPermissionVO userPermissionVO = new UserPermissionVO(permissions,roleList);
        return R.ok(userPermissionVO);
    }


    @PostMapping("login")
    @Operation(summary = "用户登录")
    public R<LoginVo> login(@Valid @RequestBody LoginBody loginBody) {
        return R.ok(authService.login(loginBody));
    }


    @PostMapping("logout")
    @Operation(summary = "退出登录")
    public R<Void> logout() {
        StpUtil.logout();
        return R.ok();
    }
}
