package com;

/*
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution1 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead;//快指针
        ListNode low = pHead;//慢指针
        while (fast != null&&fast.next!=null) {

            fast = fast.next.next;
            low = low.next;
            if (fast==low) {//相遇
                break;
            }
        }
        if(fast==null||fast.next==null) {//如果没有环
            return null;
        }
        /*然后，一个指针从头节点开始走，一个指针从相遇点开始走，必能在环的入口点相遇*/
        ListNode p1=pHead;
        while (p1!=fast){
            p1=p1.next;
            fast=fast.next;
        }

        return  p1;
    }

    public static void main(String[] args) {

    }
}