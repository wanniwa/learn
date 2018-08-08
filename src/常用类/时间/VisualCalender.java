package 常用类.时间;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisualCalender {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String dateStr = scanner.nextLine();
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateStr);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, 1);

        int week = calendar.get(Calendar.DAY_OF_WEEK);

        int maxDate = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= week - 1; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= maxDate; i++) {
            if (i == day) {
                System.out.print("*");
            }
            System.out.print(i + "\t");
            if ((i + week - 1) % 7 == 0) {
                System.out.print("\n");
            }
        }
        System.out.println();
    }
}
