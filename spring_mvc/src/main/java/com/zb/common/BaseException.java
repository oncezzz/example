package com.zb.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationContextException;

/***
 * @author once
 * @date 2020/9/12 18:08
 *
 */
@Getter
@Setter
public class BaseException extends ApplicationContextException {

    private int code;


    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
