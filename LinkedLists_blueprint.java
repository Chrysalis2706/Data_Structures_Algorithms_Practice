package Linked_Lists;

public class LinkedLists_blueprint {

    public Node head;
    public Node tail;
    public int size;

    public class Node {

        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }


    }


    // ____________________INSERTION__________________________

    public void addFirst(int data){
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
            size = 1;
            return;
        }
        node.next = head;
        head = node;
        size += 1;
    }

    public void addLast(int data){
        Node node = new Node(data);

        if (head == null){
            head = node;
            tail = node;
            size = 1;
            return;
        }
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void add(int data, int index){
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size){
            addLast(data);
            return;
        }

        Node temp = head;
        int i = 0;
        while (i < index-1){
            temp = temp.next;
            i++;
        }

        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size += 1;
    }


    public Node get(int index){
        Node temp = head;
        int i =0;
        while (i<index){
            temp = temp.next;
            i++;
        }
        return temp;
    }

    // ____________________DELETION__________________________

    public int deleteFirst(){

        int data = head.data;

        if (head == null){
            System.out.println("Linked list is empty");
            return -1;
        }

        if (head.next == null){
            head = null;
            tail = null;
            return data;
        }

        head = head.next;
        size--;
        return data;
    }


    public int deleteLast(){
        if (head == null){
            return deleteFirst();
        }

        Node prev = get(size-2);
        size--;
        int data = tail.data;
        tail = prev;
        tail.next = null;
        return data;
    }


    public int delete(int index){
        if (size == 0) {
            return deleteFirst();
        }

        if (index == size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int data = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return data;
    }


    public void display(){
        Node temp = head;
        if (head == null){
            System.out.println("Linked list is empty");
            return;
        }

        while (temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("size is : " + size);

    }

}
