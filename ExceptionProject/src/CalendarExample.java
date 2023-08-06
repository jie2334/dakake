import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        // 获取当前年份和月份
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        // 设置为该月的第一天
        calendar.set(year, month - 1, 1);

        // 计算月份的第一天是星期几
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 计算需要填充的上个月的天数
        int previousMonthDays = (dayOfWeek - calendar.getFirstDayOfWeek() + 7) % 7;

        // 计算当前月份的天数
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 打印日历头部
        System.out.println("Mon\tTue\tWed\tThu\tFri\tSat\tSun");

        // 打印上个月的填充天数
        for (int i = 0; i <previousMonthDays-1; i++) {
            int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - (previousMonthDays - i - 1);
            System.out.print(day + "(prev)\t");
        }

        // 打印当前月份的天数
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.print(i + "\t");

            // 换行
            if ((i + previousMonthDays) % 7 == 0) {
                System.out.println();
            }
        }

        // 计算需要填充的下个月的天数
        int nextMonthDays = 7 - (daysInMonth + previousMonthDays) % 7;

        // 打印下个月的填充天数
        for (int i = 1; i <= nextMonthDays; i++) {
            System.out.print(i + "(next)\t");
        }
    }
}
