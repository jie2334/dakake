import bus.Bus;
import bus.DieselCar;
import bus.NewEnergy;
import bus.Tram;
import person.Adult;
import person.Children;
import person.Elder;
import person.Person;

import java.util.ArrayList;
import java.util.Random;

/**
 * @description: 测试类充当车辆管理局
 * @author: 22783
 * @date: 2023/7/21
 **/
public class TestBusSystem {


    public static final int BUS_BASE_RAND = 20;
    public static final Bus[] buses = new Bus[]{new NewEnergy(1,  1.6),new Tram(1,1.8), new DieselCar(1,1.0)};

    /**
     * 车辆上人的种类
     */
    public static final Person[] persons = new Person[]{
            new Children(0.0,0),
            new Adult(1.1,0),
            new Elder(0.2,0)
    };


    /**
     * 随机产生上车的人
     * @param persons
     * @param random
     * @return
     */
    public Person randPeople(Person[] persons, Random random ) {

        int nexted = random.nextInt(persons.length);

        Person person = persons[nexted];

        System.out.println("该类型: "+person.getClass().getSimpleName()+" 的乘客开始上车");

        return person;
    }

    /**
     * 定义发车方法
     * @param random
     * @description: 随机让三种车辆发车
     */
    public Bus randDeparture(Bus[] buses,Random random){
        //随机产生三种车辆的索引
        int randBus = random.nextInt(buses.length);

        //取到索引的车辆开始发车
        Bus bus = buses[randBus];
        //开始出发
        System.out.println("bus: "+bus.getClass().getSimpleName()+" 开始发车，车辆行驶，请坐好！");
        System.out.println();
        return bus;
    }

    /**
     * 车辆管理局随机产生车的站数
     * @param random
     * @return
     */
    public int randBusStation(Random random){
        return random.nextInt(11) + BUS_BASE_RAND;
    }


    public int randBusMaxCapacity(Random random) {
        return random.nextInt(11)+20;
    }

    public int randEachStationPersonNum(Bus bus,Random random){
        //计算随机上车人数
        int num = bus.getMax_capacity()-bus.getCurrentPeopleNum();
        int randPeopleNum = random.nextInt(num)+1;
        //bus.setCurrentPeopleNum(randPeopleNum);
        return randPeopleNum;
    }




    public static void main(String[] args) {

        //创建Test对象
        TestBusSystem system = new TestBusSystem();
        //统一使用随机类
        Random random = new Random();

        System.out.println("车站管理局开始发车!------------------------");

        //调用发车方法 随机发不同种类的车
        Bus bus = system.randDeparture(buses, random);
        //随机产生车子的随机站数
        bus.setBusRandStation(system.randBusStation(random));
        System.out.println("车辆行驶的总站数: "+bus.getBusRandStation());
        System.out.println();
        int maxCapacity = system.randBusMaxCapacity(random);

        //bus的随机最大容量
        bus.setMax_capacity(maxCapacity);

        //todo bus的最大能站人数
        //bus.setCanStandNum(random.nextInt(maxCapacity-Bus.MAX_SEAT_NUM)+1);


        //车辆管理局  随机上人
        int busRandStation = bus.getBusRandStation();


        /**
         * 遍历车子站数的循环----开始上人
         * @param args
         */
        for (int index = 1; index < busRandStation; index++) {

            // TODO: 2023/7/22 当前站
            System.out.println("当前站数: "+index);

            System.out.println("当前车上的人数: "+bus.getCurrentPeopleNum());
            /*上下车的逻辑: ---->  先下车后上车*/
            bus.getOff();
            //打印下车的人数
            System.out.println("当前站下车的人数"+bus.getOffPeopleNum());
            System.out.println();
            //下车完毕后更新车上的下车人数
            bus.setOffPeopleNum(0);
            //获取当前车上的人数
            System.out.println("当前车上的人数: "+bus.getCurrentPeopleNum());


            //随机产生每一站上车的人数
            int eachStationPersonNum = system.randEachStationPersonNum(bus, random);

            //增加判断车辆是否满员的逻辑
            boolean isNotFull = bus.busIsNotFull(bus, eachStationPersonNum);

            if (isNotFull){
                System.out.println("此站上了 "+eachStationPersonNum+" 人");
                System.out.println();
                //遍历随机人数 开始上车
                for (int i = 0; i < eachStationPersonNum; i++) {
                    //随机产生上车的人类别
                    Person person = system.randPeople(persons, random);
                    System.out.println("上车的人:"+person.getClass().getSimpleName());


                    //todo 判断上车的人的种类符不符合情况
                    boolean sitOrStand = bus.isSitOrStand(person);

                    if (sitOrStand) {
                        //人上车
                        bus.peopleBoarding(person);

                        person.setStartStation(index);
                        //todo 更新车上的人数
                        bus.setCurrentPeopleNum(bus.getCurrentPeopleNum()+1);

                        int peopleRandStation = person.peopleRandStation(bus,random);
                        //每个人的随机站数
                        person.setNeedStation(peopleRandStation);
                        //每上一个人 totalMoney更新
                        bus.setTotalMoney(bus.getTotalMoney()+bus.getBasePrice() + (peopleRandStation * person.getEachPersonPrice()));
                        System.out.println("现在车上的总钱数是: "+bus.getTotalMoney());


                    }
                    System.out.println("上了第"+(i+1)+"个人 "+"此人需要乘坐的站数: "+person.getNeedStation());
                    System.out.println();

                }
            }
            //更新车辆站数
            bus.setCurrentStation(index);
            System.out.println("当前站数: " +bus.getCurrentStation()+
                    "上完!");
            System.out.println("现在车上的总钱数是: ");
            System.out.printf("%.3f",bus.getTotalMoney());
            System.out.println("-------------");
            System.out.println();
        }

        //到达终点站，车辆清空
        ArrayList<Person> list = bus.getPersonList();
        list.clear();

        System.out.println("车辆到终点站！ 车上的总钱数: " );
        System.out.printf("%.3f",bus.getTotalMoney());

    }


}
