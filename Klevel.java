package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Klevel {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int index = -1;

        public static Node treeBuilder(int[] nodes){
            index += 1;
            if (nodes[index] == -1) return null;

            Node node = new Node(nodes[index]);
            node.left = treeBuilder(nodes);
            node.right = treeBuilder(nodes);

            return node;
        }

    }

    public static void levelOrder(Node root){
        if (root == null) return;

        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        while (!que.isEmpty()){
            Node curr = que.remove();
            if (curr == null) {
                if (que.isEmpty()) break;
                else que.add(null);
            }else{
                System.out.print(curr.data+ " -> ");
                if (curr.left != null) que.add(curr.left);
                if (curr.right != null) que.add(curr.right);
            }
        }
        System.out.println("END");
    }

    public static void klevel(Node root, int level, int k){
        if (root == null) return;

        if (level == k){
            System.out.print(root.data + " ");
            return; //no need to go to next child
        }

        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);
    }

    public static void main(String[] args) {

        /*
               1
             2   3
           4  5  6 7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        levelOrder(root);
        klevel(root, 1, 3);
    }
}
