package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

    //将数据中的当天时间转换成星期
    public static String getWeek(String local_date) {
        String week = null;
        int day = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            long str = simpleDateFormat.parse(local_date).getTime();
            Date date = new Date(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            day = calendar.get(Calendar.DAY_OF_WEEK);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        switch (day) {
            case 1:
                week = "周日";
                break;
            case 2:
                week = "周一";
                break;
            case 3:
                week = "周二";
                break;
            case 4:
                week = "周三";
                break;
            case 5:
                week = "周四";
                break;
            case 6:
                week = "周五";
                break;
            case 7:
                week = "周六";
                break;
        }
        return week;
    }

    public static String FormatDateTime(String local_time){
        String dateString = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/dd");
        try {
            long str = simpleDateFormat.parse(local_time).getTime();
            Date date = new Date(str);
            dateString = simpleDateFormat1.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateString;
    }

}
