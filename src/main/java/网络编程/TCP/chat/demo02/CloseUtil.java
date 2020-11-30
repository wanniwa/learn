package 网络编程.TCP.chat.demo02;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
    public static void closeAll(Closeable... io) {
        for (Closeable temp : io) {
            if (null != temp) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

