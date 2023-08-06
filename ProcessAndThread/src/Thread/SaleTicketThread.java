package Thread;

/**
 * @description: TODO 介绍类
 *  加在方法名前面
 * @author: 22783
 * @date: 2023/7/25
 **/
public class SaleTicketThread extends Thread{


    private static int ticket = 50;
    SaleTicketThread(){

    }

    public SaleTicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("开始执行!");
        while(ticket>=0){

            System.out.println(getName()+"ticket = " + ticket--);
        }
    }

}
