package 常用类.时间;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        Calendar cal = Calendar.getInstance();
        //创建时间
        Date createTime = cal.getTime();
        //将时间设置为本月第一天
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        //月初-1天 = 上个月月末
        cal.add(Calendar.DATE, -1);
        //上月月末时间
        Date endTime = cal.getTime();


        //设置日期为上月时间的第一天
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //上月开始时间
        Date startTime = cal.getTime();
        Integer month = cal.get(Calendar.MONTH) + 1;
        Integer year = cal.get(Calendar.YEAR);
    }
}
