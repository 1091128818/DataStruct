package com.sort;

import java.util.Arrays;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/5 06:04
 * @Description:
 */
public class SelectSort {

    public static void main (String[] args) {
        int arr[] = {101, 34, 119, 1, -1, 90, 123};
        SelectSort(arr);
        int minIndex = 0;
        int min = arr[0];
        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println(Arrays.toString(arr));

        minIndex = 1;
        min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void SelectSort (int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println();
            System.out.println(Arrays.toString(arr));
        }
    }
}
