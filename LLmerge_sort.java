public class LLmerge_sort {

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

    public static void add_first(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        return;
    }

    public static Node find_node(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1 != null && head2!=null){
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

    public static Node merge_sort(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node mid = find_node(head);

        Node righthead = mid.next;
        mid.next = null;

        Node left_half = merge_sort(head);
        Node right_half = merge_sort(righthead);


        return merge(left_half, right_half);
    }

    public static void mergeSort(){
        head = merge_sort(head);
    }

    public static void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        LLmerge_sort l1 = new LLmerge_sort();
        l1.add_first(2);
        l1.add_first(5);
        l1.add_first(6);
        l1.add_first(8);
        l1.print();
        l1.mergeSort();
        System.out.println();
        l1.print();
    }
}
