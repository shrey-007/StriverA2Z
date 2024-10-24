package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed
 * edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a
 * signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * */
public class NetworkDelayTime {
    // Dijkstra algo mai node ke neighbour ko daalte hai priority queue mai toh node ke neighbours pata hone chaiye, but ye
    // jo times array diya hai usme randomly data daala hai toh first create a adjacency list form it which contains src,dest,time

    public int networkDelayTime(int[][] times, int n, int k) {
        // first create adjacency list
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        int n1 = times.length;
        for (int i = 0; i <n1 ; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(List.of(v,w));
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0; // src(k) ka dist 0 hoga

        PriorityQueue<NodeWithTime> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new NodeWithTime(k,0));

        while (!priorityQueue.isEmpty()){
            NodeWithTime nodeWithTime = priorityQueue.poll();
            int currNode = nodeWithTime.node;
            int currTime = nodeWithTime.time;

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

        // Now dist array is filled. dist[i] contains the min time to reach the ith node from k(src node)
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <n; i++) {
            if(dist[i]==Integer.MAX_VALUE){
                // means it was not possible to reach this node from k, so return -1
                return -1;
            }
            else{
                ans = Math.max(ans,dist[i]);
            }
        }

        return ans;
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
