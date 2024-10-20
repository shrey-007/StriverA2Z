package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    // It is ditto same as DFS, bas jab ek node ke saare neighbours visit krliye toh usko stack mai daaldo.
    public int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj){
        int visited[]=new int[v];
        // to store the ordering
        Stack<Integer> linearOrdering = new Stack<>();

        // do dfs
        for (int i = 0; i < v; i++) {
            if(visited[i]==0){
                dfs(i,visited,linearOrdering,adj);
            }
        }

        // now stack holds the answer, top element is the 0th element of the order, and so on
        int ans[] = new int[v];
        int i=0;
        while (!linearOrdering.isEmpty()){
            ans[i]=linearOrdering.pop();
            i++;
        }
        return ans;
    }

    // df function with only one change at last line
    public void dfs(int node,int visited[],Stack<Integer> linearOrdering,ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int neightbourNode = adj.get(node).get(i);
            if(visited[neightbourNode]==0){
                dfs(i,visited,linearOrdering,adj);
            }
        }
        // jab node ke saare neighbours visit krliye toh is node ko stack mai daaldo
        linearOrdering.push(node);
    }
}
