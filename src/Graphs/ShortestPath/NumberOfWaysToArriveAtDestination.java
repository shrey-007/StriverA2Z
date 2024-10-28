package Graphs.ShortestPath;

import java.util.*;

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


    // or there is another way, use modified Dijkstra-:
    /**
     * he steps are as follows:
     *
     * Dijkstra’s Algorithm: Use a priority queue to maintain nodes based on the shortest time to reach them.
     * Distance Array: Maintain an array dist[] where dist[i] is the shortest time to reach node i from the source.
     * Count Array: Maintain a count[] array where count[i] stores the number of ways to reach node i using the shortest
     * time.
     * For each node u, when a shorter path to node v is found, update the distance dist[v] and reset count[v] to the
     * count of ways to reach u. If a path to v is found with the same shortest distance, increment count[v].
     * */
    class Solution {
        public int countPaths(int n, int[][] roads) {
            // Create an adjacency list for the graph
            List<int[]>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] road : roads) {
                graph[road[0]].add(new int[]{road[1], road[2]});
                graph[road[1]].add(new int[]{road[0], road[2]});
            }

            // Dijkstra's algorithm with counting paths
            int MOD = 1_000_000_007;
            long[] dist = new long[n]; // dist[i] stores the shortest time to reach node i
            long[] count = new long[n]; // count[i] stores the number of ways to reach node i
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            count[0] = 1; // Start from node 0

            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1])); // (node, distance)
            pq.offer(new long[]{0, 0}); // Start from node 0 with distance 0

            while (!pq.isEmpty()) {
                long[] curr = pq.poll();
                int u = (int) curr[0];
                long currDist = curr[1];

                if (currDist > dist[u]) continue; // If we've already found a shorter path, skip

                // Process neighbors of node u
                for (int[] neighbor : graph[u]) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    long newDist = currDist + weight;

                    // If a shorter path to v is found
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        count[v] = count[u]; // Reset count of ways to reach v
                        pq.offer(new long[]{v, newDist});
                    } else if (newDist == dist[v]) {
                        // If another shortest path to v is found
                        count[v] = (count[v] + count[u]) % MOD;
                    }
                }
            }

            return (int) count[n - 1]; // Return number of ways to reach the last node (destination)
        }
    }

}
