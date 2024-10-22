package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // first create a directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses ; i++) {
            adj.add(new ArrayList<>());
        }

        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj.get(u).add(v);
        }

        // Now we want the linear ordering of this graph
        // so do this using normal
        Stack<Integer> linearOrdering = new Stack<>();
        int visited[] = new int[numCourses];
        boolean [] isPossible = new boolean[1];
        isPossible[0]=true;

        for (int i = 0; i < numCourses; i++) {
            if(visited[i]==0){
                dfs(i,numCourses,prerequisites,linearOrdering,visited,adj,isPossible);
            }
        }

        if(isPossible[0]==false){return new int[0];}

        int ans[] = new int[numCourses];
        int i=0;
        while (!linearOrdering.isEmpty()){
            ans[i]=linearOrdering.pop();
            i++;
        }

        return ans;

    }

    public void dfs(int node,int numCourses, int[][] prerequisites,Stack<Integer> linearOrdering,int visited[],ArrayList<ArrayList<Integer>> adj,boolean[] isPossible){
        // mark current node visited
        visited[node] = 1;

        // visit all unvisited neighbours
        for (int i = 0; i <adj.get(node).size(); i++) {
            int neighour = adj.get(node).get(i);
            if(visited[neighour]==0){
                // neighbour is unvisited so, visit it
                dfs(neighour,numCourses,prerequisites,linearOrdering,visited,adj,isPossible);
            }
            else if(visited[neighour]==1){
                // means ot is a cycle so no linear ordering is possible
                isPossible[0]=false;
                return;
            }
        }


        // Mark the node as fully visited
        visited[node] = 2;

        linearOrdering.push(node);
    }



}
