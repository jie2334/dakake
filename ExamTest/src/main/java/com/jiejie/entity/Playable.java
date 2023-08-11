package com.jiejie.entity;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/8/11
 **/
public interface Playable {
}

interface Bounce{

}
interface Roll extends Playable,Bounce{

}

class Ball implements Roll{
    public String getName() {
        return name;
    }

    public Ball(String name) {
        this.name = name;
    }


    void play(){
        Ball jiejie = new Ball("jiejie");
        System.out.println("jiejie = " + jiejie.getName());
    }
    String name;

}
