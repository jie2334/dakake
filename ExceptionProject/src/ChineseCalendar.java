import java.util.Calendar;
import java.util.Locale;

public class ChineseCalendar {
    public static int Max_LENGTH=42;
    public static void main(String[] args) {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance(Locale.CHINA);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 月份从0开始，因此需要加1

        // 获取该月的实际天数
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 获取该月的第一天的星期几
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 转换为以星期一为起始天的顺序
        if (firstDayOfWeek == Calendar.SUNDAY) {
            firstDayOfWeek = Calendar.MONDAY;
        } else {
            firstDayOfWeek -= 1;
        }

        // 打印中国的当前日历
        System.out.println("一\t二\t三\t四\t五\t六\t日");

        // 打印日期
        int day = 1;

        int monthPre = calendar.get(Calendar.MONTH) - 1;

        calendar.set(Calendar.MONTH,monthPre);
        //获取前一周的总天数
        int daysPre = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 打印该月第一周的日期
       for (int i = 1; i <firstDayOfWeek;i++) {
            System.out.print((daysPre-firstDayOfWeek+1)+i +"\t");
            //System.out.print("\t");
        }
        for (int i = firstDayOfWeek; i <= 7; i++) {
            System.out.print(day++ + "\t");
        }
        System.out.println();



        // 打印该月其他周的日期
        while (day <= daysInMonth) {
            for (int i = 1; i <= 7 && day <= daysInMonth; i++) {
                System.out.print(day++ + "\t");
            }

            System.out.println();
        }


    }
}
