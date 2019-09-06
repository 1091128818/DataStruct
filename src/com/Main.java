package com;

import java.util.Scanner;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/30 13:29
 * @Description:
 */
public class Main {
    static int[] a = new int[100];

    public static void main (String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.println("心态崩了");
            int n = in.nextInt();
            int count = q(n, n, 0);
            System.out.println("共有" + count + "种划分方式");
        }
    }

    public static int q (int n, int m, int i) {
        if (n < m) {
            return q(n, n, i);
        }
        a[i] = m;
        if (n == 0 || m == 0) {
            //打印下标从0到i
            printP(i);
            return 0;
        }
        if (n == 1 || m == 1) {
            if (n == 1) {
                //打印下标从0到i
                printP(i);
            } else q(n - 1, 1, i + 1);
            return 1;
        }
        if (n == m) {
            //打印下标从0到i
            printP(i);
            return 1 + q(n, n - 1, i);
        }

        return q(n - m, m, i + 1) + q(n, m - 1, i);
    }

    public static void printP (int i) {
        System.out.print("{");
        for (int j = 0; j <= i; j++) {
            if (j == i) System.out.print(a[j]);
            else System.out.print(a[j] + "+");
        }
        System.out.println("};");
    }

}
