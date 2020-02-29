package com;


/*
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * */
public class Solution9 {



    public static ListNode ReverseList(ListNode head) {

        ListNode result = null;

        ListNode cur = head;
        while (cur != null) {

            ListNode node = cur.next;//先记录下来下一个值

            /*头插*/
            cur.next = result;
            result=cur;

            cur = node;

        }

        return result;
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

        ListNode node=ReverseList(head);
         Display.display(node);
    }
}
