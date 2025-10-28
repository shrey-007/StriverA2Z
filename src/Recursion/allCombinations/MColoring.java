package Recursion.allCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoring {

    boolean graphColoring(int v, int[][] edges, int m) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);

        return func(0, adj, color, m);
    }

    // this is trying to color vertices in sequential order 0->1->2 and so on
    boolean func(int node, List<List<Integer>> adj, int[] color, int m) {
        if (node == adj.size()) return true; // all vertices colored

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c;
                if (func(node + 1, adj, color, m)) return true;
                color[node] = -1; // backtrack
            }
        }
        return false;
    }

    boolean isSafe(int node, List<List<Integer>> adj, int[] color, int c) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == c) return false;
        }
        return true;
    }


}


class AnotherWay{
    boolean graphColoring(int v, int[][] edges, int m) {
        // first create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());

        int n = edges.length;
        for(int i=0;i<n;i++){
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int color[] = new int[v];
        Arrays.fill(color,-1);

        boolean faith = true;

        for(int i=0;i<v;i++){
            if(color[i]==-1) faith = faith & func(i,adj,color,m);
        }

        return faith;
    }

    boolean func(int node,List<List<Integer>> adj,int color[],int m){
        // so this node can be colored from 1 to m
        for(int i=1;i<=m;i++){
            // check whether this node can be colored i or not
            boolean flag = true;
            List<Integer> neighbors = adj.get(node);
            for(int neighbor : neighbors){
                if(color[neighbor]==i){
                    // then we can not color it i
                    flag = false;
                    break;
                }
            }
            if(flag){
                // means we can color it i, so color it and go to its neighbors
                // all its neighbor should return true only
                color[node] = i;
                for(int neighbor : neighbors){
                    if(color[neighbor]==-1) flag &= func(neighbor,adj,color,m);
                }
            }

            if(flag){
                return true;
            }
        }

        return false;
    }
}
