package thread.station;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/25
 **/
public class TestTicket {

    public static void main(String[] args) {
        TrainStation station = new TrainStation();

        Thread t1 = new Thread(station);
        Thread t2 = new Thread(station);
        Thread t3 = new Thread(station);

        t1.start();
        t2.start();
        t3.start();

    }
}
