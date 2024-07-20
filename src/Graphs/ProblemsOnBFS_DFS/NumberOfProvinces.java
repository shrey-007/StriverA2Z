package Graphs.ProblemsOnBFS_DFS;

public class NumberOfProvinces {
    /**
     * This question is same as connected components concept explained in copy, Isme bas number of components
     * nikaalne hai. Toh simply ek for loop lagao visited array mai , jitni baar if condition run hogi utne components
     * hoge. It is very easy, only this is ki adjacency list ki jagah matrix di hai toh dfs mai neighbours find krne
     * ka tareeka change hoga.
     * */
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        int visited[]=new int[v];

        int noOfConnectedComponents=0;

        for (int i = 0; i < visited.length; i++) {
            if(visited[i]==0){
                // jitni baar if condition run hogi utne components hoge
                noOfConnectedComponents++;
                dfs(i,isConnected,visited);
            }
        }

        return noOfConnectedComponents;
    }

    public void dfs(int node,int [][] isConnected,int visited[]){
        if(node==isConnected.length){
            // means ye node exists hi nhi krti
            return;
        }
        // mark the current node as visited
        visited[node]=1;

        // call for its neighbours, if they are not visited
        for (int i = 0; i < isConnected[0].length; i++) {
            if(isConnected[node][i]==1){
                // means i is neighbour of node, but call dfs only if it is visited
                if(visited[i]==0){
                    dfs(i,isConnected,visited);
                }
            }
        }

    }
}
