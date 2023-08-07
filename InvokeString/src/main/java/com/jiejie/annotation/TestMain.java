package com.jiejie.annotation;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @description: 使用测试是否满足注解
 * @author: 22783
 * @date: 2023/8/7
 **/
public class TestMain {
    public static void main(String[] args) {
        try {
            Class<?> forName = Class.forName("com.jiejie.annotation.TestAnnotation");
            Method test = forName.getMethod("test", int.class);

            TestAnnotation newInstance = (TestAnnotation)forName.newInstance();

            SelfAnn annotation = test.getAnnotation(SelfAnn.class);

            if (annotation != null) {
                if (!annotation.description().equals("")){
                    int num = annotation.minValue();
                    int paramValue = 1000;
                    if (paramValue>=num){
                        test.invoke(newInstance,paramValue);
                        System.out.println("annotation = " + annotation.description());
                    }
                    else {
                        System.out.println("不满足要求!");
                    }
                }
                else {
                    test.invoke(newInstance,100);
                    System.out.println("annotation = " + annotation.description());
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 InstantiationException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void test(){
        try {
            Class<?> aClass = Class.forName("com.jiejie.annotation.TestAnnotation");

            Method testLength = aClass.getMethod("testLength", String.class);

            TestAnnotation instance = (TestAnnotation) aClass.newInstance();

            TestLength annotation = testLength.getAnnotation(TestLength.class);
            if (annotation!=null){
                if (annotation.length().length() >10){
                    System.out.println("长度不能大于10！");
                }
                else {
                    testLength.invoke(instance,"I LOVE MY FAMILY!");
                }
            }
            else {
                testLength.invoke(instance,"I LOVE MY FAMILY!");
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
