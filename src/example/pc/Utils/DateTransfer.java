package example.pc.Utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransfer {
    private static String FORM = "yyyy-MM-dd";
    private static SimpleDateFormat simpleDateFormat;

    static {
        simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(FORM);
    }

    public static Date toDate(String time) throws ParseException {
        Date date = simpleDateFormat.parse(time);
        date.setYear(date.getYear()+1900);
        date.setMonth(date.getMonth()+1);
        return date;
    }

    public static String toTimeString(Date date){
        String time = simpleDateFormat.format(date);
        return time;
    }

    public static void setFormat(String format){
        FORM = format;
    }
}
