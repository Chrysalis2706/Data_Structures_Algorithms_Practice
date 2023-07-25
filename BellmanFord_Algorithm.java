package Graphs;

import java.util.ArrayList;

public class BellmanFord_Algorithm {

    public static class Edge{
        int s;
        int d;
        int w;
        public Edge(int w, int s, int d){
            this.w = w ;
            this.s = s;
            this.d = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(2, 0, 1));
        graph[0].add(new Edge(4, 0, 2));

        graph[1].add(new Edge(-4, 1, 2));

        graph[2].add(new Edge(2, 2, 3));

        graph[3].add(new Edge(4, 3, 4));

        graph[4].add(new Edge(-1, 4, 1));

    }

    public static void createGraph2(ArrayList<Edge>graph) {

            graph.add(new Edge(2, 0, 1));
            graph.add(new Edge(4, 0, 2));

            graph.add(new Edge(-4, 1, 2));

            graph.add(new Edge(2, 2, 3));

            graph.add(new Edge(4, 3, 4));

            graph.add(new Edge(-1, 4, 1));

        }

    public static void belmanFord(ArrayList<Edge>[] graph, int src){
        // make dist array and make all infinity except src
        int[] dist = new int[graph.length];
        for (int i =0; i<graph.length; i++){
            if (i != src) dist[i] = Integer.MAX_VALUE;
        }

        int V = graph.length;
        //Vertices
        for (int k = 0; k < V-1; k++){
            // Edges
            for (int i=0; i<graph.length; i++){
                for (int e=0; e<graph[i].size(); e++){
                    Edge E = graph[i].get(e);
                    // relaxation
                    int u = E.s;
                    int v = E.d;
                    int w = E.w;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        // print the array dist
        for (int i=0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
    }

    public static void belmanFord_usingEdges(ArrayList<Edge> graph, int src, int V){
        // make dist array and make all infinity except src
        int[] dist = new int[V];
        for (int i =0; i<V; i++){
            if (i != src) dist[i] = Integer.MAX_VALUE;
        }


        //Vertices
        for (int k = 0; k < V-1; k++){
            // Edges

                for (int e=0; e<graph.size(); e++){
                    Edge E = graph.get(e);
                    // relaxation
                    int u = E.s;
                    int v = E.d;
                    int w = E.w;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }

        }

        // print the array dist
        for (int i=0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);



        // Creating graph using only edges
        ArrayList<Edge> graphEdges = new ArrayList<>();
        createGraph2(graphEdges);

        belmanFord(graph, 0);
        System.out.println();
        belmanFord_usingEdges(graphEdges, 0, V);
    }
}
