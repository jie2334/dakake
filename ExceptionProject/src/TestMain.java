import java.util.ArrayList;

/**
 * @description: 异常类  作业
 * @author: 22783
 * @date: 2023/7/24
 **/
public class TestMain {
    /**
     * Exception 是 Java 程序运行中可预料的异常情况，
     * 我们可以获取到这种异常，并且对这种异常进行业务外的处理。
     * 它分为检查性异常和非检查性（RuntimeException）异常。
     * 两个根本的区别在于，检查性异常必须在编写代码时，使用 try catch 捕获（比如：IOException异常）。
     * 非检查性异常 在代码编写时，可以忽略捕获操作（比如：ArrayIndexOutOfBoundsException），
     * 这种异常是在代码编写或者使用过程中通过规范可以避免发生的。
     */



    /**常见异常:
     * ArrayIndexOutOfBoundsException
     * NullPointerException
     * RuntimeException
     * 不常见异常
     * AlreadyBoundException
     *  TimeoutException
     *  DatatypeConfigurationException
     *
     * @param
     */

    public void testArrayIndexOutOfBoundsException(){
        int[] array = new int[10];

        System.out.println("array = " + array[10]);//下标非法 ArrayIndexOutOfBoundsException
    }

    public void testNullPointerException(){
        ArrayList<String> list = null;//NullPointerException  对象没有赋值

        System.out.println("list = " + list.size());
    }

    public void testRuntimeException(){
        //抛出RuntimeException
        throw new RuntimeException("运行时异常抛出!");
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        TestMain testMain = new TestMain();
        //testMain.testArrayIndexOutOfBoundsException();

        //testMain.testNullPointerException();
    }
}
