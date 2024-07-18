package Graphs.learning;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans=new ArrayList<>();
        int visited[]=new int[V];
        func(0,adj,visited,ans,V);

        return ans;
    }

    public void func(int node,ArrayList<ArrayList<Integer>> adj,int visited[],ArrayList<Integer> ans,int V){
        if(node==V){
            return;
        }
        // mark current node as visited
        visited[node]=1;
        // add it to ans
        ans.add(node);

        // recursively call all its neighbours
        for (int neighbour: adj.get(node)){
            if(visited[neighbour]!=1){
                func(neighbour,adj,visited,ans,V);
            }
        }
    }
}
