package comm;


/*
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
*
*
* 思路：用队列
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution17 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){

            return  list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null) {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }

        }

        return  list;
    }
    public static void main(String[] args) {

    }
}
