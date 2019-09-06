package com.queue;

//使用数据模拟队列
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];

    //创建构造器(用来初始化)
    public ArrayQueue (int arrmaxSize) {
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队尾
    }

    public boolean isFull () {
        return rear == maxSize - 1;
    }

    public boolean isEmpty () {
        return rear == front;
    }

    public void addQueue (int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;//rear后移
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue () {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        front++;//front后移
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue () {
        if (isEmpty()) {
            System.out.println("队列空，无数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue () {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无数据");
        }
        return arr[front + 1];
    }
}

