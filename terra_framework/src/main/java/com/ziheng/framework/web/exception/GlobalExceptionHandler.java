package com.ziheng.framework.web.exception;

import com.ziheng.common.core.domain.R;
import com.ziheng.common.core.enums.ResultCode;
import com.ziheng.common.exception.BusinessException;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
@Hidden
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public R<Void> handleBusinessException(BusinessException ex) {
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
        return R.fail(ResultCode.BAD_REQUEST.getCode(), resolveValidationMessage(ex));
    }

    @ExceptionHandler(Exception.class)
    public R<Void> handleException(Exception ex) {
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
}
