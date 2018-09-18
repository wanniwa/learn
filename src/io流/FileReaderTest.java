package io流;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        //java7
        try (FileReader fileReader = new FileReader("E:\\gitWork\\learn\\src\\io流\\FileReaderTest.java")) {
            char[] cbuf= new char[32];
            int hasRead = 0;
            while ((hasRead = fileReader.read(cbuf))>0){
                System.out.print(new String(cbuf,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
