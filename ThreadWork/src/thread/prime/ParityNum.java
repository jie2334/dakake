package thread.prime;

/**
 * @description: 打印1-100奇偶数
 * @author: 22783
 * @date: 2023/7/25
 **/
public class ParityNum implements Runnable{

    private int number = 100;

    public synchronized void printOddNumber(){
        for (int index = 1; index <= number; index++) {
            if (index%2!=0){
                System.out.println("奇数: index = " + index);
            }
        }

    }

    public synchronized void printEven(){
        for (int index = 1; index <= number; index++) {
            if (index%2==0){
                System.out.println("偶数: index = " + index);
            }
        }
    }

    @Override
    public void run() {
        printOddNumber();
        printEven();
    }
}
