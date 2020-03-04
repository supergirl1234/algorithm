package commm;


/*
*
* 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
* */
public class Solution35 {

    public int TreeDepth(TreeNode root) {

        if(root==null){

            return  0;
        }
        if(root.left==null&&root.right==null){

            return 1;
        }

        int leftHigh=TreeDepth(root.left);
        int rightHigh=TreeDepth(root.right);
        return leftHigh>rightHigh?1+leftHigh:1+rightHigh;
    }

    public static void main(String[] args) {

    }
}
