package Binary_Tree;

public class TransforToSumTree {

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

    public static int transform(Node root){
        if (root == null) return 0;

        int leftchild = transform(root.left);
        int rightchild = transform(root.right);

        int data = root.data;
        int newleft = ((root.left == null) ? 0 : root.left.data);
        int newright = ((root.right == null) ? 0 : root.right.data);

        root.data = newleft + leftchild + newright + rightchild;
        return data;
    }

    public static void preOrder(Node root){
        if(root==null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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

        preOrder(root);
        transform(root);
        System.out.println();
        preOrder(root);
    }
}
