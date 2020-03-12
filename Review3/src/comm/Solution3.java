package comm;

import java.util.ArrayList;
import java.util.Stack;

/*
* 中序遍历
* */
public class Solution3 {
    public static ArrayList<Integer> inNode(Node root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null||!stack.isEmpty() ){
            while (cur!=null) {
                stack.add(cur);
                cur = cur.left;
            }
            Node node=stack.pop();
            list.add(node.value);
            cur=node.right;
        }

        return  list;
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

        ArrayList<Integer> result=inNode(root);
        System.out.println(result);
    }
}
