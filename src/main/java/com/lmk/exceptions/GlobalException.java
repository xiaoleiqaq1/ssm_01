package com.lmk.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/10
 */
//全局异常
@ControllerAdvice
public class GlobalException {

    Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(Exception.class)
    public String Exception(Exception e) {
        logger.error("错误信息", e);
        //跳转错误页面
        return "error";
    }
}
