package com.jiejie;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 使用反射获取String里面的方法并且调用
 * @author: 22783
 * @date: 2023/8/7
 **/
public class TestString {


    @Test
    public void testInvoke(){
        String name = "jiejie";
        try {
            //获取String的字节码文件
            Class<?> forName = Class.forName("java.lang.String");

            /*调用构造方法*/
            Constructor<?> constructor = forName.getConstructor(String.class);
            Object jiejie = constructor.newInstance(name);

            for (Method method : forName.getMethods()) {
                System.out.println("method的名称 = " + method.getName());
            }

            /*调用方法*/
            Method charAt = forName.getMethod("charAt", int.class);
            Method indexOf = forName.getMethod("indexOf", int.class);
            Object index = indexOf.invoke(jiejie, 3);

            Object invoke = charAt.invoke(jiejie, 1);

            System.out.println("invoke = " + invoke);
            System.out.println("index = " + index);

            /*调用字段*/
            Field declaredField = forName.getDeclaredField("hash");
            declaredField.setAccessible(true);
            declaredField.setInt(jiejie,12345);
            System.out.println("declaredField = " + declaredField.hashCode());



        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 InstantiationException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
