package com.ziheng.framework.web.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.ziheng.common.core.domain.R;
import com.ziheng.common.core.enums.ResultCode;
import com.ziheng.common.exception.BusinessException;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {
    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(BusinessException.class)
    public R<Void> handleBusinessException(BusinessException ex) {
        log.warn("业务异常: {}", ex.getMessage());
        return R.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            BindException.class,
            ConstraintViolationException.class,
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class
    })
    public R<Void> handleBadRequestException(Exception ex) {
        log.warn("请求参数异常: {}", ex.getMessage());
        return R.fail(ResultCode.BAD_REQUEST.getCode(), resolveValidationMessage(ex));
    }

    @ExceptionHandler(Exception.class)
    public R<Void> handleException(Exception ex) {
        log.error("业务异常", ex);
        return R.fail(ResultCode.INTERNAL_ERROR);
    }

    private String resolveValidationMessage(Exception ex) {
        if (ex instanceof MethodArgumentNotValidException validException
                && validException.getBindingResult().hasErrors()) {
            return validException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        if (ex instanceof BindException bindException && bindException.getBindingResult().hasErrors()) {
            return bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        }
        return ResultCode.BAD_REQUEST.getMessage();
    }

    /**
     * 未登录异常
     */
    @ExceptionHandler(NotLoginException.class)
    public R<Void> handleNotLoginException(NotLoginException ex) {

        log.warn("用户未登录：{}", ex.getMessage());

        return R.fail(
                ResultCode.UNAUTHORIZED.getCode(),
                "请先登录"
        );
    }

    /**
     * 权限不足异常
     */
    @ExceptionHandler(NotPermissionException.class)
    public R<Void> handleNotPermissionException(NotPermissionException ex) {

        log.warn("权限不足：{}", ex.getMessage());

        return R.fail(
                ResultCode.FORBIDDEN.getCode(),
                ex.getMessage()
        );
    }
}
