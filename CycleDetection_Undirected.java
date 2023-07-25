package Graphs;

import java.util.ArrayList;

public class CycleDetection_Undirected {

    public static class Edge{
        int w;
        int src;
        int dest;

        public Edge(int w, int s, int d){
            this.w = w;
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>(); //assigning a new array list at each index of graph array
        }

        graph[0].add(new Edge(1, 0, 1));
        graph[0].add(new Edge(1, 0, 2));
        graph[0].add(new Edge(1, 0, 3));

        graph[1].add(new Edge(1, 1,0));
        graph[1].add(new Edge(1, 1,2));

        graph[2].add(new Edge(1, 2, 0));
        graph[2].add(new Edge(1, 2, 1));

        graph[3].add(new Edge(1, 3, 0));
        graph[3].add(new Edge(1, 3, 4));

        graph[4].add(new Edge(1, 4, 3));
    }

    public static boolean cycleDetect(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];

        for (int i=0; i<graph.length; i++){
            if (!vis[i]){
                if (detectUtil(graph, vis, i, -1)) return true;
            }
        }
        return false;
    }

    public static boolean detectUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par){
        vis[curr] = true;

        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            // case 1 : unvisited
            if (!vis[e.dest]){
                if (detectUtil(graph, vis, e.dest, curr))
                return true;
            }

            // case 2 : visited and not parent
            if (vis[e.dest] && e.dest != par){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println(
                "Cycle Exists : "  + cycleDetect(graph)
        );
    }
}
