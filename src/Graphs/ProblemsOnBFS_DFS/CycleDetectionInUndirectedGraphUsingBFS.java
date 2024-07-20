package Graphs.ProblemsOnBFS_DFS;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CycleDetectionInUndirectedGraphUsingBFS {

    /**
     * 1) BFS traversal kro and jis node pr aaye ho , uske parent ko store krte jaao jisse pata pade uska parent kon hai(NodeParent class store node and its parent)
     * 2) BFS se bas farak itna hai ki isme agar node ka koi neighbour visited marked hai toh ya toh vo uska parent hoga,
     *    kiuki uska parent pehle queue mai gaya hoga , apne aap ko visited mark kiya hoga and apne childrens ko daala
     *    hoga queue mai. Toh agar vo parent hai toh koi problem nhi hai
     *    But agar vo parent nhi hai phir bhi visited marked hai means ki vo cycle hai toh return true
     * 3) Also Is graph mai components hai, toh iske saare components mai check kro cycle hai ki ni , kisi ek mai bhi
     *    agar cycle hai toh return true
     *    */
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        int visited[]=new int[V];



        // Also Is graph mai components hai, toh iske saare components mai check kro cycle hai ki ni , kisi ek mai bhi
        // agar cycle hai toh return true
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]!=1){
                if(func(i,adj,visited)){return true;}
            }
        }

        // means ki saare components dekh liye kisi mai bhi cycle nhi hai
        return false;
    }

    public boolean func(int node,ArrayList<ArrayList<Integer>> adj,int [] visited){

        Queue<NodeParent> queue=new ArrayDeque<>();

        // initial node ko daalo with parent(-1) means iska koi parent nhi hai
        queue.offer(new NodeParent(node,-1));
        visited[node]=1;

        while (!queue.isEmpty()){
            NodeParent nodeParent=queue.poll();

            // insert all its neighbours
            for (int neighbour : adj.get(node)){
                if(visited[neighbour]==0){
                    // so it is not visited means ki ise daaldo queue mai
                    queue.offer(new NodeParent(neighbour,nodeParent.parent));
                    visited[neighbour]=1;
                }
                // means it is already visited
                else{
                    // so it is visited either because vo uska parent hai, ya phir cycle hai
                    // Agar parent hai toh koi problem nhi hai parent toh visited hoga hi, but agar parent nhi hai, means
                    // usko kisi aur ne already visited mark kra hai means ki cycle hai
                    if(neighbour!=nodeParent.parent){
                        return true;
                    }
                }
            }

        }

        return false;
    }

}

// A class to store node and its parent
class NodeParent{
    int node;
    int parent;

    public NodeParent(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}
