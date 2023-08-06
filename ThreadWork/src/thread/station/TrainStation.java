package thread.station;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/25
 **/
public class TrainStation implements Runnable{
    //定义火车站的总票数
    private int tickets = 10;

   private static Lock lock = new ReentrantLock();

    public void saleTicket(){
        while(tickets>0){
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "售出一张票，剩余" + tickets-- + "张票");
            lock.unlock();
        }
    }

    @Override
    public void run() {
        saleTicket();
    }
}
