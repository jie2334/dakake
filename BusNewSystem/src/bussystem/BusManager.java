package bussystem;

import bussystem.bus.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * @description: TODO 类描述
 * @author: peibin
 * @date: 2023/7/20
 **/
public class BusManager {


    /**
     * 模拟车辆管理 建造车
     * @return
     */
    public ArrayList<Bus> buildBus(){
        //柴油车

        /*派发车辆*/

        Bus dieseVehicle = new DieselVehicle(1.f,getRandomStation(20,30));
        dieseVehicle.setMaxLoadPeople(getRandomStation(20,30));

        Bus tram = new Tram(2.f,getRandomStation(20,30));
        tram.setMaxLoadPeople(getRandomStation(20,30));

        Bus tramCar = new TramCar(1.8f,getRandomStation(20,30));
        tramCar.setMaxLoadPeople(getRandomStation(20,30));

        Bus energyBus = new EnergyBus(1.6f,getRandomStation(20,30));
        energyBus.setMaxLoadPeople(getRandomStation(20,30));

        ArrayList<Bus> allBus = new ArrayList<>();
        //添加车辆
        allBus.add(dieseVehicle);
        allBus.add(tram);
        allBus.add(tramCar);
        allBus.add(energyBus);
        return allBus;
    }

    public int getRandomStation(int minStation, int maxStation){
        Random random = new Random();
        // 比如 最小 20  最大 30，那么随机的就是0-9  然后+ 20 就是 20-29了，因为包含29
        int station = random.nextInt(maxStation-minStation)+minStation;
        return station;
    }

    public double getTotalMoney(Bus bus) {
        return bus.getTotalMoney();
    }


}
