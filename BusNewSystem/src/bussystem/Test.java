package bussystem;

import bussystem.bus.Bus;
import bussystem.people.People;

import java.util.ArrayList;
import java.util.Random;

/**
 * @description:
 * @author: peibin
 * @date: 2023/7/20
 **/
public class Test {
    public static void main(String[] args) {
        BusManager busManager = new BusManager();
        //调用车辆管理获取 所有的车子
        ArrayList<Bus> allBus = busManager.buildBus();
        for (Bus bus : allBus) {
            //循环到谁，谁就开始发车
            for (int i = 1; i <= bus.getStation(); i++) {
                //更新车时在第几站的数据
                bus.setCurrentStation(i);
                System.out.println("当前车在第" + bus.getCurrentStation() + "站");
                //这些 都是面向过程的写法
                //因为你的人都没有抽象出来

                //还需要判断 第一站不下人？？？？


                /*开始上人*/
                ArrayList<People> peopleList = bus.randPeopleList(bus.getPeoples(), new Random());

                //迭代peopleList
                for (int index = 0; index < peopleList.size(); index++) {
                    bus.addPassenger(peopleList.get(index));
                }


                //还有多少站
                int resetStation = bus.getStation() - bus.getCurrentStation();

                //上人
                if (bus.getCurrentStation() == bus.getStation()) {
                    System.out.println("已经最后一站了，不上了");
                    return;
                }


                double totalMoney = busManager.getTotalMoney(bus);
                String result = String.format("%.3f", totalMoney);
                System.out.println("车到站了，总共" + result + "元");

                bus.offPassenger();


                //随机10个中年人
                //随机10个小孩子


                //从这里开始，逻辑没问题，但是 思想不对。用的时面向过程的思想
//                if(i>1){
//                    //下车逻辑
//                    //先获取坐的人数
//                    int peopleCountOfSeat = bus.getPeopleCountOfSeat();
//                    //站的人数
//                    int peopleCountOfStand = bus.getPeopleCountOfStand();
//
//                    //获取站的年轻人的随机 下车人数
//                    int yongStand = bus.offBus(3);
//                    //获取站的小孩子的随机
//                    int childStand = bus.offBus(5);
//                    //获取坐的小孩子的随机
//                    int childSeat = bus.offBus(4);
//                    //获取坐的年轻人的随机
                //int yongSeat = bus.offBus(Bus.PassengerType.YONG_SEAT);
//                    //获取坐的老年人的随机
//                    int oldSeat = bus.offBus(1);
//
//                    peopleCountOfStand = peopleCountOfStand - yongStand - childStand;
//                    peopleCountOfSeat = peopleCountOfSeat - oldSeat - yongSeat - childSeat;
//                    bus.setPeopleCountOfSeat(peopleCountOfSeat);
//                    bus.setPeopleCountOfStand(peopleCountOfStand);
//
//                    System.out.println("老年人下车:"+oldSeat+"人");
//                    System.out.println("年轻人坐的下车:"+yongSeat+"人");
//                    System.out.println("年轻人站的下车:"+yongStand+"人");
//                    System.out.println("小孩子站的下车:"+childStand+"人");
//                    System.out.println("小孩子坐的下车:"+childSeat+"人");
//
//                    if(bus.getCurrentStation() == i){
//                        bus.setPeopleCountOfStand(0);
//                        bus.setPeopleCountOfSeat(0);
//                        System.out.println("全下车了");
//                        break;
//                    }
//                }
//
//                Random oldRandom = new Random();
//                Random yongRandom = new Random();
//                Random childRandom = new Random();
//
//                int old  = oldRandom.nextInt(11);
//                int yong  = yongRandom.nextInt(11);
//                int child  = childRandom.nextInt(11);
//
//                //先看满没满
//                //做的人数
//                int peopleCountOfSeat = bus.getPeopleCountOfSeat();
//                        //站的人数
//                        int peopleCountOfStand = bus.getPeopleCountOfStand();
//
//                        if( (peopleCountOfSeat + peopleCountOfStand ) != bus.getMaxLoadPeople() ){
//                            //当前站的人+ 当前坐的人 不超过最大，才能上人
//                            //先上老人
//                            int restSeat = Bus.EMPTY_SEAT - peopleCountOfSeat;
//                            if(restSeat > 0){
//                                //比如坐的由10个，老人只有1个，那么上的老人就只有1个
//                                //如果坐的由2个，老人由10个，那么上的老人就只有2个
//                                int finalOldOn = Math.min(restSeat,old);
//                                //保存一下  坐的老人由多少
//                                bus.setOldPeopleSeat(finalOldOn + bus.getOldPeopleSeat());
//                                //更新空座位
//                                bus.setPeopleCountOfSeat(peopleCountOfSeat+finalOldOn);
//                            }
//
//                            //重新 获取坐的人
//                            peopleCountOfSeat = bus.getPeopleCountOfSeat();
//
//                            //接着小孩
//                            restSeat = Bus.EMPTY_SEAT - peopleCountOfSeat;
//
//                            int childOnCount=0;
//                            int finalChildSeat = Math.min(restSeat,child);
//                            childOnCount = finalChildSeat;
//                            bus.setChildSeat(finalChildSeat+bus.getChildSeat());
//                            if(finalChildSeat < child){
//                                //如果还有小孩子没坐
//                                //那就站着
//                                int maxStandC = bus.getMaxLoadPeople() - Bus.EMPTY_SEAT;
//                                int finalChildStand = Math.min(maxStandC- peopleCountOfStand,child-finalChildSeat);
//                                bus.setChildStand(finalChildStand+bus.getChildStand());
//                                childOnCount = finalChildSeat + finalChildStand;
//                            }
//
//
//                            //重新 获取坐的人
//                            peopleCountOfSeat = bus.getPeopleCountOfSeat();
//
//                            //接着年轻人
//                            restSeat = Bus.EMPTY_SEAT - peopleCountOfSeat;
//
//                            peopleCountOfStand = bus.getPeopleCountOfStand();
//
//                            //年轻人此站上车的总人数
//                            int yongOnCount=0;
//                            int finalYongSeat = Math.min(restSeat,yong);
//                            yongOnCount = finalYongSeat;
//                            bus.setYongSeat(finalYongSeat+bus.getYongSeat());
//                            if(finalYongSeat < yong){
//                                //如果还有年轻人没坐
//                                //那就站着
//                                int maxStandC = bus.getMaxLoadPeople() - Bus.EMPTY_SEAT;
//                                int finalYongStand = Math.min(maxStandC- peopleCountOfStand,yong-finalYongSeat);
//                                bus.setYongStand(finalYongSeat+bus.getYongSeat());
//                                yongOnCount = finalYongSeat + finalYongStand;
//                    }
//
//
//                }
            }
        }
    }
}
