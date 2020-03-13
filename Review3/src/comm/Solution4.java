package comm;


import java.util.ArrayList;
import java.util.Stack;

//后续遍历
public class Solution4 {


    public static ArrayList<Integer> postNode(Node root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;//记录最后一个出栈的节点
        while (cur != null || !stack.isEmpty()) {
            /*先走左边*/
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            /*依次回溯*/
            Node node = stack.peek();

            if (node.right == null) {//如果该节点没有右子树，则直接将该节点出栈输出
                Node leave = stack.pop();
                last = leave;
                list.add(leave.value);
            } else if (node.right == last) {//如果该节点的右节点是上一次出栈的节点，则代表该节点的右子树已经遍历完了，所以可以出栈输出该节点了
                Node leave = stack.pop();
                last = leave;
                list.add(leave.value);
            } else { //如果该节点有右子树，则直接优先遍历该节点的右子树
                cur = node.right;
            }


        }
        return list;

    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node h1 = new Node(3);
        Node h2 = new Node(5);
        Node h3 = new Node(10);
        Node h4 = new Node(7);
        Node h5 = new Node(14);
        Node h6 = new Node(7);
        root.left = h1;
        root.right = h2;
        h1.left = h3;
        h1.right = h4;
        h2.left = h5;
        h2.right = h6;

        ArrayList<Integer> result=postNode(root);

        System.out.println(result);
    }
}
