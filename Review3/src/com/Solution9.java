package com;

/*
* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*
* */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution9 {

    /*使用三指针*/
    public ListNode deleteDuplication(ListNode pHead)
    {

        if(pHead==null){

            return  null;
        }
        ListNode P=new ListNode(0);
        P.next=pHead;
        ListNode pre=P;//前指针
        ListNode cur=pHead;
        ListNode pos=pHead.next;//后指针

        while(cur!=null&&pos!=null){
            if(cur.val!=pos.val){
                pre=pre.next;
                cur=cur.next;
                pos=pos.next;

            }else{

                while (pos!=null&&cur.val==pos.val){

                    pos=pos.next;

                }
                pre.next=pos;
                cur=pos;
                if(pos!=null) {
                    pos = pos.next;
                }


            }
        }

        return  P.next;
    }
    public static void main(String[] args) {

    }
}
