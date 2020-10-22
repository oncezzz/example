package com.zb;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.util.StringUtils;

/**
 * @author Zhang Bo
 * @date 2020/9/28 17:17
 */
@SpringBootApplication
public class SpringShellApplication {

    public static void main(String[] args) {
//        String[] disableCommand = {"--spring.shell.command.add.enabled=false"};
        String[] disableCommand = {"--spring.shell.command.script.enabled=false"};
        String[] fullArgs = StringUtils.concatenateStringArrays(args, disableCommand);
        new SpringApplicationBuilder(SpringShellApplication.class).web(WebApplicationType.NONE).run(fullArgs);
    }
}
