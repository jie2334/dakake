package com.jiejie.annotation;


/**
 * @description: 注解应用在方法上，判断条件是否有用
 * @author: 22783
 * @date: 2023/8/7
 **/
public class TestAnnotation {
    @SelfAnn(minValue = 100,description = "start transfer!")
    public void test(int number){
        System.out.println("number = " + number);

    }
    @TestLength(length = "i love")
    public void testLength(String length){
        System.out.println("length = " + length);
    }

}
