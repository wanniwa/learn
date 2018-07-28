package Lambda表达式;

import javax.swing.*;

/**
 * @author wanniwa
 * @date 2018/7/11 14:01
 */
public class Test1 {
    public static void main(String[] args) {
        //引用类方法
        Converter converter1 = from -> Integer.valueOf(from);
        Converter converter2 = Integer::valueOf;
        //引用特定对象的实例方法
        Converter converter3 = from -> "asadks".indexOf(from);
        Converter converter4 = "asadks"::indexOf;
        Integer value = converter4.converter("k");
        System.out.println(value);
        //引用某类对象的实例方法
        MyTest myTest = (a, b, c) -> a.substring(b, c);
        MyTest myTest1 = String::substring;
        String str = myTest.test("Java I love you", 2, 9);
        System.out.println(str);
        //引用构造器
        YourTest yourTest = a -> new JFrame(a);
        YourTest yourTest1 = JFrame::new;
        JFrame jFrame = yourTest1.win("你好");
        System.out.println(jFrame.toString());


    }
}
