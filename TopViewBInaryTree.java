package Binary_Tree;

import java.util.*;


public class TopViewBInaryTree {


    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
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
        Node node;

        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        // level order traversal
        int min = 0, max = 0;
        Queue<Info> que = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        que.add(new Info(root, 0));
        que.add(null);
        while (!que.isEmpty()){
            Info curr = que.remove();
            //check if node is null
            if (curr == null){
                if (que.isEmpty()) break;
                else que.add(null);
            }else {
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    que.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if (curr.node.right != null) {
                    que.add(new Info(curr.node.right, curr.hd+1));
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

        topView(root);

        
    }
}
