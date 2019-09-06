package com.queue;

import java.util.Scanner;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/7/26 07:31
 * @Description:
 */
public class CircleArrayQueueDemo {
    public static void main (String[] args) {
        //测试
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e:退出");
            System.out.println("a:添加");
            System.out.println("g:取出");
            System.out.println("h:查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("头数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("退出");
    }
}

class CircleArrayQueue {
    private int maxSize;
    private int front;//头
    private int rear;//指向队尾最后一个
    private int arr[];

    public CircleArrayQueue (int arrmaxSize) {
        maxSize = arrmaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull () {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty () {
        return rear == front;
    }

    public void addQueue (int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }

        arr[rear] = n;
        //将rear后移，取模
        rear = (rear + 1) % maxSize;
        System.out.println(rear);

    }

    //front指向队列的第一个元素
    public int getQueue () {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue () {
        if (isEmpty()) {
            System.out.println("队列空，无数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size () {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue () {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        return arr[front];
    }
}
