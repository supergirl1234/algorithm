package commm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/*
* 请实现一个函数按照之字形打印二叉树，
* 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
* 其他行以此类推。
*
* */
public class Solution34 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        if(pRoot==null){
            return  lists;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(pRoot);
        int num=1;//记录层数
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size=queue.size();//每一层的个数
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                if(num%2==0) {
                    list.add(0,node.val);//利用了list的逆序插入
                }else{
                    list.add(node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if(list.size()>0){//防止将最后一层（最后一层全是空的）也添加进去

                lists.add(list);
            }

            num++;

        }
        return  lists;
    }

    public static void main(String[] args) {

    }
}
