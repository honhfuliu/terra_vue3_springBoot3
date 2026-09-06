package com.ziheng.system.sysuser.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.ziheng.common.core.domain.PageResult;
import com.ziheng.common.core.domain.R;
import com.ziheng.system.sysuser.domain.dto.SysUserAddDTO;
import com.ziheng.system.sysuser.domain.dto.SysUserQuery;
import com.ziheng.system.sysuser.domain.dto.SysUserResetPasswordDTO;
import com.ziheng.system.sysuser.domain.vo.SysUserEditVO;
import com.ziheng.system.sysuser.domain.vo.SysUserVo;
import com.ziheng.system.sysuser.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "测试接口")
@RequestMapping("/system/user")
public class SysUserController {
    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @SaCheckPermission("system:user:list")
    @GetMapping("/list")
    @Operation(summary = "用户查询")
    public R<PageResult<SysUserVo>> list(SysUserQuery query) {
        return R.ok(sysUserService.listUsers(query));
    }

    /**
     * 新增或修改用户（userId 为空表示新增，不为空表示修改）
     */
    @PostMapping
    @SaCheckPermission(value = {"system:user:add", "system:user:edit"}, mode = SaMode.OR)
    @Operation(summary = "新增或修改用户")
    public R<Long> add(@Valid @RequestBody SysUserAddDTO dto) {
        return R.ok(sysUserService.addUser(dto));
    }

    /**
     * 查询用户编辑信息（与新增/编辑提交字段一致，但不返回用户名与密码）
     */
    @GetMapping("/{userId}")
    @Operation(summary = "查询用户详情")
    public R<SysUserEditVO> info(@PathVariable("userId") Long userId) {
        return R.ok(sysUserService.getUserDetail(userId));
    }


    /**
     * 删除用户（支持单条或批量，逻辑删除）
     */
    @PostMapping("/delete")
    @SaCheckPermission("system:user:delete")
    @Operation(summary = "删除用户")
    public R<Void> remove(@RequestBody List<Long> userIds) {
        sysUserService.deleteUsers(userIds);
        return R.ok();
    }

    /**
     * 重置用户密码（重新生成盐值并加密存储）
     */
    @PostMapping("/resetPassword")
    @SaCheckPermission("system:user:resetPwd")
    @Operation(summary = "重置用户密码")
    public R<Void> resetPassword(@Valid @RequestBody SysUserResetPasswordDTO dto) {
        sysUserService.resetPassword(dto);
        return R.ok();
    }
}
