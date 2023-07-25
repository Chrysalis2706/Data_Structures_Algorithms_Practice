public class LinkedLists_MergeSort {

    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    public static void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
        return;
    }

    public static void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node mid_node(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        return mid;
    }

    public static Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1!= null && head2!= null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public static void mergeSort(){
        head= merge_sort(head);
    }
    public static Node merge_sort(Node head){
        // edge cases
        if (head == null || head.next == null){
            return head;
        }

        // find last node of the first half
        Node midNode = mid_node(head);

        // divide into two halves
        Node right_head = midNode.next;
        midNode.next = null;
        Node first_half = merge_sort(head);
        Node last_half = merge_sort(right_head);

        // merge both halves
        return merge(first_half, last_half);
    }

    public static void main(String[] args) {
        LinkedLists_MergeSort l1 = new LinkedLists_MergeSort();
        l1.addFirst(8);
        l1.addFirst(5);
        l1.addFirst(10);
        l1.addFirst(12);
        l1.print();
        l1.mergeSort();
        System.out.println();
        l1.print();
    }
}
