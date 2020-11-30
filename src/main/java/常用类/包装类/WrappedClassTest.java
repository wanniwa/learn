package 常用类.包装类;

public class WrappedClassTest {
    public static void main(String[] args) {
        Integer i = new Integer(1000);
        System.out.println(Integer.MAX_VALUE);
        //二进制
        System.out.println(Integer.toBinaryString(i));
        //16
        System.out.println(Integer.toHexString(i));
        int parseInt = Integer.parseInt("0234");
        System.out.println(parseInt);
    }
}
