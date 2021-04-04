package 算法.排序;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr = {7, 10, 12, 3, 9, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {

        for (int gap = arr.length / 3 + 1; gap > 1; gap = gap / 3 + 1) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i;
                while (j > i - gap+1 && tmp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                if (j != i) {
                    arr[j] = tmp;
                }
            }
        }
    }
}
