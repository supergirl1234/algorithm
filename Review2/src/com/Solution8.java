package com;


/*
 * 输入一个链表，输出该链表中倒数第k个结点。
 * */


/*使用双节点*/

public class Solution8 {


    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head==null){

            return  null;
        }
        ListNode pre = head;
        ListNode hou = head;
        for (int i = 0; i < k; i++) {

            pre = pre.next;
            if(pre==null&&i==k-1){

                return  hou;

            }
            if(pre==null){
                return  null;

            }

        }

        while (pre != null) {

            pre=pre.next;
            hou=hou.next;

        }

        return hou;
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
     /*   System.out.println(FindKthToTail(head,3).val);
        System.out.println(FindKthToTail(head,6).val);*/
        System.out.println(FindKthToTail(head,7).val);
    }
}
