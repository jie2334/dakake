package bussystem.people;

/**
 * @description: TODO 类描述
 * @author: peibin
 * @date: 2023/7/20
 **/
public class People {

    /**
     * 这个状态代表此人上车时坐还是站
     * true: 坐着
     * false: 站着
     *
     */
    boolean isSeat = true;

    /**
     * 单人价
     */
    private double eachPassengerPrice = 0.0f;

    public void setEachPassengerPrice(double eachPassengerPrice) {
        this.eachPassengerPrice = eachPassengerPrice;
    }

    public double getEachPassengerPrice() {
        return eachPassengerPrice;
    }

    /**
     *  这个乘客 坐多少站
     * */
    private  int station =1;

    public void setStation(int station) {
        this.station = station;
    }

    public int getStation() {
        return station;
    }

    public People(){

    }


    public boolean isSeat() {
        return isSeat;
    }

    public void setSeat(boolean seat) {
        isSeat = seat;
    }
}
