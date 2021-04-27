package 算法.排序;

import java.util.Arrays;

public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {7, 10, 12, 3, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    public static void selectSort(int[] array) {

        //[1]使用外层循环指定标记位，然后将待排序序列中的元素一个一个的和标记位上的值进行比较，反序则互换；比较依然是进行n-1次即可
        for(int i = 0; i < array.length-1; i++) {
            //[2]使用内层循环j循环倒序遍历整个待排序序列，使用array[j]和标准位的array[i]进行大小比较
            for(int j = array.length-1; j > i; j--) {
                //[3]标准位上的元素和待排序序列中的元素进行比较，反序则互换
                if(array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

    }
}
