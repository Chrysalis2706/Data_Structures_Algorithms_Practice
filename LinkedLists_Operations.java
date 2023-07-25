public class LinkedLists_Operations {

    public static Node head;
    public static Node tail;
    public static int size;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void add_first(int data) {
        Node new_node = new Node(data);
        size++;

        if (head == null){
            head = new_node;
            tail = new_node;
            return;
        }

        new_node.next = head;
        head = new_node;
    }

    public static void add_last(int data) {
       Node new_node = new Node(data);
       size++;

       if (head == null){
           head = new_node;
           tail = new_node;
           return;
       }
       tail.next = new_node;
       tail = new_node;
    }

    public static void print() {
        Node temp = head;

        if (head==null){
            System.out.print("Empty list");
            return;
        }

        while (temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void add_middle(int index, int data){

        if (head==null){
            add_first(data);
            return;
        }

        Node new_node = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < index-1){
            temp = temp.next;
            i++;
        }

        new_node.next = temp.next;
        temp.next = new_node;
    }

    public static void remove_first(){
        if (size == 0) {
            System.out.println("Empty List");
            return;
        }

        if (size==1){
            head = null;
            tail = null;
            size = 0;
            return;
        }

        head = head.next;
        size--;
    }

    public static int remove_last(){
        if (size == 0) {
            System.out.println("Empty list");
            return Integer.MIN_VALUE;
        }

        if (size == 1){
            size = 0;
            head = null;
            tail = null;
            int val = head.data;
            return val;
        }

        Node prev = head;
        for (int i=0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static void remove_index(int index){
        if (size==0) {
            System.out.println("Empty list");
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node temp = head;
        Node ptr = temp.next;
        int i = 0;


        while (i < index-1){
            temp = ptr;
            ptr = ptr.next;
            i++;
        }

        temp.next = ptr.next;
        size--;

    }

    public static int itr_search(int key){
        Node temp = head;
        int i = 0;

        while (temp != null){
            if (temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
        }

        return -1;
    }

    public static int helper(int key, Node head){
        if (head == null) return -1;

        if (head.data == key) return 0;

        int index = helper(key, head.next);
        if (index == -1) return -1;

        return index+1;
    }

    public static int rec_search(int key){
        return helper(key, head);
    }

    public static void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void remove_from_last(int n){

        // calculating size

        int size = 0;
        Node temp = head;
        while (temp!=null){
            temp = temp.next;
            size++;
        }

        // if the last node to first is head
        if (n==size){
            head = head.next;
            return;
        }

        int index = size-n;
        int i=0;
        Node prev = head;
        while (i<index){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }

    // LL is Palindrome

    public static Node find_mid(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        return mid;
    }

    public static boolean palindrome(){
        // base case
        if (head == null || head.next == null) return true;

        // find the mid
        Node mid = find_mid(head);

        // Reverse the second half
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        while (right != null){
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }


    public static void zig_zag(){
        if (head == null || head.next == null){
            return;
        }
        // 1. find mid node
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node midNode = slow;

        // 2. reverse second half
        Node curr = midNode.next;
        midNode.next = null;
        Node prev = null;
        Node next;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left_head = head;
        Node right_head = prev;

        // 3. alternate merging
        Node nextL;
        Node nextR;

        while (left_head != null && right_head != null){
            nextL = left_head.next; // store in nextL
            left_head.next = right_head;
            nextR = right_head.next; // store in nextR
            right_head.next = nextL;
            // update
            left_head = nextL;
            right_head = nextR;
        }
    }



    public static void main(String[] args) {

        LinkedLists_Operations l1 = new LinkedLists_Operations();

        l1.add_first(2);
        l1.add_first(10);
        l1.add_first(1);
        l1.add_middle(1, 4);
        l1.add_middle(2, 6);
        l1.add_last(11);
        l1.add_last(3);
        l1.add_last(5);


        l1.print();
        System.out.println(l1.size);

        l1.remove_first();
        l1.remove_last();
        l1.print();
        l1.remove_index(2);
        l1.print();
        int ind = l1.itr_search(10);
        System.out.println(ind);
        int rec_ind = l1.rec_search(2);
        System.out.println(rec_ind);


        l1.add_first(3);
        l1.add_first(2);
        l1.add_first(1);
        l1.add_last(5);
        l1.remove_last();
        l1.remove_last();
        l1.remove_last();
        l1.remove_last();
        l1.remove_last();
        l1.add_last(5);
        l1.add_last(6);
        l1.print();

//        REVERSE LL
//        l1.reverse();
//        l1.print();

//        l1.remove_from_last(3);
//        System.out.println(l1.palindrome());
        l1.zig_zag();
        l1.print();








    }

}