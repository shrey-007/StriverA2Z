package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array
 * graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there
 * is an undirected edge between node u and node v. The graph has the following properties:
 *
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 * */
public class BipartiteGraph {

    // This question can also be framed as this-:
    /**
     * The bipartite problem asks: Can we divide the nodes of a graph into two groups (let's call them "Group A" and
     * "Group B") in such a way that:
     *
     * Every node is connected to its neighbors.
     * No two neighboring nodes are in the same group.
     * In other words, if a node is in "Group A," all its neighbors must be in "Group B," and if a node is in "Group B,"
     * all its neighbors must be in "Group A."
     *
     * If we can successfully divide the nodes this way, the graph is called bipartite. If not (i.e., if any two
     * neighboring nodes end up in the same group), the graph is not bipartite.
     * */

    /**
     * Can also be framed as ki 2 colors hai poore graph ko color krna hai such that adjacent nodes mai same color
     * na ho. Can we color it?
     * */
    public boolean isBipartite(int[][] graph) {
        // this graph has several components so we have to check if any of the component is not bipartite then return false
        int n = graph.length;
        int [] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if(visited[i]==0){
                boolean flag = func(graph,visited,i);
                if(!flag){return false;}
            }
        }

        return true;
    }

    public boolean func(int[][] graph,int visited[],int sourceNode){
        int n = graph.length;

        int group[] = new int[n];  // A group means 0, B group means 1 and -1 means abhi koi group assign ni hua


        Arrays.fill(group,-1);      // initially kisi ko koi group assign ni hua


        // put the source(0) in queue and mark it visited
        Queue<Integer> queue = new ArrayDeque<>();
        // also isko kisi bhi ek group mai daaldo A or B, mai A mai dall deta hu
        queue.offer(sourceNode);
        visited[0]=1;
        group[0]=0;


        while (!queue.isEmpty()){
            int node = queue.poll();

            // find the group of current node
            int groupOfCurrentNode = group[node];

            //visit all its neighbours even visited ones
            int numberOfNeighbours = graph[node].length;

            for (int i = 0; i < numberOfNeighbours; i++) {

                int neighbourNode = graph[node][i];

                // if the neighbour is not visited then visit it
                if(visited[neighbourNode]==0){
                    queue.offer(neighbourNode);
                    visited[neighbourNode]=1;
                    // current node ka jo group hai uska opposite group dena hai isko, isliye negation ka sign hai
                    group[neighbourNode]=~groupOfCurrentNode;
                }
                // if the neighbour is already visited means usko kisi ek group mai daala tha, and ye cuurentNode
                // iski neighbour node hai toh dono ko same group mai ni daal skte toh check kro ki kahi esa toh nhi
                // ki dono same group mai hai
                else{
                    if(groupOfCurrentNode==group[neighbourNode]){
                        // then return false
                        // but problem is ki color of Neighbour kese pata kre, kiuki uske liye apne paas neightbour
                        // ka cell object nhi hai
                        // Toh color of neighbour kahi store aur store kro, cell class ke alawa
                        // you can store it in array.
                        return false;
                    }
                }

            }
        }

        return true;
    }

}
