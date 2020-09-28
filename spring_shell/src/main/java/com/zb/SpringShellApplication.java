package com.zb;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Zhang Bo
 * @date 2020/9/28 17:17
 */
@SpringBootApplication
public class SpringShellApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringShellApplication.class).web(WebApplicationType.NONE).run(args);
    }
}
