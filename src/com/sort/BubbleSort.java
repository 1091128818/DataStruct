package com.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/3 16:51
 * @Description:
 */
public class BubbleSort {
    public static void main (String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
//        BubbleSort(arr);
//        int[] arr = new int[80000];
//        for(int i =0; i < 80000;i++) {
//            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
//        }
//
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        BubbleSort(arr);

//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序后的时间是=" + date2Str);
    }
    //第一趟排序将最大的元素放置最后
//        int temp = 0;//临时变量做交换
//        for (int j = 0; j < arr.length-1; j++) {
//            for (int i = 0; i < arr.length - 1 - j; i++) {
//                //如果前面的数比后面的数大就交换
//                if (arr[i] > arr[i + 1]) {
//                    temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                }
//            }
//
//        } System.out.println(Arrays.toString(arr));
//    for (int i = 0; i < arr.length-1-1; i++) {
//        //如果前面的数比后面的数大就交换
//        if (arr[i]>arr[i+1]) {
//            temp = arr[i];
//            arr[i]=arr[i+1];
//            arr[i+1] = temp;
//        }
//    }
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < arr.length-1-2; i++) {
//            //如果前面的数比后面的数大就交换
//            if (arr[i]>arr[i+1]) {
//                temp = arr[i];
//                arr[i]=arr[i+1];
//                arr[i+1] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//}

    public static void BubbleSort (int arr[]) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}

