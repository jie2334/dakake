package annotation;

import java.lang.annotation.*;

/**
 * @description: 自定义注解
 * @author: 22783
 * @date: 2023/8/7
 **/

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SelfAnno {
    /*注解里面定义自己的方法逻辑*/


    /*里面只有属性，没有方法*/
    int number() default 100;

    String str() default "";
}
