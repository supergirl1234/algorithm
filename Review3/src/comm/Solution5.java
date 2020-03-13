package comm;
/*
* 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
*
* */

/*
* 思路：二叉搜索树的中序遍历是有序且按从小到达的顺序排列的
* */

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution5 {

    private static TreeNode  KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<=0){
            return  null;
        }


        ArrayList<TreeNode> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=pRoot;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();
            list.add(node);
            if(list.size()==k){
                return  node;
            }
            cur=node.right;
        }

        return null;

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode h1 = new TreeNode(3);
        TreeNode h2 = new TreeNode(7);
        TreeNode h3 = new TreeNode(2);
        TreeNode h4 = new TreeNode(4);
        TreeNode h5 = new TreeNode(6);
        TreeNode h6 = new TreeNode(8);
        root.left = h1;
        root.right = h2;
        h1.left = h3;
        h1.right = h4;
        h2.left = h5;
        h2.right = h6;
        TreeNode result= KthNode(root,3);
        if(result!=null) {
            System.out.println(result.val);
        }else {
            System.out.println("null");
        }
    }
}
