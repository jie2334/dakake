
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: 异常类的测试
 * @author: jiejie
 * @date: 2023/7/24
 **/
public class Main {
    static String code = "qwertyuiopasdfghjklzxcvbnm,QWERTYUIOPASDFGHJKLZXCVBNM<>741852963!@#$%^&*()";

    /**
     * Date()方法
     */


    public static void  dateTest() throws ArithmeticException{


        Date date = new Date();

        long time = date.getTime();
        System.out.println("time = " + time);

        int year = date.getYear();

        System.out.println("year = " + year);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        TimeZone timeZone = simpleDateFormat.getTimeZone();

        System.out.println("timeZone = " + timeZone);

        /**
         * 格式化时间、日历----的包装类
         */


        Date dateSec = new Date();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy年MM月dd日HH时mm分ss秒");

        String formatted = format.format(dateSec);

        System.out.println("formatted = " + formatted);


        System.out.println();
        /**
         * Calendar里面的get()方法就是获取当前日期的年月日的  数字   ；月份是从0开始计算的
         *
         */


        Calendar calendar = null;

        calendar.get(Calendar.YEAR);
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.DATE);
        calendar.get(Calendar.HOUR);
        calendar.get(Calendar.MINUTE);
        calendar.get(Calendar.SECOND);
        calendar.get(Calendar.MILLISECOND);



        try{
            //可能会出现的异常的代码
            int index = 9/0;
        }
        catch (RuntimeException e){//只捕获声明出来要捕获的类型的异常，也可以用Exception 来捕获下面所有的子类异常
            //获取当前产生的异常
            e.printStackTrace();
        }                          //catch语句可以写多个  但是不能捕获多次相同类型的异常
        finally {
            //最终执行的代码
            System.out.println("出现错误");
        }

    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        /*拼接随机字符串*/
        Random random = new Random();

        StringBuilder builder = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你要的数字: ");

        int index = scanner.nextInt();

        //根据输入的数字随机拿出来字符串

        for (int i = 0; i < index; i++) {

            int nexted = random.nextInt(code.length());

            builder.append(code.charAt(nexted));
        }

        String string = builder.toString();

        System.out.println("string = " + string);

        if (index==0){
            throw new RuntimeException();
        }

        dateTest();
        /**
         * 异常类 : Exception
         * ||
         *  两种抛出写法:
         *   方法名后面抛出让上层级调用者处理异常
         *   就在产生异常的区域抛出，让上层级处理
         *   处理异常:
         *      try  catch   finally  语句处理异常
         *   两种throw
         *      1、 throw
         *      2、 throws
         *
         *   方法名后面加上关键字  throws  Exception
         *          必须处理异常吗 ?
         */
    }




}
