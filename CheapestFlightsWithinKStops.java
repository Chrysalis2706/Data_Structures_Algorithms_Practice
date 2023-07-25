package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Info{
        int node, cost, stops;

        public Info(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create graph in this function only
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        // Follow dijkstras
        int[] dist = new int[n];
        for (int i=0; i<n; i++){
            if (src != i) dist[i] = Integer.MAX_VALUE; // make all other nodes INFINITE
        }

        //make queue of Info
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,0,0));

        while (!q.isEmpty()){
            Info curr = q.remove();
            if (curr.stops > k){
                break;
            }

            // check for neighbours
            for (int i=0; i<graph[curr.node].size(); i++){
                Edge e = graph[curr.node].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // relaxation
                if (dist[u] != Integer.MAX_VALUE && curr.cost + wt < dist[v]){ //check for the curr node's cost bot dist[u]
                    dist[v] = curr.cost + wt;
                }
                q.add(new Info(v, dist[v], curr.stops+1));
            }
        }

        // Return the dist[dest]
        return  (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }

    public static void createGraph(int[][] arr, ArrayList<Edge>[] graph){
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i< arr.length; i++){
            int src = arr[i][0];
            int dest = arr[i][1];
            int wt = arr[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 1;
        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };

        int ans = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(ans);
    }
}
