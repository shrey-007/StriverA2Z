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

        // initialise distance array
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0; // src(k) ka dist 0 hoga

        // create PQ
        PriorityQueue<NodeWithTime> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new NodeWithTime(k,0));

        while (!priorityQueue.isEmpty()){
            NodeWithTime nodeWithTime = priorityQueue.poll();
            int currNode = nodeWithTime.node;
            int currTime = nodeWithTime.time;

            // this is the most important thing, this rejection. It is reducing unnecessary processing
            if(currTime>dist[currNode]){continue;}

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


    /**
     * Ok so here are some concepts to remember-:
     * 1. If the graph is unweighted then bfs/dfs will work fine. But if the graph is an weighted graph rhen dijkstra
     *    will prioritize less weight path and hence will be more optimized.
     * 2. If the question is src to dest with min cost then it is definitely dijkstra
     * 3. But is question mai min dist nikaalna hai src node to all, and then unka max find krna hai. So thing is since it
     *    is a weighted graph apply dijstra, bfs bhi laga skte ho. Dekho dijkstra lagane ka matlab tab hai jab tume kuch
     *    rejections kr rhe ho, bfs saare paths dekhega(orderly) and dijkstra bhi saare paths dekhega but greedily. And
     *    the point is ki since dijkstra ne pehle achhe paths dekh liye hai toh voh reject kr skta hai upcoming paths ko
     * 4. So see if you can apply any rejections then apply dijkstra, else it could be done with simple bfs only. In src
     *    to dest questions, dijkstra use krte hai since agar apan dest pahuche toh voh shortest path hai toh don't explore
     *    further return the answer right now.
     *
     * ----------- MAIN QUESTION IS WHY WE DONT DO THIS QUESTION WITH BFS, IT IS SAME AS ROTTEN ORANGES------------------------
     * 5. Since this is not src to dest question toh isme poora PQ ko process krna padega, we can not directly return the
     *    ans. Is question mai kese pata pade ki sabke shortest time vale path explore ho gye hai and ab aage explore mat kro.
     *    Suppose ek node x hai use jaane mai t1 time laga and bhi use PQ mai daala hai abhi voh aaya nhi hai us node pr
     *    but dist[x]=t1 ho gya hai, and now kisi aur se bhi x jaa skte hai with less than t1(let t2) toh condition true hogi
     *    and x vaapis se PQ mai jaaegi with time t2. Also dist[x]=t2 ho gya. Abhi dono hi x PQ mai hai kahi par and dist[x]=t2 hai.
     *    Ab suppose (x,t2) aaya top pr (since t2<t1 toh pehle yahi top pr aaega) and isne apne neighbours daal diye.
     *    Ab suppose thode der baad (x,t1) aaya top pr ,but since dist[x]=t2 hai jo ki less than t1 hai toh ise reject krdo
     *    , ise process krne ka koi sense nhi hai, since is tak pahuchne mai hi jyada time laga toh iske neighbours tak
     *    pahuchne mai bhi lagega. Agar same algo bfs mai krte toh ye rejections nhi kr paate kuiuki voh t1 vaala path pehle
     *    explore krte fir t2 vala krta, islie dijstra is better than bfs
     *
     * */

}
