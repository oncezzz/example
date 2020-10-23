package com.zb.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 *
 * @author once
 * @date 2020/9/12 18:22
 *
 */
@Slf4j
@RestControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public Response throwable(Throwable throwable) {
        log.info(throwable.getMessage(),throwable);
        return Response.fail().ofCode(-1).setMsg(throwable.getMessage());
    }

}
