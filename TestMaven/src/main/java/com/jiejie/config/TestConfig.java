package com.jiejie.config;

import java.io.*;
import java.util.Properties;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/4
 **/
public class TestConfig {


    public static void test() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./src/config.properties"));
            properties.put("name", "jiejie");
            properties.put("age", 23);
            properties.put("address", "花城大道");

            properties.store(new FileWriter("./src/config.properties"), "my_test");

            properties.clear();
            System.out.println("properties = " + properties.getProperty("name"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //字节流
    public void testTwo(){

        Class<Properties> propertiesClass = Properties.class;

        InputStream resourceAsStream = propertiesClass.getResourceAsStream("/test.txt");
        System.out.println("resourceAsStream = " + resourceAsStream);

        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
