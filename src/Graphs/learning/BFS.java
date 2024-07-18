package Graphs.learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
    /**
     * Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
     */

    /**
     * It is ditto same as BFS(level order) of tree, only difference is ki tree mai cycle nhi hoti toh ek node ek hi
     * baar visit hoti hai. But graph mai cycle hoti hai toh, also ek node se doosre node mai jaane ke different paths
     * bhi hote hai toh ek hi node ko multiple baar na answer mai rakhle isliye usme visited[] array banate hai.
     * That's it. else everything is ditto same*/

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        int visited[]=new int[V];
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> queue=new ArrayDeque<>();

        // start from 0 (given in question)
        queue.offer(0);
        // mark it as visited
        visited[0]=1;

        while (!queue.isEmpty()){
            int curr=queue.poll();

            // add it to ans
            ans.add(curr);

            // add all its neighbours
            for (int neighbours:adj.get(curr)){
                if(visited[neighbours]!=1){
                    // add it only when it is not visited
                    // mark it visited
                    visited[neighbours]=1;
                    queue.offer(neighbours);
                }
            }

        }

        return ans;
    }
}
