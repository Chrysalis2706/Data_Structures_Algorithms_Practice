package Binary_Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewBinaryTree {
    public static void main(String[] args) {


         /*

                 1
               /   \
              2     3
             / \   / \
            4   5 7   6


         */


        TopViewBInaryTree.Node root = new TopViewBInaryTree.Node(1);
        root.left = new TopViewBInaryTree.Node(2);
        root.right = new TopViewBInaryTree.Node(3);
        root.left.left = new TopViewBInaryTree.Node(4);
        root.left.right = new TopViewBInaryTree.Node(5);
        root.right.left = new TopViewBInaryTree.Node(7);
        root.right.right = new TopViewBInaryTree.Node(6);

        bottomView(root);
    }

    static class Node{
        int data;
        TopViewBInaryTree.Node left;
        TopViewBInaryTree.Node right;
        Node(int data, TopViewBInaryTree.Node left, TopViewBInaryTree.Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }
    }

    static class Info{
        int hd;
        TopViewBInaryTree.Node node;

        Info(TopViewBInaryTree.Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void bottomView(TopViewBInaryTree.Node root){
        // level order traversal
        int min = 0, max = 0;
        Queue<TopViewBInaryTree.Info> que = new LinkedList<>();
        HashMap<Integer, TopViewBInaryTree.Node> map = new HashMap<>();
        que.add(new TopViewBInaryTree.Info(root, 0));
        que.add(null);
        while (!que.isEmpty()){
            TopViewBInaryTree.Info curr = que.remove();
            //check if node is null
            if (curr == null){
                if (que.isEmpty()) break;
                else que.add(null);
            }else {

                // difference in top view
//                if(!map.containsKey(curr.hd)){
//                    map.put(curr.hd, curr.node);
//                }

                map.put(curr.hd, curr.node);

                if (curr.node.left != null) {
                    que.add(new TopViewBInaryTree.Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if (curr.node.right != null) {
                    que.add(new TopViewBInaryTree.Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

//        traversing the map
        for (int i = min; i<= max; i++){
            System.out.print(map.get(i).data  + " -> ");
        }
        System.out.println("null");
    }
}
