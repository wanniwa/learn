package 常用类.时间;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VisualCalender {
    public static void main(String[] args) throws ParseException {
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        String dateStr = "2018-02-06";
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateStr);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,1);

        int week = calendar.get(Calendar.DAY_OF_WEEK);
        int actualMaximum = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <=week; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <=actualMaximum; i++) {
            System.out.print(i+"\t");
            if ((i+week)%7==0){
                System.out.print("\n");
            }
        }
    }
}
