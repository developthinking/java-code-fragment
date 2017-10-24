/**
 * String,StringBuilder,StringBuffer JDK 方法
 * Created by Administrator on 2017/10/24.
 */
public class ApiPractice {
    private static String SPLIT_COMMA = ";";

    /**
     * String API
     * 1.trim()
     * 2.indexOf(String str)    lastIndexOf(String str)
     * 3.substring(int beginIndex, int endIndex)
     * 4.replace(char oldChar, char newChar)    replaceAll(String regex, String replacement)
     * 5.toUpperCase()  toLowerCase()
     * 6.split(String regex)
     * 7.format
     */
    public void testS() {
        //1
        String str = " xxx ";
        System.out.println(str.trim()); //result="xxx"
        //2
        str = "xxx";
        System.out.println(str.indexOf("x")); //result=0
        System.out.println(str.lastIndexOf("x")); //result=2
        //3
        str = "xxx-hell-";
        System.out.println(str.substring(0, str.length())); //result="xxx-hell-"
        System.out.println(str.substring(0, str.length()-1)); //result="xxx-hell"
        /**
         * 4.例：以每两个数为一组，每组之间用";"隔开
         * replaceAll(String regex, String replacement)
         * 参数
         *  regex - 用来匹配此字符串的正则表达式
         *  replacement - 用来替换每个匹配项的字符串
         */
        str = "11854365.27,3199072.56,11973173.43,3143252.36";
        str = str.replaceAll("([0-9]*(\\.?)[0-9]*,[0-9]*(\\.?)[0-9]*),","$1;");
        System.out.println(str); //result="11854365.27,3199072.56;11973173.43,3143252.36"
        //5
        str = "abc";
        System.out.println(str.toUpperCase()); //result="ABC"
        System.out.println(str.toLowerCase()); //result="abc"
        //6
        str = "xyz;abc;ui";
        String[] strArr = str.split(SPLIT_COMMA); //result={"xyz","abc","ui"}
        for (String s : strArr) {
            System.out.println(s);
        }
        //7

    }

    /**
     * StringBuilder API
     * 1.append
     * 2.delete(int start, int end)
     */
    public void testSB() {
        StringBuilder sb = new StringBuilder();
        //1
        sb.append("xxx");
        System.out.println(sb.toString()); //result="xxx"
        //2
        sb.delete(0, sb.length());
        System.out.println(sb.toString()); //result=""
    }

    public static void main(String[] args) {
        ApiPractice api = new ApiPractice();
        api.testS();
        api.testSB();
    }
}
