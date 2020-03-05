package com;

/*
*
* 给定一个单链表（无环），请判断是否是回文结构。在删除倒数第K个节点后，是否为回文结构。
(回文结构：从头到尾遍历节点的值序列结果，与从尾到头遍历的值序列结果是一样的)
* */

import java.util.ArrayList;

class Node{

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
public class Solution1 {


    public static ArrayList<Boolean> test(Node head,int k){

      ArrayList<Boolean> result=new ArrayList<>();
      result.add(true);
      result.add(true);

        ArrayList<Node> list=new ArrayList<>();

        Node cur=head;
        while(cur!=null){
            list.add(cur);
            cur=cur.next;
        }
        int size=list.size();
         int i=0;
         int j=size-1;
         while (i<j){

             if(list.get(i).value!=list.get(j).value){
                result.set(0,false);
                break;
             }
             i++;
             j--;
         }
         if(i>=j){
             result.add(true);
         }

         /*删除倒数第k个节点*/
         list.remove(size-k);
         i=0;
         j=list.size()-1;
        while (i<j){

            if(list.get(i).value!=list.get(j).value){
                result.set(1,false);
                break;
            }
            i++;
            j--;
        }


        return  result;
    }
    public static void main(String[] args) {

        Node head=new Node(1);
        Node h1=new Node(8);
        Node h2=new Node(4);
        Node h3=new Node(4);
        Node h4=new Node(8);
        Node h5=new Node(1);
        head.next=h1;
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        int k=3;

     /*   Node head=new Node(1);
        Node h1=new Node(2);
        Node h2=new Node(5);
        Node h3=new Node(2);
        Node h4=new Node(1);

        head.next=h1;
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        int k=2;
*/
/*
        Node head=new Node(1);
        Node h1=new Node(2);
        Node h2=new Node(5);
        Node h3=new Node(3);
        Node h4=new Node(2);
        Node h5=new Node(1);
        head.next=h1;
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        int k=3;*/
        ArrayList<Boolean> result=test(head,k);
        System.out.println(result);
    }
}
