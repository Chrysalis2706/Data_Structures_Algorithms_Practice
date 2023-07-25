package Graphs;

import java.util.ArrayList;

public class All_Paths_from_src_to_dest_DFS {
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

        graph[0].add(new Edge(1, 0 ,3));

        graph[2].add(new Edge(1, 2 ,3));

        graph[3].add(new Edge(1, 3 ,1));

        graph[4].add(new Edge(1, 4 ,0));
        graph[4].add(new Edge(1, 4 ,1));

        graph[5].add(new Edge(1, 5 ,0));
        graph[5].add(new Edge(1, 5 ,2));
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path){
        if (src == dest) {
            System.out.print(path + " " + dest + "\n");
            return;
        }

        for (int i=0; i<graph[src].size(); i++){
            // no need of visited array
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path+ " " + src);
        }

    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);

        printAllPaths(graph, 5, 1 ,"");
    }
}
