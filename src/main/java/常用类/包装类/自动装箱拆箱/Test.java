package 常用类.包装类.自动装箱拆箱;

public class Test {
    public static void main(String[] args) {

        Integer a = 1000; //编译器Integer a= new Integer(1000);
        int c = new Integer(0);//new Integer(0).intValue()

        Integer d1 =1234;
        Integer d2  =1234;
        System.out.println(d1==d2);
        System.out.println(d1.equals(d2));

        Integer d3 = -100; //[-128,127]之间的数仍然当作基本数据类型
        Integer d4 = -100;
        System.out.println(d3==d4);
        System.out.println(d3.equals(d4));



    }
}
