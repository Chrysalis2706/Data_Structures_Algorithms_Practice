package Linked_Lists;

public class DoublyLL {

    public Node head;
    public Node tail;
    public int size;

    public class Node {
        public int data;
        public Node next;
        public Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // INSERTION

    public void addFirst(int data){
        Node node = new Node(data);

        if (head == null){
            node.next = head;
            head = node;
            tail = node;
            size += 1;
            return;
        }

        node.next = head;
        node.prev = null;
        if (head!=null){
            head.prev = node;
        }
        head = node;
        size += 1;
    }


    public void addLast(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            node.prev = null;
            tail = node;
            size += 1;
            node.next = null;
            return;
        }

        Node last = head;
        while (last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next = null;
        tail = node;
    }

    public Node getNode(int data){
        Node node = head;
        while (node != null){
            if (node.data == data){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void addAtData(int node, int data){
        Node p = getNode(node);
        if (p == null){
            System.out.println("Node not present!");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;
        newNode.prev = p;
        if (newNode.next != null) p.next.prev = newNode;
        size += 1;
    }


    // DISPLAY
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("end");
    }

    public void displayRev(){
        Node last = tail;
        while (last != null){
            System.out.print(last.data + " <--> ");
            last = last.prev;
        }
        System.out.println("start");
    }
}
