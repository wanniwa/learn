package 算法.排序;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr = {7, 10, 12, 3, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {
        int step = arr.length / 2;

        while (step >= 1) {
            for (int i = 0; i < step; i++) {
                sort1(arr, step, i);
            }
            step /= 2;
        }

        //for (int gap = arr.length / 3 + 1; gap >= 1; gap = gap / 3 + 1) {
        //    for (int i = 0; i < gap; i++) {
        //        int tmp = arr[i];
        //        int j = i;
        //        while (tmp < arr[i + 1]) {
        //
        //            j -= gap;
        //        }
        //
        //        if (j != i) {
        //            arr[j] = tmp;
        //        }
        //    }
        //    if (gap == 1) {
        //        break;
        //    }
        //}
    }

    private static void sort1(int[] arr, int step, int start) {

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = start + step; i < arr.length; i += step) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j - step >= 0 && tmp < arr[j - step]) {
                arr[j] = arr[j - step];
                j -= step;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
    }
}
