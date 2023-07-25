package Stacks;

public class Stack_Using_LinkedLists {


    public static Node head;
    public static int size = 0;

    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    //isEmpty
    public static boolean isEmpty(){
        return head == null;
    }

    //push -> add first
    public static void push(int data){
        Node node = new Node(data);
        if (isEmpty()){
          head = node;
          head.next = null;
          size += 1;
          return;
        }
            node.next = head;
            head = node;
            size += 1;


    }

    //pop -> delete first
    public static int pop(){
        if (isEmpty() || head == null){
//            System.out.println("Empty Stack");
            return -1;
        }

        if (head.next == null){
            head = null;
            size -= 1;
            return head.data;
        }

        int ret = head.data;
        head = head.next;
        size -= 1;
        return ret;
    }

    //peek -> get value of data in head
    public static int peek(){
        if (isEmpty()) return -1;
        return head.data;
    }



}
