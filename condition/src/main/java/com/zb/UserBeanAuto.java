package com.zb;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/***
 * TODO
 * @author once
 * @date 2020/9/17 0:17
 *
 */
@Conditional(UserBeanAuto.class)
@Component
public class UserBeanAuto implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }

    public void print() {
        System.out.println("自动扫描注入的bean");
    }
}
