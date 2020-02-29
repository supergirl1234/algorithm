package com;



import java.util.Arrays;

/*
* 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution4 {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if(pre.length==0||in.length==0){

            return null;
        }

        TreeNode result=new TreeNode(pre[0]);
        int num=0;
        int count=0;
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){

                num=i;
                break;
            }else{
                count++;
            }

        }
        result.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,1+count),Arrays.copyOfRange(in,0,num));
        result.right=reConstructBinaryTree(Arrays.copyOfRange(pre,1+count,pre.length),Arrays.copyOfRange(in,num+1,in.length));

        return  result;
    }

    public static void main(String[] args) {


        int[] pre=new int[]{1,2,4,7,3,5,6,8};
        int[] in=new int[]{4,7,2,1,5,3,8,6};
        TreeNode result= reConstructBinaryTree(pre,in);


        System.out.println(result);
    }
}
