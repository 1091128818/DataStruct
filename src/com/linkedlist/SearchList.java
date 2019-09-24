package com.linkedlist;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/9/16 22:35
 * @Description:
 */
public class SearchList {
    static SearchNode head = new SearchNode(1);

    public static void main (String[] args) {

        SearchList searchList = new SearchList();
        for (int i = 0; i < 10; i++) {
            searchList.add(i + 1);
        }
        System.out.println();
        searchList.display();
        searchList.searchNode(head,6);
        System.out.println();
    }

    public void add (int i) {
        SearchNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }
        SearchNode SearchNode = new SearchNode(i);
        temp.next = SearchNode;
    }

    public void display () { //输出单链表中所有结点
        SearchNode p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public int length () {//求带头结点单链表的长度
        int length = 0;
        SearchNode p = head.next;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }


    public SearchNode searchNode (SearchNode searchList,int k) {


        if (k<0) {
            return null;
        }

        SearchNode fast = head;
        SearchNode slow = head;
        int i = k;

        //走k步
        for( ; i>0 && fast != null;i--){
            fast = fast.next;
        }

        if(i>0){
            return null;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.getVal());
        return slow;
    }
}

class SearchNode {

    public int val;
    public SearchNode next;

    public int getVal () {
        return val;
    }

    public void setVal (int val) {
        this.val = val;
    }

    public SearchNode getNext () {
        return next;
    }

    public void setNext (SearchNode next) {
        this.next = next;
    }


    public SearchNode (int val) {
        this.val = val;
    }

}
