package com;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int x =sc.nextInt();
        long a[] = new long[x];
        long b[] = new long[x];
        for(int i=0;i<x;i++)
        {
            a[i]=sc.nextLong();
        }
        for(int i=0;i<x;i++)
        {
            b[i]=sc.nextLong();
        }
        long xys[] = new long[x*x];
        long res =0;
        for(int i=0;i<x;i++)
        {
            for(int j =0;j<x;j++)
            {
                xys[i] = a[i]+b[j];
                res = res^xys[i];
            }
        }
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        System.out.println(res);
    }
}
