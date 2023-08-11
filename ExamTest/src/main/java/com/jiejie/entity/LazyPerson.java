package com.jiejie.entity;

/**
 * @description: 单例模式------饿汉式
 * @author: 22783
 * @date: 2023/8/11
 **/
public class LazyPerson {
    private static LazyPerson person;

    public LazyPerson() {
    }

    public static LazyPerson getPerson() {
        //直接new一个出来
        if (person == null) {
            person = new LazyPerson();
        }
        return person;
    }
}
