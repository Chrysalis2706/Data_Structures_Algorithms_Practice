package Graphs;

import java.util.ArrayList;

public class CycleDetection_Directed {
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

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(1, 0, 2));

        graph[1].add(new Edge(1, 1, 0));

        graph[2].add(new Edge(1, 2, 3));

        graph[3].add(new Edge(1, 3, 0));
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i=0; i<graph.length; i++){
            if (!vis[i]){
                if (isCyclisUtil(graph, vis, stack, i)) return true;
            }
        }
        return false;
    }

    public static boolean isCyclisUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr){
        vis[curr] = true;
        stack[curr] = true;

        for (int i=0; i<graph[curr].size(); i++){
            //cyclic
            Edge e = graph[curr].get(i);
            if (stack[e.dest]){
                return true;
            }

            //check for another nodes
            if (!vis[e.dest] && isCyclisUtil(graph, vis, stack, e.dest)){
                return true;
            }
        }

        stack[curr] = false;  //popping the immediate neighbour
        return false;

    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[4];
        createGraph(graph);

        System.out.println(isCyclic(graph));
    }

}
