package Graphs;


import java.util.*;

public class GraphBasics {
    static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    // TC : O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        // print and mark visited
        System.out.print(curr + " ");
        vis[curr] = true;

        // adding neighbours
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }


    //  TC : O(V+E)
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        // add element to queue
        que.add(0);

        while (!que.isEmpty()){
            int curr = que.remove();
            if (!vis[curr]){
                vis[curr] = true;
                System.out.print(curr + " ");
                //adding the neighbours
                for (int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    que.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        graph[3].add(new Edge(4, 2, 2));

        for (int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }
}
