package com.stack;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/7/31 17:27
 * @Description:
 */
public class LinkedListStackDemo {

    public static void main (String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println("栈里面值的个数为：" + linkedListStack.getLength());
        linkedListStack.pop();


    }
}

class LinkedListStack {
    int replace = -1;
    private Stack headnode = new Stack(replace);

    public boolean isEmpty () {
        return headnode == null;
    }

    public void push (int data) {//入栈
        if (headnode.getData() == replace) {//判断头结点的值为空的时候
            headnode.setData(data);
        } else if (headnode == null) {
            headnode = new Stack(data);
        } else {
            Stack newnode = new Stack(data);
            newnode.setNext(headnode);
            headnode = newnode;
        }
    }


    public int pop () {//出栈(返回栈顶的值，并且删除)
        int data = replace;
        if (isEmpty()) {
            System.out.println("栈为空，返回值为0");
            return 0;
        }
        data = headnode.getData();
        headnode = headnode.getNext();
        return data;
    }

    public int top () {//返回栈顶的值，但是不删除
        int data = replace;
        if (isEmpty()) {
            System.out.println("栈为空，返回值为0");
            return 0;
        }
        data = headnode.getData();
        return data;
    }

    public int getLength () {//得到栈里面值的个数
        int count = 0;
        Stack tempnode = headnode;
        if (isEmpty() || tempnode.getData() == replace)//当头结点为空，并且值也为空的时候就返回0
        {
            count = 0;
        } else {
            while (tempnode != null) {
                count++;
                tempnode = tempnode.getNext();
            }
        }
        return count;
    }

}

class Stack {
    private int data;
    private Stack next;

    public Stack (int data) {
        this.data = data;
    }

    public int getData () {
        return data;
    }

    public void setData (int data) {
        this.data = data;
    }

    public Stack getNext () {
        return next;
    }

    public void setNext (Stack next) {
        this.next = next;
    }
}