package Thread;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/25
 **/
public class TestTickets {
    /*
    *
    * lock，
    *
    * synchronized
    * 同步代码块
    *
    *
    * */

    public static void main(String[] args) {
        SaleTicketThread thread = new SaleTicketThread("窗口1");

        thread.start();

        SaleTicketThread thread1 = new SaleTicketThread("窗口2");

        thread1.start();

        SaleTicketThread thread2 = new SaleTicketThread("窗口3");

        thread2.start();


    }
}
