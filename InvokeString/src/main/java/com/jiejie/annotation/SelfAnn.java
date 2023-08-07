package com.jiejie.annotation;

import java.lang.annotation.*;

/**
 * @description: 自定义注解
 * @author: 22783
 * @date: 2023/8/7
 **/
@Documented
@Target(ElementType.METHOD)//作用在方法上
@Retention(RetentionPolicy.RUNTIME)//运行时动态保存
public @interface SelfAnn {
    /*定义成员变量*/

    int minValue();

    //string 类型的变量，描述作用
    String description() default "this is my first annotation!";


}
