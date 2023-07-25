package Binary_Tree;

import java.net.http.HttpClient;

public class KthAncestorOfNode {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int KthAncestor(Node root, Node node, int k){
        if (root == null) return -1;

        if (root.data == node.data) return 0;

        int left = KthAncestor(root.left, node, k);
        int right = KthAncestor(root.right, node, k);

        if (left == -1 && right == -1) return -1;

        int max = Math.max(left, right);

        if(max+1 == k){
            System.out.println(root.data);
        }

        return max+1;
    }

    public static void main(String[] args) {
         /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);

        KthAncestor(root, root.right.left, 1);
    }
}
