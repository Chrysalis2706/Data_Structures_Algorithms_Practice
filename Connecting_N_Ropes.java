package Heaps;

import java.util.PriorityQueue;

public class Connecting_N_Ropes {
    public static void main(String[] args) {
        int[] ropes = {2, 3, 3, 4, 6};
        int cost = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i< ropes.length; i++){
            pq.add(ropes[i]);
        }

        while (pq.size() > 1){
            int min1= pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;

            pq.add(min1 + min2);
        }

        System.out.println(cost);
    }
}
