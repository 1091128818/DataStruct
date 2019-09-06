package com.search;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/9 16:48
 * @Description:
 */
public class SeqSearch {

    public static void main (String[] args) {

        int[] arr = {1, 9, -11, -1, 34, 89};
        int index = seqsearch(arr, -11);
        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("下标：" + index);
        }
    }

    /**
     * @param arr
     * @param value
     * @return
     */
    public static int seqsearch (int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
