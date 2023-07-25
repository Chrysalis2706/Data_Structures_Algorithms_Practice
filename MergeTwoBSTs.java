package BinarySearchTrees;

import java.util.ArrayList;

public class MergeTwoBSTs {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void getInOrder(Node root, ArrayList<Integer> p){
        if (root == null) return;

        getInOrder(root.left, p);
        p.add(root.data);
        getInOrder(root.right, p);
    }

    public static Node createBST(ArrayList<Integer> p, int start, int end){
        if (start > end) return null;

        int mid = (start+end)/2;
        Node root = new Node(p.get(mid));
        root.left = createBST(p, 0, mid-1);
        root.right = createBST(p, mid+1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();
        ArrayList<Integer> fnl = new ArrayList<>();

        getInOrder(root1, p1);
        getInOrder(root2, p2);

        int i = 0;
        int j = 0;

        while (i < p1.size() && j < p2.size()){
            if (p1.get(i) < p2.get(j)){
                fnl.add(p1.get(i));
                i++;
            }else {
                fnl.add(p2.get(j));
                j++;
            }
        }


        while (i < p1.size()){
            fnl.add(p1.get(i));
            i++;
        }

        while(j < p2.size()){
            fnl.add(p2.get(j));
            j++;
        }



        Node merged = createBST(fnl, 0, fnl.size()-1);
        return merged;
    }

    public static void inOrder(Node root){
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);

        Node root2 = new Node(12);
        root2.left = new Node(10);
        root2.right = new Node(14);
        root2.right.right = new Node(16);

        Node root = mergeBST(root1, root2);
        inOrder(root);
    }
}
