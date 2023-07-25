package Queue;

import java.util.*;

public class Interleave_twoHalves_ofQueue {



    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave(q);



        while (!q.isEmpty()){
            System.out.print(q.peek() + " " );
            q.remove();
        }
    }

    private static void interleave(Queue<Integer> q) {
        Queue<Integer> q2 = new LinkedList<>();
        int n =  q.size();
        int i = 1;

        // add halve elements from front to new queue
        while (i <= n/2){
            q2.add(q.remove());
            i++;
        }

        // add to old que side by side
        int front = q2.peek();
        while (front != q.peek()){
            q.add(q2.remove());
            q.add(q.remove());
        }

    }
}
