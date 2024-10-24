package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some
 * intersections. The inputs are generated such that you can reach any intersection from any other intersection and
 * that there is at most one road between any two intersections.
 *
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road
 * between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel
 * from intersection 0 to intersection n - 1 in the shortest amount of time.
 *
 * Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be
 * large, return it modulo 109 + 7.
 * */
public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {

        // first create adjacency list
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        int n1 = roads.length;
        for (int i = 0; i <n1 ; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            adj.get(u).add(List.of(v,w));
            adj.get(v).add(List.of(u,w));
        }

        System.out.println(adj);

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0; // src(k) ka dist 0 hoga

        PriorityQueue<NodeWithTime> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new NodeWithTime(0,0));

        int timeOfShortestPath = Integer.MAX_VALUE;

        while (!priorityQueue.isEmpty()){
            NodeWithTime nodeWithTime = priorityQueue.poll();
            int currNode = nodeWithTime.node;
            int currTime = nodeWithTime.time;

            if(currNode==n-1){
                if(currTime<timeOfShortestPath){
                    timeOfShortestPath = currTime;
                    System.out.println(timeOfShortestPath);
                }
            }

            // visit all neighbours
            for (int i = 0; i < adj.get(currNode).size(); i++) {
                int neighbour = adj.get(currNode).get(i).get(0);
                int timeToReachNeighbourFromCurrentNode = adj.get(currNode).get(i).get(1);

                if(currTime+timeToReachNeighbourFromCurrentNode<dist[neighbour]){
                    priorityQueue.offer(new NodeWithTime(neighbour,currTime+timeToReachNeighbourFromCurrentNode));
                    dist[neighbour] = currTime + timeToReachNeighbourFromCurrentNode;
                }
            }
        }

        // so after applying dijkstra, we know that minTime is timeOfShortestPath
        // Now we have to count number of paths with this time
        // Do it using recursion

        int visited[] = new int[n];
        int dp[][] = new int[n][timeOfShortestPath+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        return func(0,adj,n,0,timeOfShortestPath,visited,dp);

    }

    public int func(int node,List<List<List<Integer>>> adj,int n,int timeRequired,int targetTime,int visited[],int dp[][]){
        if(node==n-1){
            if(timeRequired==targetTime){return 1;}
            return 0;
        }

        if(timeRequired<=targetTime && dp[node][timeRequired]!=-1){
            return dp[node][timeRequired];
        }

        visited[node]=1;
        int sumOfAllFaiths = 0;
        int modulo = (int)Math.pow(10,9)+7;

        // try all neighbours
        for (int i = 0; i < adj.get(node).size(); i++) {
            int neighbour = adj.get(node).get(i).get(0);
            int timeToReachNeighbourFromCurrentNode = adj.get(node).get(i).get(1);
            if(visited[neighbour]==0){
                sumOfAllFaiths = (sumOfAllFaiths%modulo + func(neighbour,adj,n,timeRequired+timeToReachNeighbourFromCurrentNode,targetTime,visited,dp)%modulo)%modulo;
            }
        }

        visited[node]=0;

        if(timeRequired<=targetTime) dp[node][timeRequired]=sumOfAllFaiths;

        return sumOfAllFaiths;
    }

    class NodeWithTime implements Comparable<NodeWithTime>{
        int node;
        int time;

        public NodeWithTime(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(NodeWithTime o) {
            return this.time-o.time;
        }
    }
}
