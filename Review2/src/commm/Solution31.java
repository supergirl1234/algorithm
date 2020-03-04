package commm;

/*
*
* 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
*
* */

public class Solution31 {

    boolean isSymmetrical(TreeNode pRoot)
    {

        if(pRoot==null){

            return  true;
        }


        /*判断左子树与右子树是否对称*/
        return  isBol(pRoot.left,pRoot.right);
    }

    /*判断两个子树是否对称*/
    boolean isBol(TreeNode lRoot,TreeNode rRoot){

        if(lRoot==null&&rRoot==null){
            return  true;

        }
        if(lRoot!=null&&rRoot!=null) {
            /*左子树与右子树的值对称*/
            if (lRoot.val == rRoot.val) {

                /*则再判断下面的*/
                return isBol(lRoot.left,rRoot.right)&&isBol(lRoot.right,rRoot.left);
            }
        }


        return  false;
    }
    public static void main(String[] args) {

    }
}
