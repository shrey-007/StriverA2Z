package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraphUsingDFS {
   /**
    * 1) The concept is same as CycleDetectionInUndirectedGraphUsingBFS , bas travesal method different hai baaki concept same hai
    * 2) Isme parent pointer mark krne ke liye recursion mai hi (int parent) ka parameter dedo
    * */
   public boolean isCycle(int V, ArrayList< ArrayList<Integer>> adj) {
       int vis[] = new int[V];
       for(int i = 0;i<V;i++) {
           if(vis[i] == 0) {
               if(dfs(i, -1, vis, adj) == true) return true;
           }
       }
       return false;
   }

    public boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        // go to all adjacent nodes
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, node, vis, adj) == true)
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if(adjacentNode != parent) return true;
        }
        return false;
    }


}
