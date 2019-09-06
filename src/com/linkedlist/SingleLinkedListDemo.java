package com.linkedlist;

import java.util.LinkedList;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/7/26 09:25
 * @Description:
 */
public class SingleLinkedListDemo {
    public static void main (String[] args) {
        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "1", "1");
        HeroNode hero2 = new HeroNode(2, "2", "2");
        HeroNode hero3 = new HeroNode(3, "3", "3");
        HeroNode hero4 = new HeroNode(4, "4", "4");
        HeroNode hero5 = new HeroNode(5, "5", "5");
        HeroNode hero6 = new HeroNode(4, "6", "6");

        //加入
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero1);

        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder(hero5);
        singleLinkedList.showlist();
        singleLinkedList.addByOrder(hero6);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.showlist();

        HeroNode newHeroNode = new HeroNode(2, "8", "8");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后");
        singleLinkedList.showlist();
        singleLinkedList.delete(4);
        singleLinkedList.delete(1);
        singleLinkedList.showlist();

    }
}

//定义一个singlelinkedlist管理每个节点
class SingleLinkedList {
    //先初始化，头结点不要动，不存放具体数据，要不找不到
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点
    //不考虑顺序，找到最后节点将节点的next指向后继节点
    public void add (HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量遍历temp
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //没有找到最后，temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按顺序添加在指定位置
    //创建临时变量进行遍历找到添加位置的前一个节点
    //把temp.next指向下一个节点，把添加的节点指向下一个
    //heroNode是要插入的数据
    public void addByOrder (HeroNode heroNode) {
        //头不动

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //没有找到最后，temp后移
            if (temp.next.no > heroNode.no) {//在链表顺序内插入最后
                break;
            } else if (temp.next.no == heroNode.no) {//编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("已存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //删除
    public void delete (int no) {
        //头不动

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//已经在最后了
                break;
            }
            //没有找到最后，temp后移
            if (temp.next.no == no) {//找到删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }

        if (flag) {
            //找到删除
            temp.next = temp.next.next;

        } else {
            System.out.println("不存在");
        }

    }


    //修改
    public void update (HeroNode newHeroNode) {
        //头不动

        if (head.next == null) {
            System.out.println("空");
            return;
        }
        //找到需要修改的节点根据no编号
        //定义辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {//遍历完
                break;
            }
            //没有找到最后，temp后移
            if (temp.no == newHeroNode.no) {//找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;

        } else {
            System.out.println("没有不能修改");
        }

    }

    //显示
    public void showlist () {
        if (head.next == null) {
            System.out.println("空");
            return;
        }
        //因为head节点不能动，因此我们需要一个辅助变量遍历temp
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


//先定义一个heronode，每个heronode对象都是一个节点
class HeroNode {
    public int no;//编号
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode (int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便重写tostring
    @Override
    public String toString () {
        return "HeroNode{" +
                "node=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}




