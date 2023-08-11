package com.jiejie.entity;

/**
 * @description: 饿汉式
 * @author: 22783
 * @date: 2023/8/11
 **/
public class HungerPerson {

    /*
    * 一开始就初始化
    *
    * */
    private static HungerPerson person =new HungerPerson();

    public HungerPerson() {
    }

    public static HungerPerson getPerson() {
        return person;
    }
}
