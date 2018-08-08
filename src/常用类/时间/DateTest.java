package 常用类.时间;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss，本年第w周 本月第W周");
        Date d= new Date(12343241213L);
        String str = df.format(d);
        System.out.println(str);
        System.out.println("####################################");
        String str2 = "1977,2,3";
        DateFormat df2= new SimpleDateFormat("yyyy,MM,dd");
        try {
            Date parse = df2.parse(str2);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
