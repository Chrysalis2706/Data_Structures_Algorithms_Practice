package Heaps;

import java.util.PriorityQueue;

public class Nearby_cars {

    public static class Points implements Comparable<Points> {
        int x;
        int y;
        int distSq;
        int indx;

        public Points(int x, int y, int distSq, int indx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.indx = indx;
        }

        @Override
        public int compareTo(Points p2){
            return this.distSq - p2.distSq; //ascending order
        }
    }

    public static void findNearbyCars(int[][] points, int k){
        PriorityQueue<Points> pq = new PriorityQueue<>();
        int x, y, dist;

        for (int i=0; i<points.length; i++){
            x = points[i][0];
            y = points[i][1];
            dist = (int)Math.pow(x, 2) +  (int)Math.pow(y, 2) ;

            pq.add(new Points(x, y, dist, i));
        }

        // printing k elements
        for (int i=0; i<k; i++){
            System.out.println("C-" + pq.peek().indx + " Distance " + pq.peek().distSq);
            pq.remove();
        }
    }

    public static void main(String[] args) {
        int[][] points = {
                {3,2},
                {5, -1},
                {-2, 4}
        };

        findNearbyCars(points, 2);
    }
}
