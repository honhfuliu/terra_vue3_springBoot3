package com.ziheng.system.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ziheng.common.exception.BusinessException;
import com.ziheng.common.core.enums.ResultCode;
import com.ziheng.common.util.PasswordUtils;
import com.ziheng.system.auth.domain.dto.LoginBody;
import com.ziheng.system.auth.domain.vo.LoginVo;
import com.ziheng.system.auth.service.AuthService;
import com.ziheng.system.sysuser.domain.SysUser;
import com.ziheng.system.sysuser.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final SysUserMapper sysUserMapper;

    public AuthServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 用户登录
     * @param loginBody
     * @return
     */
    @Override
    public LoginVo login(LoginBody loginBody) {
        SysUser user = sysUserMapper.selectOne(
                new LambdaQueryWrapper<SysUser>()
                        .eq(SysUser::getDelFlag, "0")
                        .eq(SysUser::getUsername, loginBody.getUsername())
        );

        if (user == null) {
            throw new BusinessException(ResultCode.UNAUTHORIZED.getCode(), "用户不存在");
        }

        if ("0".equals(user.getStatus())) {
            throw new BusinessException(ResultCode.UNAUTHORIZED.getCode(), "用户已被禁用");
        }

        if (!PasswordUtils.matches(loginBody.getPassword(), user.getPassword(), user.getSalt())) {
            throw new BusinessException(ResultCode.UNAUTHORIZED.getCode(), "密码错误");
        }

        StpUtil.login(user.getUserId());

        LoginVo loginVo = new LoginVo();
        loginVo.setToken(StpUtil.getTokenValue());
        loginVo.setUserId(user.getUserId());
        loginVo.setUsername(user.getUsername());
        loginVo.setNickname(user.getNickname());
        return loginVo;
    }
}
