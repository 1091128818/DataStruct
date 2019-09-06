package com.sort;

import java.util.Arrays;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/5 11:31
 * @Description:
 */
public class QuickSort {
    public static void main (String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort (int arr[], int left, int right) {
        int l = left;
        int r = right;
        int p = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < p) {
                l += 1;
            }
            while (arr[r] > p) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == p) {
                r -= 1;
            }
            if (arr[r] == p) {
                l += 1;
            }
            if (l == r) {
                l += 1;
                r -= 1;
            }
            if (left < r) {
                QuickSort(arr, left, r);
            }
            if (right > l) {
                QuickSort(arr, l, right);
            }
        }

    }
}
