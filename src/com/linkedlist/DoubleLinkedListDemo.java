package com.linkedlist;

import java.util.SortedMap;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/7/29 05:07
 * @Description:
 */
public class DoubleLinkedListDemo {
    public static void main (String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "1", "1");
        HeroNode2 hero2 = new HeroNode2(2, "2", "2");
        HeroNode2 hero3 = new HeroNode2(3, "3", "3");
        HeroNode2 hero4 = new HeroNode2(4, "4", "4");
        HeroNode2 hero5 = new HeroNode2(5, "5", "5");
        HeroNode2 hero6 = new HeroNode2(4, "6", "6");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero3);
        doubleLinkedList.show();
        doubleLinkedList.addByorder(hero2);
        doubleLinkedList.show();
        doubleLinkedList.delete(2);
        doubleLinkedList.show();
        doubleLinkedList.update(hero6);
        doubleLinkedList.show();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 gethead () {
        return head;
    }

    //这种方式只能添加最后，而且没有判断依据如果重复添加一个会死循环
    public void add (HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //没有找到最后，temp后移
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    public void addByorder (HeroNode2 heroNode2) {

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("空");
                break;
            }
            if (temp.next.no > heroNode2.no) {//在编号内
                break;
            } else if (temp.next.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("已存在");
        } else {
            heroNode2.next = temp.next;
            temp.next = heroNode2;
            heroNode2.pre = temp;
            temp.next.pre = heroNode2;
        }
    }

    public void delete (int no) {
        if (head.next == null) {
            System.out.println("空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //temp前一个节点的后继节点指向temp的后继节点
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;//后一个节点的前驱指向temp的前一个节点
            }
        } else {
            System.out.println("不存在");
        }

    }

    public void update (HeroNode2 newheroNode2) {
        if (head.next == null) {
            System.out.println("空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newheroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newheroNode2.name;
            temp.nickname = newheroNode2.nickname;
        } else {
            System.out.println("不存在");
        }
    }

    public void show () {
        if (head.next == null) {
            System.out.println("空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("遍历结束");
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2 (int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString () {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
