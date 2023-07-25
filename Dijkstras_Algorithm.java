package Graphs;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Dijkstras_Algorithm {

    public static class Edge {
        int w;
        int src;
        int dest;

        public Edge(int w, int s, int d) {
            this.w = w;
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(2, 0, 1));
        graph[0].add(new Edge(4, 0, 2));

        graph[1].add(new Edge(7, 1, 3));
        graph[1].add(new Edge(1, 1, 2));

        graph[2].add(new Edge(3, 2, 4));

        graph[3].add(new Edge(1, 3, 5));

        graph[4].add(new Edge(5, 4, 5));
        graph[4].add(new Edge(2, 4, 3));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstras(ArrayList<Edge>[] graph, int src) {
        // make all distances infinity
        int[] dist = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (src != i) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.w;

                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }

                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        dijkstras(graph, 0);

        }


}
