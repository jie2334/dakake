package person;

import bus.Bus;

import java.util.Random;

/**
 * @description: 不同种类的人全部继承Person父类
 * @author: 22783
 * @date: 2023/7/21
 **/
public abstract class Person {

    private static final int PEOPLE_STATION = 20;

    /*每人上车应付的票价*/
    private double eachPersonPrice;

    /*每人上车的站数*/
    private int needStation;


    /*每个人上车的起始站*/
    private int startStation;


    private boolean isSit =false;

    public Person() {
    }

    public Person(double eachPersonPrice, int needStation) {
        this.eachPersonPrice = eachPersonPrice;
        this.needStation = needStation;
    }


    public int peopleRandStation(Bus bus,Random random) {
        return  random.nextInt(bus.getBusRandStation()- bus.getCurrentStation()) + 1;
    }








    /*get set 方法*/

    public double getEachPersonPrice() {
        return eachPersonPrice;
    }

    public void setEachPersonPrice(double eachPersonPrice) {
        this.eachPersonPrice = eachPersonPrice;
    }

    public int getNeedStation() {
        return needStation;
    }

    public void setNeedStation(int needStation) {
        this.needStation = needStation;
    }

    public int getStartStation() {
        return startStation;
    }

    public void setStartStation(int startStation) {
        this.startStation = startStation;
    }

    public boolean isSit() {
        return isSit;
    }

    public void setSit(boolean sit) {
        isSit = sit;
    }
}
