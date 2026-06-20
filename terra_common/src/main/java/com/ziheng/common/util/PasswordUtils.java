package com.ziheng.common.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class PasswordUtils {
    public static String encryptPassword(String password, String salt) {
        return DigestUtils.md5DigestAsHex(
                (password + salt).getBytes(StandardCharsets.UTF_8)
        );
    }

    public static String generateSalt() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    public static boolean matchesPassword(String inputPassword, String storedPassword, String salt) {
        String encryptedInput = encryptPassword(inputPassword, salt);
        return encryptedInput.equals(storedPassword);
    }
}
