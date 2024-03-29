package com.recursion;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/2 10:31
 * @Description:
 */
public class RecursionTest {
    public static void main (String[] args) {
        test(4);
        int res = factorial(5);
        System.out.println("res=" + res);
    }

    //打印
    public static void test (int n) {
        if (n > 2) {
            test(n - 1);
        } else {
            System.out.println("n=" + n);
        }
    }

    //阶乘
    public static int factorial (int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;//1*2*3...
        }
    }
}
