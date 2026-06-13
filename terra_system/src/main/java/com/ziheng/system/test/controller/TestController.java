package com.ziheng.system.test.controller;

import com.ziheng.common.core.domain.R;
import com.ziheng.common.core.enums.ResultCode;
import com.ziheng.common.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
public class TestController {
    @GetMapping("/api/test")
    public R<Map<String, Object>> error(@RequestParam(value = "msg", defaultValue = "1") Integer msg) {
        if (msg == 1){
            throw new BusinessException(ResultCode.RC5001);
        }
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("status", "UP");
        data.put("service", "terra-admin");
        data.put("time", LocalDateTime.now());
        return R.ok(data);
    }
}
