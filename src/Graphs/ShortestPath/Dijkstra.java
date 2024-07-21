package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * 1) You have to apply BFS only
     * 2) It can be solved using Queue(takes a lot of time), PriorityQueue(takes less time), Set(fastest)
     * 3) Whenever you find a better distance, update it in answer and push it in PQ
     * 4) Dijkstra is not applicable to graphs with negative weights, because vo infinite loop mai fas jaaega, example ke liye lelo 2 node jinke beech ek edge hai of weight -2.
     * 5) We can do the same using queue also , poora code same rahega bas data structure change hoga, queue saare possible paths dekhega, but PQ only shortest path dekhega
     * 6) There is no visited array in Dijkstra, dist[] array vo kaam krega, jaise BSF mai visited[i]=0 hota tha tabhi uspe
     *    jaate the vaise hi yaha agar cuurentDistance+distanceToReach<dist[i] hoga tabhi uspr jaaege
     * */

    public int[] dijkstraUsingPQ(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int source){

        PriorityQueue<NodeWithDistance> priorityQueue=new PriorityQueue<>();

        // ans
        int dist[]=new int[V];

        // mark all distances as infinity
        Arrays.fill(dist,Integer.MAX_VALUE);

        // mark distance of source as 0, and add it in PQ
        dist[source]=0;
        priorityQueue.add(new NodeWithDistance(source,0));

        while (!priorityQueue.isEmpty()){

            NodeWithDistance curr=priorityQueue.poll();

            // get all its neighbours
            for (int i = 0; i < adj.get(curr.node).size(); i++) {
                int neighbourNode=adj.get(curr.node).get(i).get(1);
                int neighbourWeight=adj.get(curr.node).get(i).get(0);

                if(curr.distance+neighbourWeight<dist[neighbourNode]){
                    dist[neighbourNode]=curr.distance+neighbourWeight;
                    priorityQueue.add(new NodeWithDistance(neighbourNode,dist[neighbourNode]));
                }
            }

        }


        return dist;
    }
    /**TC- E*log(V) */

    /**If you use TreeSet(unique and sorted elements) instead of priority queue toh vo duplicate elements store nhi kregi,
     * like for example PQ mai ek baar mai (10,4) and (10,7) dono ho skte hai toh agar 10 , 4 dist mai jaa skta hai toh
     * 7 ki need nhi hai fir bhi PQ usko consider krega and usper operations krega but TS(treeset) nhi krega, but treeset
     * us duplicate element (10,7) ko remove krne mai log(n) time le lega toh dono barabar pr hi aajaege toh tum keh nhi
     * skte ki kisme jldi hoga.*/


}

class NodeWithDistance implements Comparable<NodeWithDistance>{
    int node;
    int distance; // distance to reach this node form src

    public NodeWithDistance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(NodeWithDistance o) {
        return this.distance-o.distance;
    }
}
