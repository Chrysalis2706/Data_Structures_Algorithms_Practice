package Binary_Tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RightVIew {

    //Creating nodes of the tree
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static void rightView(Node root){
        if (root == null) return;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();

        que.add(root);

        while (!que.isEmpty()){
            int size = que.size();
            for (int i=0; i<size; i++){
                Node curr = que.remove();

                if (i == 0) ans.add(curr.data);


                if (curr.right != null) que.add(curr.right); // inverse these to print left view
                if (curr.left != null) que.add(curr.left);
            }
        }

        System.out.println(ans.toString());
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // 1 -> 3 -> 7

        rightView(root);


    }
}
