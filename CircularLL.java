package Linked_Lists;

public class CircularLL {

    public Node head;
    public Node tail;
    public int size;

    public class Node {
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
        }
    }

    // INSERTION

    public void addFirst(int data){
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            size += 1;
            return;
        }

        tail.next = node;
        node.next = head;
        head = node;
        size += 1;
    }

    public void addLast(int data){
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            size += 1;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
        size += 1;
    }


    // DELETE USING VALUE
    public void delete(int data){
        Node node = head;
        if (node == null){
            return;
        }

        if (node.data == data){
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if (n.data == data){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while (node != head);
    }


    // DISPLAY

    public void display(){
        Node node = head;
        if (head == null){
            System.out.println("LL is empty");
            return;
        }
        do {
            System.out.print(node.data + " --> ");
            node = node.next;
        }while(node != head);
        System.out.println(head.data + "(head)");
    }

}
