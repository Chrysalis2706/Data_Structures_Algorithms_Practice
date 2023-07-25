package Heaps;

import java.util.PriorityQueue;

public class SlidingWindowMax {

    static class Pair implements Comparable<Pair>{
        int val;
        int indx;

        public Pair (int val, int indx){
            this.val = val;
            this.indx = indx;
        }

        @Override
        public int compareTo(Pair p2){
            // descending
            return  p2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int k = 3; // window size
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int n = arr.length;
        int[] res = new int[n-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //add k elements to pq
        for (int i=0; i<k; i++){
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        //move window
        for (int i=k; i<n; i++){
            //remove if
            while (pq.size() > 0 && pq.peek().indx <= i-k){
                pq.remove();
            }
            // add values
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }


        // print arr res
        for (int i =0; i< res.length; i++){
            System.out.print(res[i] + " ");
        }

    }

}
