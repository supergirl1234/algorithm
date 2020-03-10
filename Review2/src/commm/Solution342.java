package commm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 请实现一个函数按照层数打印二叉树
 * */
public class Solution342 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null){
            return  result;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int size=queue.size();
            while (size>0){
                TreeNode node=queue.poll();
                if(node!=null){
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                size--;

            }
            if(list.size()>0){//防止将最后一层（最后一层全是空的null）也添加进去

                result.add(list);
            }

        }
        return  result;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode p1=new TreeNode(5);
        TreeNode p2=new TreeNode(7);
        TreeNode p3=new TreeNode(8);
        TreeNode p4=new TreeNode(9);
        TreeNode p5=new TreeNode(2);
        TreeNode p6=new TreeNode(11);

        root.left=p1;
        root.right=p2;
        p1.left=p3;

        p2.left=p4;
        p2.right=p5;
        p3.left=p6;

        ArrayList<ArrayList<Integer>> result=Print(root);
        System.out.println(result);
    }
}
