package comm;


/*
* 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
* 返回结果为复制后复杂链表的head。
* （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*
* */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Solution12 {


    public RandomListNode Clone(RandomListNode pHead)
    {

        if(pHead==null){

            return  null;
        }
        RandomListNode cur=pHead;


        while(cur!=null){
            RandomListNode nextNode=cur.next;

            RandomListNode node=new RandomListNode(cur.label);//新创建的与当前节点值相同的节点

            node.next=nextNode;
            cur.next=node;

            cur=nextNode;
        }

        /*构建复制出来的节点的random*/
        cur=pHead;
        while (cur!=null){
           RandomListNode NextNode= cur.next.next;
           if(cur.random!=null) {
               cur.next.random = cur.random.next;
           }else{
               cur.next.random =null;
           }
           cur=NextNode;
        }

        /*拆分链表*/
        cur=pHead;
        RandomListNode result=cur.next;
        while(cur!=null){
            RandomListNode node=cur.next;
            cur.next=node.next;
            if(cur.next!=null) {
                node.next = cur.next.next;
            }

            cur=cur.next;

        }


        return  result;
    }
    public static void main(String[] args) {

    }
}
