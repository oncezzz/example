package com.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/***
 * mysql 案例启动
 * @author once
 * @date 2020/9/5 11:59
 *
 */
@RestController
@SpringBootApplication
public class MysqlApplication {



    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }

}
