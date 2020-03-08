package com;

/*
 *输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution8 {

    public  static boolean IsBalanced_Solution(TreeNode root) {

        if(root==null){

            return  true;
        }
        if(Math.abs(height(root.left)-height(root.right))>1){

            return  false;
        }
        return  IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }

    /*求树的高度*/

    public static  int  height(TreeNode root){

        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return leftHeight>rightHeight?1+leftHeight:1+rightHeight;
    }
    public static void main(String[] args) {

    }
}
