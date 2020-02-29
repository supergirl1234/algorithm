package com;


/*
* 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
* */

import java.util.HashMap;

public class Solution10 {


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1==null||root2==null){

            return  false;
        }

        boolean result=false;
        if(root1.val==root2.val){

            /*则下面开始判断root1的左子树与root2的左子树是否相等，root1的右子树与root2的右子树是否相等*/
           result= HasSubtreeInter(root1.left,root2.left)&&HasSubtreeInter(root1.right,root2.right);

        }
          /*如果两棵树的根结点不相等，则判断root1的左子树包不包含root2，或者root1的右子树包不包含root2*/
        if(!result) {
            result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
            return  result;
    }

    public boolean HasSubtreeInter(TreeNode root1,TreeNode root2) {

        /*一定要先判断子树root2，因为在判断该函数时，已经比较了他们的父亲节点了；
        而在题干中说了空树不是任意一个树的子结构，在比较该函数时，此题干就无意义了*/
        if(root2==null){

            return  true;
        }
        if(root1==null){

            return  false;
        }

        if(root1.val==root2.val){
            return HasSubtreeInter(root1.left,root2.left)&&HasSubtreeInter(root1.right,root2.right);
        }
        return  false;

    }
    public static void main(String[] args) {

    }
}
