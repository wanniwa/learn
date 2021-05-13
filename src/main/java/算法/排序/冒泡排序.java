package 算法.排序;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 0};
        sort4(arr);

    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void sort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swagFlag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swagFlag = true;
                }
            }
            if (!swagFlag) {
                return;
            }
        }
    }

    private static void sort2(int[] arr) {
        int left = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swagFlag = false;
            int pos = 0;
            for (int j = 0; j < left; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swagFlag = true;
                    pos = j;
                }
            }
            if (!swagFlag) {
                return;
            }
            left = pos;
        }
    }

    private static void sort3(int[] arr) {
        int left = arr.length - 1;
        for (int i = 0; i < arr.length - 1 & left > 0; i++) {
            int pos = 0;
            for (int j = 0; j < left; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    pos = j;
                }
            }
            left = pos;
        }
    }

    private static void sort4(int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        while (left < right) {
            boolean swagFlag = false;
            int pos = 0;
            for (int j = left; j < right; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swagFlag = true;
                    pos = j;
                }
            }
            right = pos;
            if (!swagFlag) {
                return;
            }
            swagFlag = false;
            int pos1 = 0;
            for (int k = right; k > left; k--) {
                if (arr[k] < arr[k - 1]) {
                    int tmp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = tmp;
                    swagFlag = true;
                    pos1 = k;
                }
            }
            left = pos1;
            if (!swagFlag) {
                return;
            }
        }
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
