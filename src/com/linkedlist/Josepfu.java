package com.linkedlist;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/7/29 19:23
 * @Description:
 */
public class Josepfu {
    public static void main (String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.show();
        circleSingleLinkedList.count(1, 2, 5);
    }
}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first节点,当前没有编号
    private Kidss first = null;

    //构建成一个环形的链表
    public void add (int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Kidss cur = null;// 辅助指针，帮助构建环形链表
        // 使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {//这里不能从0开始i的数量不小于1
            // 根据编号，创建小孩节点
            Kidss kidss = new Kidss(i);
            if (i == 1) {// 如果是第一个小孩
                first = kidss;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(kidss);
                kidss.setNext(first);
                cur = kidss;
            }

        }
    }

    public void show () {

        if (first == null) {
            System.out.println("空");
            return;
        }

        Kidss cur = first;
        while (true) {
            System.out.printf("编号 %d \n", cur.getNo());
            if (cur.getNext() == first) {//遍历结束
                break;
            }
            cur = cur.getNext();//后移
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */

    public void count (int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

        // 创建要给辅助指针,帮助完成小孩出圈
        // 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
        Kidss helper = first;
        while (true) {
            if (helper.getNext() == first) {//最后
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次移动到指定开始位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first) {//一个
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first); //
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());


    }
}

class Kidss {
    private int no;
    private Kidss next;

    public Kidss (int no) {
        this.no = no;
    }

    public int getNo () {
        return no;
    }

    public void setNo (int no) {
        this.no = no;
    }

    public Kidss getNext () {
        return next;
    }

    public void setNext (Kidss next) {
        this.next = next;
    }
}