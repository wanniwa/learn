package 算法.排序;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {7, 10, 12, 3, 9, 5};
        sort1(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
    }

    private static void sort1(int[] arr) {
        //从第二个数开始
        for (int i = 1; i < arr.length; i++) {
            //当前最小的数
            int temp = arr[i];

            //arr[j-1]>temp，代表arr[j-1]的数字要往后移动一格
            //j-1>=0 => j>=1 => j>0
            int j = i;
            while (j >= 1 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = temp;
            }

        }
    }


}
