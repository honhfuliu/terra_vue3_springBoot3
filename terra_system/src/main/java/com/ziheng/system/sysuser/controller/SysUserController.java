package com.ziheng.system.sysuser.controller;

import com.ziheng.common.core.domain.PageResult;
import com.ziheng.common.core.domain.R;
import com.ziheng.system.sysuser.domain.dto.SysUserQuery;
import com.ziheng.system.sysuser.domain.vo.SysUserVo;
import com.ziheng.system.sysuser.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试接口")
@RequestMapping("/system/user")
public class SysUserController {
    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @GetMapping("/list")
    @Operation(summary = "用户查询")
    public R<PageResult<SysUserVo>> list(SysUserQuery query) {
        return R.ok(sysUserService.listUsers(query));
    }
}
