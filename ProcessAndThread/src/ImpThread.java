/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/25
 **/
public class ImpThread implements Runnable{


    private  int TOTAL_TICKET = 50;
    @Override
    public void run() {
        System.out.println("开始进行子线程!");

        Thread thread = Thread.currentThread();
        System.out.println("thread = " + thread.getName());
        for (int index = 0; index < 100; index++) {
            System.out.println("TOTAL_TICKET = " + TOTAL_TICKET--);
        }
    }
}
