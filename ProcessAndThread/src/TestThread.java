/**
 * @description: 创建线程类
 * @author: 22783
 * @date: 2023/7/25
 **/
public class TestThread extends Thread{
    long minPrime;

    public TestThread(long minPrime){
        this.minPrime=minPrime;
    }

    @Override//重写方法
    public void run() {
        //super.run();

        System.out.println("此线程开始执行!");
    }
}
