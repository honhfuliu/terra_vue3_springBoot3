package com.ziheng.common.exception;

import com.ziheng.common.core.enums.ResultCode;

public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(String message) {
        this(ResultCode.INTERNAL_ERROR.getCode(), message);
    }

    public BusinessException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMessage());
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
