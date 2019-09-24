package com.linkedlist;


/**
 * @Auther: 大哥的叔
 * @Date: 2019/9/9 18:19
 * @Description:
 */
public class ModList {
    static ListNode head = new ListNode(0);

    public static void main (String[] args) {

        ModList modList = new ModList();
        for (int i = 0; i < 10; i++) {
            modList.add(i + 1);
        }
        System.out.println();
        modList.display();
        modList.modNode(head);
        System.out.println();

    }

    public void add (int i) {
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }
        ListNode node = new ListNode(i);
        temp.next = node;
    }

    public void display () { //输出单链表中所有结点  
        ListNode p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public int length () {//求带头结点单链表的长度  
        int length = 0;
        ListNode p = head.next;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }


    public ListNode modNode (ListNode modList) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (length()% 2 == 0) System.out.println(slow.next.getVal());
        else System.out.println(slow.getVal());
        return slow;

    }
}

class ListNode {
    public int getVal () {
        return val;
    }

    public void setVal (int val) {
        this.val = val;
    }

    public ListNode getNext () {
        return next;
    }

    public void setNext (ListNode next) {
        this.next = next;
    }

    public int val;
    public ListNode next;

    public ListNode (int val) {
        this.val = val;
    }
}
