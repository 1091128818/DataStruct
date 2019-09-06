package com.hashtable;

import java.util.Scanner;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/11 10:45
 * @Description:
 */
public class hashTableDemo {
    public static void main (String[] args) {
        hashTablele hashTable = new hashTablele(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("id: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "id":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.findId(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}

class hashTablele {
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示有多少条链表

    //构造器
    public hashTablele (int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //？留一个坑, 这时不要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add (Emp emp) {
        //根据员工的id ,得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历所有的链表,遍历hashTable
    public void list () {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id,查找雇员
    public void findId (int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findId(id);
        if (emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }


    public int hashFun (int id) {
        return id % size - 1;
    }

}


//表示一个雇员//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp (int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList ,表示链表
class EmpLinkedList {

    private Emp head;

    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
    //   因此我们将该雇员直接加入到本链表的最后即可
    public void add (Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp temp = head;
        while (true) {
            if (temp.next == null) {//说明到链表最后
                break;
            }
            temp = temp.next;//后移
        }
        //退出时直接将emp 加入链表
        temp.next = emp;
    }

    public void list (int no) {
        if (head == null) {
            //说明链表为空
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        Emp temp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public Emp findId (int id) {
        if (head == null) {
            //说明链表为空
            System.out.println("链表为空");
            return null;
        }
        Emp temp = head;
        while (true) {
            if (temp.id == id) {
                break;
            }
            //退出
            if (temp.next == null) {//说明遍历当前链表没有找到该雇员
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}
