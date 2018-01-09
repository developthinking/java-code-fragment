import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * Created by Administrator on 2018/1/9.
 */
public class DateFormat {

    /**
     * date类型进行格式化输出
     * @param date date
     * @return dateStr
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 将一定格式的字符串转化为Date
     * @param dateStr dateStr
     * @return date
     * @throws ParseException
     */
    public static Date strToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateStr);
        return date;
    }

    /**
     * 将CST时间格式字符串进行格式化输出
     * @param dateStr dateStr
     * @return dateStrNew
     * @throws ParseException
     */
    public static String cstFormat(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = sdf.parse(dateStr);
        return dateFormat(date);
    }

    /**
     * 将long类型转化为Date
     * @param mseconds 毫秒数
     * @return date
     */
    public static Date longToDate(long mseconds) {
        return new Date(mseconds);
    }

    /**
     * 将long类型进行格式化输出
     * @param mseconds 毫秒数
     * @return dateStr
     */
    public static String longFormat(long mseconds) {
        Date date = new Date(mseconds);
        return dateFormat(date);
    }
}
