package com.recursion;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/2 16:59
 * @Description:
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义一个数组，保存皇后位置的结果输出
    int array[] = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    public static void main (String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
    }

    //编写一个方法，放置第n个皇后
    //特别注意： check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
    private void check (int n) {
        if (n == max) {//n = 8 , 其实8个皇后就既然放好
            print();
            return;
        }
        //依次放入，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //
            array[n] = i;
            if (judge(n)) {//不冲突
                check(n + 1);
            }
        }

        //依次放入皇后，并判断是否冲突

    }

    //编写一个方法，放置第n个皇后
    //特别注意： check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
    private boolean judge (int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 说明
            //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1  放置第 2列 1 n = 1 array[1] = 1
            // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    private void print () {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
