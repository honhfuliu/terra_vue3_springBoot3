package com.ziheng.common.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.UUID;

public class PasswordUtils {

    /**
     * 生成盐值
     * @return
     */
    public static String generateSalt() {
        byte[] salt = new byte[32];
        new SecureRandom().nextBytes(salt);
        return HexFormat.of().formatHex(salt).toUpperCase();
    }

    /**
     * 三次 MD5 加密（新增/修改/重置密码与登录校验统一使用本工具类）
     * 每次对 (salt + 原文 + salt) 做 MD5，结果转大写
     */
    public static String encryptTripleMd5(String password, String salt) {
        String result = password;
        for (int i = 0; i < 3; i++) {
            result = DigestUtils.md5DigestAsHex(
                    (salt + result + salt).getBytes(StandardCharsets.UTF_8)
            ).toUpperCase();
        }
        return result;
    }

    /**
     * 校验明文密码与库中密文是否匹配（与 encryptTripleMd5 配套）
     * @param inputPassword 输入的明文密码
     * @param storedPassword 数据库中存储的密文（三次 MD5 转大写）
     * @param salt 盐值
     * @return 匹配返回 true
     */
    public static boolean matches(String inputPassword, String storedPassword, String salt) {
        if (!StringUtils.hasText(salt)) {
            return false;
        }
        return encryptTripleMd5(inputPassword, salt).equals(storedPassword);
    }
}
