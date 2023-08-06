package thread.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePrinter extends Thread {
    @Override
    public void run() {
        try {
            while(true) {
                // 获取当前时间
                Date currentTime = new Date();
                // 格式化时间
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY:MM:dd:HH:mm:ss");
                String formattedTime = sdf.format(currentTime);
                // 打印时间
                System.out.println("Current time: " + formattedTime);
                // 线程休眠1秒
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 创建时间打印线程
        TimePrinter timePrinter = new TimePrinter();
        // 启动线程
        timePrinter.start();

    }
}
