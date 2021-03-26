package 算法.排序;

import java.util.Arrays;

// 排序代码
public class Bubble {
    /*
    对数组a中的元素进行排序
    */
    public static void sort(Comparable[] a) {
        //
        //北京市昌平区建材城西路金燕龙办公楼一层 电话：400-618-9090
        //冒泡排序的时间复杂度分析 冒泡排序使用了双层for循环，其中内层循环的循环体是真正完成排序的代码，所以，
        //我们分析冒泡排序的时间复杂度，主要分析一下内层循环体的执行次数即可。
        //在最坏情况下，也就是假如要排序的元素为{6,5,4,3,2,1}逆序，那么：
        //元素比较的次数为：
        //(N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
        //元素交换的次数为：
        //(N-1)+(N-2)+(N-3)+...+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2;
        //总执行次数为：
        //(N^2/2-N/2)+(N^2/2-N/2)=N^2-N;
        //按照大O推导法则，保留函数中的最高阶项那么最终冒泡排序的时间复杂度为O(N^2).
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    /*
    比较v元素是否大于w元素
    */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /*
    数组元素i和j交换位置
    */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
