import java.io.*;
import java.util.ArrayList;

/**
 * Created by wuti on 2017/10/10.
 */
public class TextFile extends ArrayList<String> {
    // Read a file as a single string:
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
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
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // write a big file:
    public static void writeBigFile(String fileName, String text) {
        try {
            FileWriter out = new FileWriter(new File(fileName).getAbsoluteFile());
            try {
                out.write(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Write the target file from a source file:
    public static void writeTargetFromSource(String targetFile, String sourceFile) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(sourceFile).getAbsoluteFile()));
            PrintWriter out = new PrintWriter(new File(targetFile).getAbsoluteFile());
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
        String sourceFile = "E:\\files\\6correct.csv";
        String targetFile = "E:\\files\\target.csv";
        String file = read(sourceFile);
        writeBigFile(targetFile, file);
    }
}
