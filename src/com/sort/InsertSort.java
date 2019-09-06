package com.sort;

import java.net.SocketTimeoutException;
import java.util.Arrays;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/5 06:52
 * @Description:
 */
public class InsertSort {
    public static void main (String[] args) {
        int arr[] = {101, 34, 119, 1, -1, 90, 123};
        // InsertSort(arr);
        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

        //给insertVal 找到插入的位置
        //说明
        //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println(Arrays.toString(arr));
    }

    public static void InsertSort (int arr[]) {
        int insert, insertindex;
        for (int i = 1; i < arr.length; i++) {
            insert = arr[i];
            insertindex = i - 1;
            while (insertindex >= 0 && insert < arr[insertindex]) {
                arr[insertindex + 1] = arr[insertindex];
                insertindex--;
            }
            if (insertindex + 1 != i) {
                arr[insertindex + 1] = insert;
            }
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
    }
}
