package Linked_Lists;

public class Operations {

    public static void main(String[] args) {
        LinkedLists_blueprint ll = new LinkedLists_blueprint();
        ll.addFirst(3);
        ll.addFirst(7);
        ll.addFirst(12);
        ll.addFirst(17);
        ll.addLast(24);
        ll.addLast(29);
        ll.add(2, 2);

        ll.display();
        System.out.println("\nRemove First");
        System.out.println(ll.deleteFirst());
        ll.display();


        System.out.println("\nRemove last");
        System.out.println(ll.deleteLast());
        ll.display();

        System.out.println("\nRemove from index");
        System.out.println(ll.delete(2));
        ll.display();


        System.out.println("\n\nDoubly Linked Lists\n");


        DoublyLL dll = new DoublyLL();

        dll.addFirst(3);
        dll.addFirst(12);
        dll.addFirst(7);
        dll.addFirst(21);
        dll.addFirst(45);
        dll.addLast(50);
        dll.addAtData(7, 99);
        dll.addAtData(3, 23);

        dll.display();
        dll.displayRev();


        System.out.println("\n\nCircular Linked Lists\n");

        CircularLL cll = new CircularLL();
        cll.display();
        cll.addFirst(23);
        cll.addFirst(2);
        cll.addLast(34);
        cll.addLast(24);
        cll.addLast(32);
        cll.delete(34);
        cll.display();

    }
}
