package Graphs;
import java.util.*;

public class Topological_Sort {
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

        graph[2].add(new Edge(1, 2 ,3));

        graph[3].add(new Edge(1, 3 ,1));

        graph[4].add(new Edge(1, 4 ,0));
        graph[4].add(new Edge(1, 4 ,1));

        graph[5].add(new Edge(1, 5 ,0));
        graph[5].add(new Edge(1, 5 ,2));
    }

    public static void topologicalSort(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i=0; i< graph.length; i++){
            //for connected components
            if (!vis[i]){
                topologicalSortUtil(graph, vis, s, i);
            }
        }

        //print the elements in the stack
        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr){
        vis[curr] = true;

        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                topologicalSortUtil(graph, vis, s, e.dest);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);

        topologicalSort(graph);
    }
}
