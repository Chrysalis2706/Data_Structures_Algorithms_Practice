package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_and_DFS {

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

        graph[1].add(new Edge(1, 1,3));

        graph[2].add(new Edge(1, 2, 4));

        graph[3].add(new Edge(1, 3, 1));
        graph[3].add(new Edge(1, 3, 4));
        graph[3].add(new Edge(1, 3, 5));

        graph[4].add(new Edge(1, 4, 2));
        graph[4].add(new Edge(1, 4, 3));
        graph[4].add(new Edge(1, 4, 5));

        graph[5].add(new Edge(1, 5, 6));
        graph[5].add(new Edge(1, 5, 3));
        graph[5].add(new Edge(1, 5, 4));

        graph[6].add(new Edge(1, 6, 5));
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        // to traverse all the components
        for (int i=0; i<graph.length; i++){
            if (!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }


    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        //add source to the queue first
        q.add(0);

        //just like level order traversal
        while(!q.isEmpty()){
            int curr = q.remove();
            if (!vis[curr]){
                System.out.print(curr + " -> ");
                vis[curr] = true;
                for (int i=0; i<graph[curr].size(); i++){
                    // we go to all the neighbours of the node
                    Edge e = graph[curr].get(i);
                    q.add(e.dest); // adding the next node of the curr node
                }
            }
        }
        System.out.println("end");
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for (int i=0; i<graph.length; i++){
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        System.out.print(curr + " -> ");
        vis[curr] = true;

        //for first neighbour
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src,  int dest, boolean[] vis){
        if (src == dest) return true;
        vis[src] = true;

        for (int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        //O(V+E)
        System.out.println("BFS :");
        bfs(graph);

        System.out.println("DFS :");
        dfs(graph);
        System.out.println("end");

        System.out.println(hasPath(graph, 1, 6, new boolean[V]));

    }

}
