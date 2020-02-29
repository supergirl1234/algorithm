package com;


import java.util.ArrayList;

/*
*
*输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
* */



class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution3 {


    public  static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list=new ArrayList<>();
        ListNode cur=listNode;

        while (cur!=null){
            list.add(0,cur.val);//利用List的特性插入数据
            cur=cur.next;

        }
        return  list;
    }

    /*递归*/
     static ArrayList<Integer> list2=new ArrayList<>();
    public  static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {


        ListNode cur=listNode;

        if (cur!=null){
          printListFromTailToHead2(cur.next);
          list2.add(cur.val);
        }
        return  list2;
    }
    public static void main(String[] args) {

        ListNode head=new ListNode(1);
        ListNode h2=new ListNode(2);
        ListNode h3=new ListNode(3);
        ListNode h4=new ListNode(4);
        ListNode h5=new ListNode(5);
        ListNode h6=new ListNode(6);
        head.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        h5.next=h6;
        ArrayList<Integer> list=printListFromTailToHead(head);
        System.out.println(list);
        ArrayList<Integer> list3=printListFromTailToHead2(head);
        System.out.println(list3);
    }
}
