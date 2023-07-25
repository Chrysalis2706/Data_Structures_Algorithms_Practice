package Graphs;

import java.util.PriorityQueue;

public class Connecting_cities {
    public static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    public static int connectCities(int[][] cities){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[cities.length];
        int finalCost = 0;

        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()){
            Edge curr = pq.remove();

            if (!vis[curr.dest]){
                finalCost += curr.cost;
                vis[curr.dest] = true;
                for (int i=0; i<cities.length; i++){
                    if (cities[curr.dest][i] != 0){
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {
        int[][] cities = {
                {0, 1, 2, 3, 4},
                {1, 0, 5, 0, 7},
                {2, 5, 0, 6, 0},
                {3, 0, 6, 0, 0},
                {4, 7, 0, 0, 0}
        };

        System.out.println(connectCities(cities));

    }
}
