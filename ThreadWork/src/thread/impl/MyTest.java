package thread.impl;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/25
 **/
public class MyTest {
    public static void main(String[] args) throws InterruptedException {

        ImplThread thread = new ImplThread();

        MyThread myThread = new MyThread(thread);
        MyThread thread1 = new MyThread(thread);

        myThread.start();
        thread1.start();


        //System.out.println(thread.getNumber());
    }
}
