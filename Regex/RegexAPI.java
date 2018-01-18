import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式API学习
 * Java正则表达式Pattern类与Matcher类学习
 * Created by Administrator on 2018/1/18.
 */
public class RegexAPI {

    private static String s;
    private static String pattern;

    /**
     * abcdefgghijklmnnopqqrstuvwwxyzz01002003004
     * 匹配连续2个字符的信息（如：gg,nn,qq等）
     */
    public static void match01() {
        s = "abcdefgghijklmnnopqqrstuvwwxyzz01002003004";
        pattern = "([A-Za-z0-9])(\\1)";
        String[] arr = s.split(pattern);
        for (String str : arr) {
            System.out.println(str);
        }
    }

    /**
     * abcdefgghijklmnnopqqrstuvwwxyzz01002003004
     * 匹配连续2个字符的信息（如：gg,nn,qq等）
     * @param index 匹配第几组
     * @return list
     */
    public static List<String> match02(int index) {
        s = "abcdefgghijklmnnopqqrstuvwwxyzz01002003004";
        pattern = "([A-Za-z0-9])(\\1)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(index));
        }
        return list;
    }

    public static void main(String[] args) {
        match01();
        System.out.println(match02(0)); //result=[gg, nn, qq, ww, zz, 00, 00, 00]
    }
}
