package com.jiejie.annotation;

import java.lang.annotation.*;

/**
 * @description: 测试长度不能大于10
 * @author: 22783
 * @date: 2023/8/7
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestLength {
    String length() default "";
}
