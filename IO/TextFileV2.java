import java.io.*;

/**
 * IO流：读文件，读1000行集中执行一次后续方法（如写操作）
 * Created by Administrator on 2017/10/24.
 */
public class TextFileV2 {
    private static String SPLIT_COMMA = ",";
    private static String LINE_BREAK = "\n";

    //execute write operation after read 1000 lines
    public void write(String fileNameIn, String fileNameOut, String encoding) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileNameIn).getAbsoluteFile()), encoding));
            FileWriter out = new FileWriter(new File(fileNameOut).getAbsoluteFile());
            try {
                String s;
                String[] arr;
                int readLineCount = 0; //读取行数
                while ((s=in.readLine()) != null) {
                    sb.append(s);
                    sb.append(LINE_BREAK);
                    readLineCount++;
                    if (readLineCount >= 1000) { //当读到1000行时，执行写操作，然后清空sb
                        out.write(sb.toString());
                        sb.delete(0, sb.length());
                        readLineCount = 0;
                    }
                }
                if (readLineCount > 0) { //当跳出循环，读取行数显示大于0时，执行写操作，然后清空sb
                    out.write(sb.toString());
                    sb.delete(0, sb.length());
                    readLineCount = 0;
                }
            } finally {
                out.close();
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("-- method start --");
        TextFileV2 textFileV2 = new TextFileV2();
        String fileNameIn = "E:\\files\\6correct.csv";
        String fileNameOut = "E:\\files\\6target.csv";
        String encoding = "UTF-8";
        textFileV2.write(fileNameIn, fileNameOut, encoding);
        System.out.println("-- method end --");
    }
}
