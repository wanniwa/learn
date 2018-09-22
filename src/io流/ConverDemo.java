package io流;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ConverDemo {
    public static void main(String[] args) {
        String str = "中国";
        String str1 = "aa";
        System.out.println(str.length());
        System.out.println(str1.length());
        byte[] data = str.getBytes();
        byte[] data1 = str1.getBytes();
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(data1));
        System.out.println(new String(data));
        //编码如果不统一
        data = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(data));
        //编码
        byte[] data2 = "中国".getBytes(StandardCharsets.UTF_8);
        str = new String(data2, StandardCharsets.UTF_8);
        System.out.println(str);
    }
}
