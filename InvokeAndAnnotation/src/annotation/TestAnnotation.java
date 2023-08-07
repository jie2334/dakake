package annotation;

import org.junit.Test;

import java.lang.annotation.Inherited;

/**
 * @description: annotation.TestAnnotation
 * @author: 22783
 * @date: 2023/8/7
 **/

public class TestAnnotation {

    /**
     * 注解使用
     */
    @SelfAnno(number = 1000,str = "jiejie")
    public void testAnnotation(){
        /*
        * 注解跟反射一起使用
        * */
    }
}
