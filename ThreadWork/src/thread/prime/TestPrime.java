package thread.prime;

/**
 * @description: TODO 介绍类
 * @author: 22783
 * @date: 2023/7/25
 **/
public class TestPrime {

    public static void main(String[] args) {
        ParityNum parityNum = new ParityNum();

        Thread thread1 = new Thread(parityNum::printOddNumber);

        Thread thread2 = new Thread(parityNum::printEven);

        thread1.start();
        thread2.start();
    }
}
