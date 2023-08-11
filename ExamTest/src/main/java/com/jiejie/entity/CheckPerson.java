package com.jiejie.entity;

/**
 * @description:
 * @author: 22783
 * @date: 2023/8/11
 **/
public class CheckPerson {

    private volatile static CheckPerson checkPerson;

    public CheckPerson() {
    }

    public static CheckPerson getCheckPerson() {

        if ( null == checkPerson) {
            synchronized (CheckPerson.class){
                if (null==checkPerson){
                    checkPerson = new CheckPerson();
                }
            }
        }
        return checkPerson;
    }
}
