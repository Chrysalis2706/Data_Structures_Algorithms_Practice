package BinarySearchTrees;
import java.util.*;

public class BST_OperationsPartOne {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        // go to left
        if (root.data > data){
            root.left =  insert(root.left, data);
        }
        // go to right
        if (root.data < data){
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if (root == null) return;

        if (root.data <= k2 && root.data >= k1){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        if (root.data < k1){
            // go to left
            printInRange(root.left, k1, k2);
        }

        if (root.data > k2){
            // go to right
            printInRange(root.right, k1, k2);
        }
    }

    public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    public static void printPath(Node root, ArrayList path){
        for (int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void NodeToLeaf(Node root, ArrayList path){
        if (root == null) return;

        path.add(root.data);

        // print when leaf occurs
        if (root.left == null && root.right == null){
            printPath(root,path);
        }

        NodeToLeaf(root.left, path);
        NodeToLeaf(root.right, path);
        // backtrack
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int vals[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for (int i=0; i<vals.length; i++){
            root = insert(root, vals[i]);
        }

        // Check Binary Search On Leetcode
        // Check Delete A Node On Leetcode
        // Check Insert Node On Leetcode

        inOrder(root);
        System.out.println();
        printInRange(root, 5, 11);
        System.out.println("\nAll Paths : ");
        ArrayList<Integer> path = new ArrayList<>();
        NodeToLeaf(root,path);
    }
}
