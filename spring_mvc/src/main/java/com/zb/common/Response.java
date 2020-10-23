package com.zb.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/***
 *
 * @author once
 * @date 2020/9/12 17:55
 *
 */
@Getter
@Setter
@Accessors(chain = true)
public class Response<T> {
    private int code = 1;

    private String msg = "success";

    private T data;

    public static <T> Response<T> success(T t) {
        return new Response<T>().setData(t);
    }

    public static Response fail() {
        return new Response();
    }

    public  Response ofCode(int code) {
        return this.setCode(code);
    }

    public  Response ofMsg(String msg) {
        return this.setMsg(msg);
    }
}
