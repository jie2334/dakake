/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/26
 **/
public class GossipTest {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Thread thread = Thread.currentThread();

        Thread.State state = thread.getState();

        System.out.println("state = " + state);


    }
}
