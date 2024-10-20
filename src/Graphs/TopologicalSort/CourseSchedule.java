package Graphs.TopologicalSort;

import java.util.ArrayList;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // First convert this prerequisites to a directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList());
        }

        int n = prerequisites.length;
        for(int i=0;i<n;i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            adj.get(u).add(v);
        }
        System.out.println(adj);

        // check whether this graph contains a cycle or not
        // we have already done this question, check whether a directed graph contains a cycle or not
        int visited[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                boolean flag = doesContainCycleDFS(i,visited,numCourses,adj);
                // if this return true means it contains cycle and course could not be scheduled, so teturn false
                if(flag){return false;}
            }
        }

        return true;
    }

    // To check whether a directed graph has cycle or not using dfs
    public boolean doesContainCycleDFS(int node,int[] visited,int n,ArrayList<ArrayList<Integer>> adj){

        visited[node] = 1;

        // visit all its neighbours, if any of the neighbour return true means it contain cycle then return true
        boolean flag = false;
        for(int neighbour: adj.get(node)){
            // visit if it is not visited
            if(visited[neighbour]==0){flag = flag || doesContainCycleDFS(neighbour,visited,n,adj);}
            // if it marked as 1 means it is a cycle
            else if(visited[neighbour]==1){return true;}
            // if it marked as 2 means it is already processed node with no cycles, so don't do anything
            else if(visited[neighbour]==2){}
        }

        visited[node] = 2;
        return flag;
    }
    
}
