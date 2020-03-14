package commm;

/*
* 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*
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

public class Solution3 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        if(pRoot==null){
            return  lists;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){

            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            while (size>0){

                TreeNode node=queue.poll();
                if(node!=null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                size--;
            }
            if(list.size()>0){
                lists.add(list);
            }
        }
        return  lists;
    }

    public static void main(String[] args) {

    }

}