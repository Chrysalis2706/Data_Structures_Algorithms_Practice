package Binary_Tree;

import java.util.*;

public class TreeBasics {

    //Creating nodes of the tree
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

    //Creating a blueprint of a Tress
    static class BinaryTree{
        static int index = -1;
        public static Node tree_builder(int[] nodes){
            index += 1;
            if (nodes[index] == -1) return null;

            Node node = new Node(nodes[index]);
            node.left = tree_builder(nodes);
            node.right = tree_builder(nodes);

            return node;
        }

        public static void preOrder(Node root){
            //Base case
            if (root == null){
                System.out.print(-1  + " ");
                return;
            }

            //print root -> left -> right
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            //Base case
            if (root == null){
                return;
            }
            //print left -> root -> right
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            //Base case
            if (root == null){
                return;
            }
            //print left -> right -> root
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root){
            if (root == null) return;

            Queue<Node> que = new LinkedList<>();
            que.add(root);
            que.add(null);
            while (!que.isEmpty()){
                Node curr = que.remove();
                // check if node is null
                if (curr == null){
                    System.out.println();
                    if (que.isEmpty()) break;
                    else que.add(null);
                }else{
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        que.add(curr.left);
                    }
                    if (curr.right != null){
                        que.add(curr.right);
                    }
                }
            }
        }

        public static int treeHeight(Node root){
            if (root == null) return 0;

            int lh = treeHeight(root.left);
            int rh = treeHeight(root.right);

            return Math.max(lh, rh) + 1;
        }

        public static int nodesCount(Node root){
            if (root == null) return 0;

            int left = nodesCount(root.left);
            int right = nodesCount(root.right);

            return  left + right + 1;
        }

        public static int sumNodes(Node root){
            if (root == null) return 0;

            int leftsum = sumNodes(root.left);
            int rightsum = sumNodes(root.right);

            return leftsum + rightsum + root.data;
        }

        // Diameter of Tree : Approach 1
        public static int diameter1(Node root){
            if (root == null) return 0;

            //left diameter and heigth
            int leftd = diameter1(root.left);
            int lefth = treeHeight(root.left);

            //right diameter and heigth
            int rightd = diameter1(root.right);
            int righth = treeHeight(root.right);

            // calculation of self diameter
            int self = lefth + righth + 1;

            return  Math.max(self, Math.max(leftd, rightd));
        }

        public static class Info {
            int diam;
            int ht;
            Info(int d, int h){
                this.diam = d;
                this.ht = h;
            }
        }

        public static Info diameter2(Node root) {
            if (root == null) return  new Info(0,0);

            Info leftinfo = diameter2(root.left);
            Info rightinfo = diameter2(root.right);

            int diam = Math.max(leftinfo.ht + rightinfo.ht + 1, Math.max(leftinfo.diam, rightinfo.diam));
            int ht = Math.max(leftinfo.ht, rightinfo.ht) + 1;

            return new Info(diam, ht);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //Creating binary tree object
        BinaryTree btree = new BinaryTree();

        // checking the data of the root node
        Node root = btree.tree_builder(nodes);
        System.out.println(root.data);

        //Traversals
        System.out.println("DFS Traversals : ");
        System.out.println("PreOrder : ");
        btree.preOrder(root);
        System.out.println("\nInOrder");
        btree.inOrder(root);
        System.out.println("\nPostOrder");
        btree.postOrder(root);

        System.out.println("\nBFS Traversals : ");
        System.out.println("LevelOrder");
        btree.levelOrder(root);

        System.out.println("\nHeight of tree : " + btree.treeHeight(root));
        System.out.println("Count of Nodes : " + btree.nodesCount(root));
        System.out.println("Sum of Nodes : " + btree.sumNodes(root));
        System.out.println("Approach 1 Diameter of Nodes : " + btree.diameter1(root));
        System.out.println("Approach 2 Diameter of Nodes : " + btree.diameter2(root).diam);

    }

}
