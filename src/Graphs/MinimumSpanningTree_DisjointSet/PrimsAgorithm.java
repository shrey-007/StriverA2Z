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
        // we haven't marked it visited yet

        while (!priorityQueue.isEmpty()){
            Tuple curr=priorityQueue.poll();
            int currNode=curr.node;
            int currWeight=curr.weight;
            int currParent=curr.parent;

            // if the node is already visited means it is in the answer, don't visit again
            if(visited[currNode]==1){continue;}

            // mark it as visited
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
