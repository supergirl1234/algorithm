package comm;

import java.util.ArrayList;

/*
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
* */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;//父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution1 {
/*中序遍历下，某个节点的下一个节点是：如果该节点有右子树，则下一个节点为右子树中序遍历中的第一个节点，即右子树中最左的那个节点；
*                                     如果该节点无右子树，且结点是该结点父结点的左子树，则下一个节点为父节点
*                                     如果该节点无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，
*                                     直到找到某个结点是其父结点的左子树，如果存在这样的结点，
*                                     那么这个结点的父结点就是我们要找的下一结点*/
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {

        if(pNode.right==null){// 如果该节点无右子树

            if(pNode.next!=null&&pNode.next.left==pNode){//且该结点是该结点父结点的左子树

                return  pNode.next;//则下一个节点为其父节点
            }
            if(pNode.next!=null&&pNode.next.right==pNode) {//且该结点是该结点父结点的右子树

                    TreeLinkNode node=pNode.next;
                    while (node.next!=null&&node.next.right==node){//则一直往父节点找，其该父节点是其父节点的右子树

                        node=node.next;
                    }
                    return  node.next;
            }


        }else {//如果该节点有右子树

            TreeLinkNode node=pNode.right;
            while (node.left!=null){
                node=node.left;
            }
            return  node;

        }

        return  null;

    }
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(2);
        TreeLinkNode h1 = new TreeLinkNode(3);
        TreeLinkNode h2 = new TreeLinkNode(5);
        TreeLinkNode h3 = new TreeLinkNode(10);
        TreeLinkNode h4 = new TreeLinkNode(7);
        TreeLinkNode h5 = new TreeLinkNode(14);
        TreeLinkNode h6 = new TreeLinkNode(8);
        root.left = h1;
        root.right = h2;
        h1.next=root;
        h2.next=root;
        h1.left = h3;
        h1.right = h4;
        h3.next=h1;
        h4.next=h1;
        h2.left = h5;
        h2.right = h6;
        h5.next=h2;
        h6.next=h2;

        //TreeLinkNode result=GetNext(root);
        //TreeLinkNode result=GetNext(h1);
        TreeLinkNode result=GetNext(h4);
        System.out.println(result.val);
    }
}
