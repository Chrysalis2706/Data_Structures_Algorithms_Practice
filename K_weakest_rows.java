package Heaps;

import java.util.PriorityQueue;

public class K_weakest_rows {

    public static class Row implements Comparable<Row> {
        int index;
        int sold;

        public Row(int index, int sold) {
            this.index = index;
            this.sold = sold;
        }

        @Override
        public int compareTo(Row r2){
            if (this.sold == r2.sold){
                return this.index - r2.index;
            }else{
                return this.sold - r2.sold;
            }
        }
    }

    public static void kWeakestRows(int[][] arr, int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i=0; i<arr.length; i++){
            int count = 0;
            for (int j=0; j<arr.length; j++){
                if (arr[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Row(i, count));
        }

        while (k > 0){
            System.out.println("Row" + pq.peek().index + " with strength " + pq.peek().sold);
            pq.remove();
            k--;
        }
    }
    public static void main(String[] args) {
        int[][] army = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };

        int k = 2;

        kWeakestRows(army, k);

    }
}
