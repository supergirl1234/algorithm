package com;

public class Display {

    public static  void display(ListNode head){


        ListNode cur=head;
        while(cur!=null){
            System.out.println(cur.val+" ");
            cur=cur.next;
        }

    }
}
