import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date(util)、Date(sql)、Timestamp(sql)
 * Created by Administrator on 2017/10/26.
 */
public class ApiPractice {
    private static String dateStr = "2017/10/26 12:34:23";
    private static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    //String -- Date
    public void string_date() {
        try {
            Date date = sdf.parse(dateStr);
            date = new Date();
            dateStr = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //String -- Timestamp
    public void string_timestamp() {
        dateStr = "2017-10-26 12:34:23"; //timestamp.valueof方法 string格式为 yyyy-mm-dd hh:mm:ss[.fffffffff]
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //result=2017-10-26 18:57:30.032
        timestamp = new Timestamp(new Date().getTime());
        timestamp = Timestamp.valueOf(dateStr); //result=2017-10-26 12:34:23.0

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timestamp = new Timestamp(System.currentTimeMillis());
        dateStr = timestamp.toString(); //result=2017-10-26 19:04:12.391
        dateStr = sdf.format(timestamp); //result=2017-10-26 19:03:47
    }

    //Date(util) -- Timestamp
    public void date_util_timestamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        date = timestamp;
        timestamp = new Timestamp(new Date().getTime());
    }

    //Date(sql) -- Timestamp
    public void date_sql_timestamp() {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis()); //Date(sql)只到年月日 result=2017-10-26
        Timestamp timestamp = new Timestamp(date.getTime());
    }

    public static void main(String[] args) {

    }
}
