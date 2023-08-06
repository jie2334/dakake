package bus;


import person.Elder;
import person.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description: 抽象出bus类  不同种的车继承bus类
 * @author: 22783
 * @date: 2023/7/21
 **/
public abstract class Bus {

    private int busRandStation;

    /*当前站数*/
    private int currentStation;

    /*当前车上人数*/
    private int currentPeopleNum;

    /*基础票价*/
    private Double basePrice;

    /*车上最大载客量*/
    private int max_capacity;

    /*车上售票的总钱数*/
    private double totalMoney;

    /*车辆上的人的集合*/
    private ArrayList<Person> personList = new ArrayList<>();

    /*车上最大座位数*/
    public static final int MAX_SEAT_NUM = 16;



    /*车上的站的人数*/
    private int standNum = 0;
    /*车上坐的人数*/
    private int sitNum = 0;

    private int canStandNum = 0;

    /**/
    private int canSitNum = 0;

    private int offPeopleNum = 0;


    public Bus() {
    }

    /**
     * 构造方法初始化
     */
    public Bus(int currentStation, double basePrice) {
        this.currentStation = currentStation;
        this.currentPeopleNum = 0;
        this.basePrice = basePrice;
        this.max_capacity = 0;
        this.totalMoney = 0;
        this.standNum = 0;
    }



    /**
     * 定义bus内部的上下车方法
     */

    /**
     * 上车方法
     */
    public boolean busIsNotFull(Bus bus,int peopleNumOn){
        //先做判断 乘客能不能上车
        int peopleNum = bus.getCurrentPeopleNum();

        if (peopleNum+peopleNumOn == bus.getMax_capacity()) {
            System.out.println("车已满，不能上人了，请等下一辆！");
            return false;
        }
        else {
            System.out.println("车辆没满,可以上车");
            return true;
        }
    }

    public void peopleBoarding(Person person){

        //将该乘客添加到list集合中去
        personList.add(person);
    }
    /**
     * 下车方法 todo 下车方法报错
     */
    public  void getOff(){

        //获取车上所有人的集合
        ArrayList<Person> personListCopy = personList;

        if (personListCopy==null||personListCopy.isEmpty()){
            return ;
        }
        if (getCurrentStation() == getBusRandStation()) {
            //下车
            personListCopy.clear();
            return ;
        }

//        ArrayList<Integer> list = new ArrayList<>();

        Iterator<Person> iterator = personList.iterator();


        while(iterator.hasNext()){
            Person next = iterator.next();
            if (next.getNeedStation()==getCurrentStation()- next.getStartStation()){
                System.out.println("有乘客下车!");
                setOffPeopleNum(getOffPeopleNum() + 1);
                System.out.println("下车的第: "+getOffPeopleNum()+"个人");

                System.out.println("该乘客为: " + next.getClass().getSimpleName() + "下车");

                if (next.isSit()) {
                    System.out.println("该乘客是坐着的");
                    setSitNum(getSitNum() - 1);
                } else {
                    System.out.println("该乘客是站着的");
                    setStandNum(getStandNum() - 1);

                }
                iterator.remove();

                // TODO: 2023/7/22 更新车上的人数
                setCurrentPeopleNum(getCurrentPeopleNum() - 1);

            }
        }
    }
    public void setPeopleSit(Person person){
        person.setSit(true);
    }


    /*根据车上面的情况更改此人的坐或者是站
    * 然后判断此人是否能上车
    * */
    public boolean isSitOrStand(Person person){
        //获取车辆的座位情况
        int sitNum = getSitNum();
        int standNum = getStandNum();

        int busPeopleNum = getCurrentPeopleNum();

        // TODO: 2023/7/22 这里面有毛病，人在上车之前，已经把sitNum改动了
        //计算站着和坐着的空位

        setCanSitNum(MAX_SEAT_NUM-sitNum);
        setCanStandNum( getMax_capacity()-MAX_SEAT_NUM-standNum);

        // TODO: 2023/7/22  考虑每当一个人上车的时候是否更新车辆上的座位情况

        if (busPeopleNum < getMax_capacity()){
            System.out.println("可以上车");
            if (getCanSitNum() >0 ){
                setPeopleSit(person);
                setSitNum(getSitNum()+1);
                return true;
            }
            if (getCanSitNum()==0 && getCanStandNum()>0){
                if (person instanceof Elder){
                    System.out.println("你不能站着,等下一辆车吧");
                    //todo 舍掉这个老人继续上车
                    return false;
                }
                person.setSit(false);
                setStandNum(getStandNum()+1);
                return true;
            }
        }
        return false;
    }
    public int getBusRandStation() {
        return busRandStation;
    }

    public void setBusRandStation(int busRandStation) {
        this.busRandStation = busRandStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        this.currentStation = currentStation;
    }

    public int getCurrentPeopleNum() {
        return currentPeopleNum;
    }

    public void setCurrentPeopleNum(int currentPeopleNum) {
        this.currentPeopleNum = currentPeopleNum;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public int getStandNum() {
        return standNum;
    }

    public void setStandNum(int max_capacity) {
        this.standNum = max_capacity;
    }

    public int getSitNum() {
        return sitNum;
    }

    public void setSitNum(int sitNum) {
        this.sitNum = sitNum;
    }

    public int getOffPeopleNum() {
        return offPeopleNum;
    }

    public void setOffPeopleNum(int offPeopleNum) {
        this.offPeopleNum = offPeopleNum;
    }

    public int getCanStandNum() {
        return canStandNum;
    }

    public void setCanStandNum(int canStandNum) {
        this.canStandNum = canStandNum;
    }

    public int getCanSitNum() {
        return canSitNum;
    }

    public void setCanSitNum(int canSitNum) {
        this.canSitNum = canSitNum;
    }
}
