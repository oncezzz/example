package com.zb;

import org.springframework.stereotype.Component;

/***
 * TODO
 * @author once
 * @date 2020/9/17 0:13
 *
 */
@Component
public class UserBean {

    public void print() {
        System.out.println("自动扫描注入的bean");
    }
}
