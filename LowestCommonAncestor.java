package Binary_Tree;

import java.util.*;

public class LowestCommonAncestor {

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
        if(root.data == p.data){
            return true;
        }

        boolean left = getPath(root.left, p, path);
        boolean right = getPath(root.right, p, path);

        if (left || right){
            return true;
        }


        // agar nhi mila toh remove krdo aur false return krdo
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, Node p, Node q){
        if (root == null) return null;

        // 1. Get the path
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, p, path1);
        getPath(root, q, path2);

        int i;
        for (i=0; i < path1.size() &&  i < path2.size(); i++){
            if (path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca;
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

        Node ans = lca(root, root.left.left, root.left.right);
        System.out.println(ans.data);
    }
}
