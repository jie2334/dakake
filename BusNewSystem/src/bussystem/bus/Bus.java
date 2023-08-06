package bussystem.bus;

import bussystem.people.ChildPeople;
import bussystem.people.OldPeople;
import bussystem.people.People;
import bussystem.people.YongPeople;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @description:  定义一个车类
 * @author: peibin
 * @date: 2023/7/20
 **/
public  class Bus {

    /**
     * 车辆所装载的所有人
     */
    private ArrayList<People> peoples;

    public ArrayList<People> getPeoples() {
        return peoples;
    }

    public static final int EMPTY_SEAT = 16;

    private double basePrice = 0f;
    /**
     * 车子的最大站
     */
    private int  station = 0;
    /**
     * 车子的当前站
     */
    private int currentStation = 1;
    /**
     * 最大载客量
     */
    private int maxLoadPeople = 0;

    /**
     * 人坐的人数
     */
    private int peopleCountOfSeat = 0;

    /**
     * 站的人数
     */
    private int peopleCountOfStand = 0;


    /**
     * 车子里面总的钱
     */
    private double totalMoney = 0f;

    /**
     * 老年人
     */
    private int oldPeople = 0;

    /**
     * 年轻人
     */
    private int yongPeople = 0;

    /**
     * 小孩子
     */
    private int children = 0;

    private int oldPeopleSeat = 0;

    private int yongSeat = 0;
    private int yongStand = 0;

    private int childSeat = 0;
    private int childStand = 0;

    public Bus(double basePrice,int station){
        this.basePrice = basePrice;
        this.station = station;
        this.peoples = new ArrayList<>();
    }


    private int getEmptyStandSeat(){
        //已经坐了人的位置的数量
        int stand = 0;
        //循环所有的车上的人
        for (People p: peoples) {
            if(p !=null){
                //如果该人没有座位
                if(!p.isSeat()){
                    //那我就统计数量+一个
                    stand ++;
                }

            }
        }
        //最终的站的位置就是  最大的载客量-  最大的座位 -  已经站了人的位置的数量
        return maxLoadPeople - EMPTY_SEAT - stand;
    }

    private int getEmptySeat(){
        //已经坐了人的位置的数量
        int seat = 0;
        //循环所有的车上的人
        for (People p: peoples) {
            if(p !=null){
                //如果该人时坐座位的
                if(p.isSeat()){
                    //那我就统计数量+一个
                    seat ++;
                }

            }
        }
        //最终的空座位就是 最大的座位 -  已经坐了人的位置的数量
        return EMPTY_SEAT - seat;
    }


    /*
     * 生成随机上车人
     * */
    public ArrayList<People> randPeopleList(ArrayList<People> peoples,Random random) {
        //随机上老人
        int elder = random.nextInt(10) + 1;
        for (int i = 0; i < elder; i++) {
            OldPeople old = new OldPeople();
            peoples.add(old);
        }
        //随机上小孩儿
        int kids = random.nextInt(10) + 1;
        for (int i = 0; i < kids; i++) {
            ChildPeople childPeople = new ChildPeople();
            peoples.add(childPeople);
        }

        //随即上大人
        int youngPeople = random.nextInt(10) + 1;
        for (int i = 0; i < youngPeople; i++) {
            YongPeople adult = new YongPeople();
            peoples.add(adult);
        }
        return peoples;
    }

    /**
     * 上人的方法
     */
    public double addPassenger(People people){

        double thisGuyPrice = -1f;

        //安全性检查
        if(people!=null){
            //当前满了不能加
            if(peoples.size() == maxLoadPeople){
                System.out.println("车辆已满，不能加人");
                return thisGuyPrice;
            }
            int restSeat = getEmptySeat();
            if(people instanceof OldPeople){
                if(restSeat>0) {
                    //如果由空座
                    people.setSeat(true);
                    peoples.add(people);
                    thisGuyPrice = basePrice + people.getStation() * people.getEachPassengerPrice();
                    totalMoney+=thisGuyPrice;
                }
            }else{
                if(restSeat>0){//如果由空座，那你去坐
                    people.setSeat(true);
                    peoples.add(people);
                    thisGuyPrice = basePrice + people.getStation() * people.getEachPassengerPrice();
                    totalMoney +=thisGuyPrice;
                }else{
                    int restStand = getEmptyStandSeat();
                    if(restStand>0){
                        people.setSeat(false);
                        peoples.add(people);
                        thisGuyPrice = basePrice + people.getStation() * people.getEachPassengerPrice();
                        totalMoney +=thisGuyPrice;
                    }
                }
            }
        }
        return thisGuyPrice;
    }


    /**
     * 下人的方法
     *  现在是不是随机的？
     *  改成:
     *  如果这个人在这个站 下车。那么就下车
     *  也就是这个人坐到了它应该坐的站后就下车
     *  比如，第一站上车，坐5站。
     *  那第6站下车
     *
     *  先判断这个人到没到站，到站在下车
     */
    public void offPassenger(){
        //先下车
        ArrayList<People> peopleList =  peoples;
        if(peopleList==null || peopleList.isEmpty()){
            return;
        }

        if(currentStation == station){
            //最终一战，清空下车
            peopleList.clear();
            return;
        }

        Random random = new Random();
        int outPeopleCount = random.nextInt(peopleList.size());
        //从所有人当中 随机 20个人去删除
        ArrayList<Integer> allIndexs = new ArrayList<>();
        for (int i = 0 ;i < outPeopleCount ; i++){
            allIndexs.add(random.nextInt(peopleList.size()));
        }


        Collections.sort(allIndexs);

        for (int i = allIndexs.size() - 1; i >= 0; i--) {
            int index = allIndexs.get(i);
            if (index >= 0 && index < peopleList.size()) {
                peopleList.remove(index);
            }
        }

        //最终删除的就是allIndexs里面的索引对应的
        //下面就是循环列表删除
//        Iterator<People> peopleIterator =  peopleList.iterator();
//        while (peopleIterator.hasNext()){
//            People people = peopleIterator.next();
//            int index = peopleList.indexOf(people);
//            for (Integer i : allIndexs) {
//                if(i == index){
//                    peopleIterator.remove();
//                }
//            }
//        }

        System.out.println("下车的完毕");
    }


    /**
     * 枚举是一种特殊的数据结构
     * ，就是用来放常量的
     * 除此之外，没有别的用法
     *
     * 你可以称它为一种特别的类
     * class 名称
     * interface 接口
     * enum  枚举
     *
     *
     */
    public enum PassengerType{
        OLD,
        YONG_SEAT,
        YONG_SAND,
        CHILD_SEAT,
        CHILD_SAND,
    }

    /**
     * 获取下车的人
     * @param type
     */
    public int offBus(PassengerType type){
        Random random = new Random();
        int offCount = 0;
        if(type == PassengerType.OLD){ //老年人坐的
            offCount = random.nextInt(oldPeopleSeat);
            oldPeopleSeat -=offCount;
        }else if(type == PassengerType.YONG_SEAT){//年轻人坐的
            offCount = random.nextInt(yongSeat);
            yongSeat -=offCount;
        }else if(type == PassengerType.YONG_SAND){//年轻人站的
            offCount = random.nextInt(yongStand);
            yongStand -=offCount;
        }else if(type == PassengerType.CHILD_SEAT){//小孩子坐的
            offCount = random.nextInt(childSeat);
            childSeat -=offCount;
        }else if(type == PassengerType.CHILD_SAND){//小孩子站的
            offCount = random.nextInt(childStand);
            childStand -=offCount;
        }
        return offCount;
    }

    public void setMaxLoadPeople(int maxLoadPeople) {
        this.maxLoadPeople = maxLoadPeople;
    }

    public int getMaxLoadPeople() {
        return maxLoadPeople;
    }

    public int getStation() {
        return station;
    }


    public void setCurrentStation(int currentStation) {
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getPeopleCountOfSeat() {
        return peopleCountOfSeat;
    }

    public void setPeopleCountOfSeat(int peopleCountOfSeat) {
        this.peopleCountOfSeat = peopleCountOfSeat;
    }

    public int getPeopleCountOfStand() {
        return peopleCountOfStand;
    }

    public void setPeopleCountOfStand(int peopleCountOfStand) {
        this.peopleCountOfStand = peopleCountOfStand;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public int getOldPeople() {
        return oldPeople;
    }

    public void setOldPeople(int oldPeople) {
        this.oldPeople = oldPeople;
    }

    public int getYongPeople() {
        return yongPeople;
    }

    public void setYongPeople(int yongPeople) {
        this.yongPeople = yongPeople;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getOldPeopleSeat() {
        return oldPeopleSeat;
    }

    public void setOldPeopleSeat(int oldPeopleSeat) {
        this.oldPeopleSeat = oldPeopleSeat;
    }

    public int getYongSeat() {
        return yongSeat;
    }

    public void setYongSeat(int yongSeat) {
        this.yongSeat = yongSeat;
    }

    public int getYongStand() {
        return yongStand;
    }

    public void setYongStand(int yongStand) {
        this.yongStand = yongStand;
    }

    public int getChildSeat() {
        return childSeat;
    }

    public void setChildSeat(int childSeat) {
        this.childSeat = childSeat;
    }

    public int getChildStand() {
        return childStand;
    }

    public void setChildStand(int childStand) {
        this.childStand = childStand;
    }

    public double getTotalMoney() {
        return totalMoney;
    }
}
