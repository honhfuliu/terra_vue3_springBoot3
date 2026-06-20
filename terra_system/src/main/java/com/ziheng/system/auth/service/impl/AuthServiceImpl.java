package com.ziheng.system.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ziheng.common.exception.BusinessException;
import com.ziheng.common.core.enums.ResultCode;
import com.ziheng.system.auth.domain.dto.LoginBody;
import com.ziheng.system.auth.domain.vo.LoginVo;
import com.ziheng.system.auth.service.AuthService;
import com.ziheng.system.sysuser.domain.SysUser;
import com.ziheng.system.sysuser.mapper.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

@Service
public class AuthServiceImpl implements AuthService {
    private final SysUserMapper sysUserMapper;

    public AuthServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public LoginVo login(LoginBody loginBody) {
        SysUser user = sysUserMapper.selectOne(
                new LambdaQueryWrapper<SysUser>()
                        .eq(SysUser::getUsername, loginBody.getUsername())
        );

        if (user == null) {
            throw new BusinessException(ResultCode.UNAUTHORIZED.getCode(), "用户不存在");
        }

        if (user.getStatus() != null && user.getStatus() == 0) {
            throw new BusinessException(ResultCode.UNAUTHORIZED.getCode(), "用户已被禁用");
        }

        if (!validatePassword(loginBody.getPassword(), user.getPassword(), user.getSalt())) {
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

    @Override
    public boolean validatePassword(String inputPassword, String storedPassword, String salt) {
        if (!StringUtils.hasText(salt)) {
            return false;
        }
        // md5加密算法方法调用（进行三次加密）
        for (int i = 0; i < 3; i++) {
            inputPassword = DigestUtils.md5DigestAsHex((salt + inputPassword + salt).getBytes()).toUpperCase();
        }
        System.out.println(inputPassword);
        return inputPassword.equals(storedPassword);
    }
}
