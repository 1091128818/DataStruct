package com.sparseArray;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.ForkJoinPool;

public class SparseArray {
    public static void main (String[] args) {

        //创建一个原始二维数组
        //0表示没有棋子，1表示黑子2表示蓝
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row : chessArr1
        ) {
            for (int data : row
            ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转化稀疏数组
        //1.先遍历二维数组 得到非零的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }
        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //将数据导入
        //遍历数组将非零数据导入
        int count = 0;//记录是第几个非零数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println();
        for (int i = 0; i < sparseArr.length; i++) {

            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        //文件写入
        try {
            FileWriter s = new FileWriter("map.txt");
            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < 3; j++) {
                    s.write(sparseArr[i][j]);
                }
            }
            s.flush();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int[][] sparseArr2 = new int[sum + 1][3];
        int getNum = 0;
        try {
            FileReader reader = new FileReader("map.txt");

            for (int i = 0; i < sparseArr2.length; i++) {
                for (int j = 0; j < 3; j++) {
                    getNum = reader.read();
                    sparseArr2[i][j] = getNum;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("读取后稀疏数组为");
        for (int i = 0; i < sparseArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr2[i][0], sparseArr2[i][1], sparseArr2[i][2]);
            //格式化输出
        }
        System.out.println();
        //输出一下的稀疏数组
        //1先读取第一行数据的行列创建恢复原始数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //再将数组内容导入
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        for (int[] row : chessArr2
        ) {
            for (int data : row
            ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
