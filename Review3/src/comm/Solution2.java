package comm;


import java.util.ArrayList;
import java.util.Stack;

/*
 * 前序遍历
 *
 * */
public class Solution2 {


    public static ArrayList<Integer> preNode(Node root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { //先一直往左走
                list.add(cur.value);
                stack.add(cur);
                cur = cur.left;
            }
            Node node = stack.pop();//出栈一个
            cur = node.right;//该前序遍历右子树了
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

        ArrayList<Integer> result=preNode(root);
        System.out.println(result);

    }
}
