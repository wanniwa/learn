package 数组;


import java.util.Arrays;

/**
 * @author wanniwa
 * @date 2018/7/31 15:30
 */
public class ArrayTest {
    public static void main(String[] args) {
        //1.定义静态数组，指定数组的元素内容，但不指定数组的长度
        int[] arr1 = new int[]{1, 2, 3};
        //2.定义动态数组，指定数组的长度，不指定数组的内容
        int[] arr2 = new int[5];
        //3.动态数组的默认值
        int[] arr3 = new int[5];
        System.out.println("整型数组的默认值："+Arrays.toString(arr3)); //byte short int long -> 0

        double[] arr4= new double[5];
        System.out.println("浮点型数组的默认值："+Arrays.toString(arr4)); //double float -> 0.0

        char[] arr5= new char[5];
        System.out.println("字符型数组的默认值："+Arrays.toString(arr5)); //char -> 空格（取值为0的字符）

        boolean[] arr6= new boolean[5];
        System.out.println("布尔型数组的默认值："+Arrays.toString(arr6)); //boolean -> false

        String[] arr7= new String[5];
        System.out.println("引用数据类型数组的默认值："+Arrays.toString(arr7)); //应用数据类型数组 -> null

        //4.数组的其他概念
        System.out.println("访问数组的长度：" + arr7.length);

        //数组下标的起始值0
        //数组下标最大值和数组长度之间的关系：arr.length-1


        int[][] a = {
                {1, 2},
                {3, 4, 0},
                {5, 6} };

        int[][] b = new int[3][];
        b[0] = new int[2];
        b[1] = new int[3];
        b[2] = new int[2];
        b[0][0] = 1;
        b[0][1] = 2;
        b[1][0] = 3;
        b[1][1] = 4;

        b[2][0] = 5;
        b[2][1] = 6;
        System.out.println(b[1][2]);

    }
}
