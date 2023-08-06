import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 进程线程
 * 从计算机组成的角度来解释线程和进程的概念，可以将其理解为不同层次的执行单元和资源分配单位。
 * 进程是操作系统对程序执行的一种抽象，它代表了一个独立的、可执行的程序实例。
 * 在计算机组成中，进程是由操作系统分配的各种资源的集合，包括内存空间、文件句柄、打开的网络连接等。
 * 每个进程都拥有自己的一套寄存器、堆栈和数据段，它们之间互相独立，不能直接访问彼此的内存空间。
 * 线程是进程内的执行单元，它是计算机处理器调度的最小单位。在同一个进程内，多个线程共享相同的代码和数据空间，
 * 它们可以并发执行。线程之间共享进程分配的资源，包括内存、文件等。在计算机组成中，线程可以看作是进程的分支，
 * 不同的线程之间通过共享的存储空间进行通信和同步。
 * 在多核处理器系统中，每个CPU核心可以执行一个线程，因此多线程可以实现并行计算。
 * 而同一个进程内的多个线程可以通过共享内存快速交换数据和信息，而不需要通过慢速的进程间通信机制。
 * 总结来说，进程是操作系统对程序执行的抽象，代表了一个独立的执行实例，拥有独立的资源；
 * 而线程是进程内的执行单元，共享进程的资源，可用于并发执行和快速的线程间通信。
 * 进程和线程在计算机组成中扮演不同的角色，用于管理和分配计算机的资源和任务。
 * @author: 22783
 * @date: 2023/7/25
 **/
public class TestProcessAndThread {

    public final ReentrantLock lock = new ReentrantLock();
    public static synchronized void testThread(){
        System.out.println("jiejie!~~~~~~~~~~~~");
    }



    public void test(){
        lock.lock();
        try{
            System.out.println("锁上了!");
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        TestThread thread = new TestThread(23L);
        thread.start();

        ImpThread thread1 = new ImpThread();
        new Thread(thread1,"刘亦菲").start();
        /*只有调用start方法才会开启线程*/

        /*程序休眠方法*/
        Thread.sleep(1000L);

        ImpThread imp = new ImpThread();
        new Thread(imp,"jiejie").start();

        TestProcessAndThread testProcessAndThread = new TestProcessAndThread();

        testProcessAndThread.test();

    }
}
