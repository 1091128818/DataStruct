package com.sort;

import java.util.Arrays;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/5 09:54
 * @Description:
 */
public class ShellSort {
    public static void main (String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        ShellSort(arr);
        ShellSort2(arr);
    }

    //存在问题太慢不能全部交换
    public static void ShellSort (int arr[]) {
        int temp = 0;
        int count = 0;
        for (int g = arr.length / 2; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                for (int j = i - g; j >= 0; j -= g) {
                    if (arr[j] > arr[j + g]) {
                        temp = arr[j];
                        arr[j] = arr[j + g];
                        arr[j + g] = temp;
                    }
                }
            }
            System.out.println((++count) + Arrays.toString(arr));
        }
    }

    public static void ShellSort2 (int arr[]) {

        for (int g = arr.length / 2; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                int j = i;//保存插入位置
                int temp = arr[j];
                if (arr[j] < arr[j - g]) {//优化过程之前是对两个交换现在是直接插入
                    while (j - g >= 0 && temp < arr[j - g]) {
                        arr[j] = arr[j - g];
                        j -= g;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
