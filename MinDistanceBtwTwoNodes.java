package Binary_Tree;

import java.util.ArrayList;

public class MinDistanceBtwTwoNodes {
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

    public static boolean getPath(Node root, Node p, ArrayList path){
        if (root == null) return false;

        path.add(root);
        if (root.data == p.data) return true;

        boolean left = getPath(root.left, p, path);
        boolean right = getPath(root.right, p, path);

        // found
        if (left || right) return true;

        // if not found
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, Node p, Node q){
        if (root == null) return null;

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        int i = 0;
        while (i<path1.size() && i< path2.size()){
            if (path1.get(i) != path2.get(i)) break;
            i++;
        }

        Node lca = path1.get(i-1);
        return lca;
    }

    public static int getDist(Node root, Node p){
        if (root == null) return -1;
        if (root.data == p.data) return 0;

        int left = getDist(root.left, p);
        int right = getDist(root.right, p);

        if (left == -1 && right == -1) {
            return -1;
        }else if (left == -1){
            return right+1;
        }else {
            return left+1;
        }
    }

    public static int minDist(Node root, Node p, Node q){
        if (root == null) return -1;

        Node lca = lca(root, p, q);
        int d1 = getDist(lca, p);
        int d2 = getDist(lca, q);

        return d1 + d2;
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
        root.right.left = new  Node(7);
        root.right.right = new Node(6);

        int ans =  minDist(root, root.left.left, root.right.right);
        System.out.println(ans);
    }
}
