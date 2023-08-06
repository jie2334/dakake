package thread.impl;

/**
 * @description: 几种锁的实现
 * 1、synchronized
 * 2、lock
 * @author: 22783
 * @date: 2023/7/25
 **/
public class ImplThread {


    private int number = 0;

    public synchronized void test() {
        number++;
    }


    public synchronized int getNumber() {
        return number;
    }

}
