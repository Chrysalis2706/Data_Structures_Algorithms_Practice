package BinarySearchTrees;

public class BST_OperationsPartTwo {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node createBST(int[] arr, int start, int end){
        // base case
        if (start > end) return null;

        int mid = (start + end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    public static void preOrder(Node root){
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int maxBST = 0;
    public static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static Info sizeBST(Node root){
        if (root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = sizeBST(root.left);
        Info right = sizeBST(root.right);
        int size = left.size + right.size + 1;
        int max = Math.max(root.data, Math.max(left.max, right.max));
        int min = Math.min(root.data, Math.min(left.min, right.min));

        // check is root is valid
        if (root.data <= left.max || root.data >= right.min){
            return new Info(false, size, min, max);
        }

        if (left.isBST && right.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
//        int[] nodes = {3, 5, 6, 8, 10, 11, 12};
//        Node root = createBST(nodes, 0, nodes.length-1);
//        preOrder(root);

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info ans = sizeBST(root);
        System.out.println(ans.size);


    }
}
