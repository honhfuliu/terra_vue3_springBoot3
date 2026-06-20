package com.ziheng.system.auth.service;

import com.ziheng.system.auth.domain.dto.LoginBody;
import com.ziheng.system.auth.domain.vo.LoginVo;

public interface AuthService {
    LoginVo login(LoginBody loginBody);

    boolean validatePassword(String inputPassword, String storedPassword, String salt);
}
