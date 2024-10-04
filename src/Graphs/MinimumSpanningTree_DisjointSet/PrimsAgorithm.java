package Graphs.MinimumSpanningTree_DisjointSet;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAgorithm {

    /**
     * 1) If they are asking to give sum of weights of MST then no need to store parent, we can do it using node and weight
     *    only, But if they ask you to return the edges of MST then you have to store parents
     * 2) Greedy approach is the intuition(smallest weight edges ko milate raho, agar cycle bn rhi hai toh mat lo)
     * 3) TC- : E*log(E)
     * */

    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        int visited[]=new int[V];
        PriorityQueue<Tuple> priorityQueue=new PriorityQueue<>();
        // to count the total cost(weight)
        int sum=0;
        ArrayList<ArrayList<Integer>> EdgesOfMST=new ArrayList<>();

        // start with any node, because every node has to be included, so you can start with any one.
        priorityQueue.add(new Tuple(0,0,-1));
        // we haven't marked it visited yet, to know the reason, see the below documentation comment

        while (!priorityQueue.isEmpty()){
            Tuple curr=priorityQueue.poll();
            int currNode=curr.node;
            int currWeight=curr.weight;
            int currParent=curr.parent;

            // if the node is already visited means it is in the answer, don't visit again
            // ye line ko hatane se ans nhi aa rha
            // suppose tumne x node ko pq mai daala coz vo visited ni tha
            // next iteration mai suppose ki pq mai sabse uper x node ni y node tha and y node ne vaapis se x ko daala, kiuki vo visited ni tha
            // ab pq mai 2 x node hai, unme se smallest vaala sum mai add ho jaaega but doosra vaala ignore ho isliye us iteration ko ignore kr diya
            if(visited[currNode]==1){continue;}

            // mark it as visited,
            visited[currNode]=1;

            // if the parent is -1 means it is not an edge , it is just a starting node.Toh ise EdgesOfMST nhi daalege
            // coz usme edges daalna hai nodes nhi.
            // No need to do this step, if they are only asking for cost and no edges
            if(currParent!=-1){
                ArrayList<Integer> currentEdge=new ArrayList<>();
                currentEdge.add(currParent);
                currentEdge.add(currNode);
            }

            // add the sum
            sum=sum+currWeight;


            // traverse all its neighbours, if they are unvisited
            // (see this is what prims algorithm does vo connected edges se shortest edge nikaalegi)
            for (int [] neighbours:adj.get(currNode)){
                int neighbourNode=neighbours[0];
                int neighbourWeight=neighbours[1];
                // visit them only if they are unvisited
                if(visited[neighbourNode]==0){priorityQueue.add(new Tuple(neighbourNode,neighbourWeight,currNode));}
            }

        }

        return sum;
    }

}
class Tuple implements Comparable<Tuple>{
    int node;
    int weight;
    int parent;

    public Tuple(int node, int weight, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.weight-o.weight;
    }
}

/**
 * <h2>In the below prims algorithm, why don't we mark the node visited , the moment we put it into the priority queue?</h2>
 *
 * <p>
 * Multiple Entries with Different Costs: When a node is added to the priority queue, it is added with the cost (or weight) of reaching that node from its parent node. A single node can have multiple entries in the priority queue because there can be multiple edges connecting it to different nodes in the current Minimum Spanning Tree (MST) with different weights.
 *
 * Selecting the Minimum Edge: The key idea of Prim's algorithm is to always expand the MST by adding the smallest possible edge that connects a new node to the existing MST. If we marked a node as visited immediately when it is added to the queue, we would be locking in the first edge to that node, even if there might be a smaller edge that reaches the node later in the queue.
 *
 * Ensuring the Correct MST: By only marking the node as visited when it is removed from the priority queue, we ensure that we have selected the smallest edge to that node. This approach allows the algorithm to potentially ignore longer paths to the node that arrive later in the priority queue. If a node is marked as visited when dequeued, it guarantees that we have found the shortest way to reach it from the current MST.
 *
 * Avoiding Redundant Processing: When a node is dequeued and found to be visited already (if (visited[currNode] == 1) continue;), it means that a shorter path to this node has already been processed. Hence, we can safely ignore this entry without any further processing.
 * </p>
 *
 * <p>
 *     Example Scenario
 * Consider a graph with nodes A, B, and C, with edges:
 *
 * A-B of weight 1
 * A-C of weight 3
 * B-C of weight 2
 * If we start with node A, the initial entries in the priority queue would be:
 *
 * B (weight 1)
 *
 * C (weight 3)
 *
 * If we mark nodes as visited when adding to the queue, C would be marked visited with a weight of 3.
 *
 * However, B (with weight 1) would be dequeued next, and it adds C again to the queue with weight 2.
 *
 * Since C is already marked visited from earlier (weight 3), we would ignore this shorter path via B, leading to an incorrect MST.
 *
 * By marking nodes as visited only when they are dequeued, we ensure that C is included in the MST with the correct weight of 2 (via B).</p>
 *
 */

