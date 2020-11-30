package 常用类.文件;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
