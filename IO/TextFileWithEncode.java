import java.io.*;
import java.util.ArrayList;

/**
 * Created by wuti on 2017/10/10.
 */
public class TextFileWithEncode {
    // Read a file as a single string:
    public static String read(String fileName, String encoding) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName).getAbsoluteFile()),encoding));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    // Write a single file in one method call:
    public static void write(String fileName, String text, String encoding) {
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName).getAbsoluteFile()),encoding));
            try {
                out.println(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Write a new file from a source file:
    public static void writeNewFromOld(String targetFile, String sourceFile, String encoding) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sourceFile).getAbsoluteFile()),encoding));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(targetFile).getAbsoluteFile()),encoding));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    out.println(s);
                }
            } finally {
                out.close();
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String targetFile = "E:\\files\\target.txt";
        String sourceFile = "E:\\files\\source.txt";
        String encoding = "utf-8";
        String file = read(sourceFile, encoding);
        write(targetFile, file, encoding);
    }
}
