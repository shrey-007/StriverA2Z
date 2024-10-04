package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathBetweenTwoNodes {
    /** source-1, destination-n , print the shortest path between src, dest */
    /** So we will use Dijkstra with slight changes, we will remember ki hum kaha se aaye the, toh hum parent pointer store krege */

    public ArrayList<Integer> dijkstraUsingPQ(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){

        int source=1;
        int destination=V;

        PriorityQueue<NodeWithDistance> priorityQueue=new PriorityQueue<>();

        // create a parent array and sabka parent khud ko hi bana do
        int parentPointers[]=new int[V];
        for (int i = 0; i < V; i++) {
            parentPointers[i]=i; // means initially 1 ka parent 1 hai, 2 ka parent 2 hai and so on ...
        }

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
                    parentPointers[neighbourNode]=curr.node; // neighbours ka parent is current node ko mark kro
                    priorityQueue.add(new NodeWithDistance(neighbourNode,dist[neighbourNode]));
                }
            }

        }

        // yaha tak aaye means ki apan ke paas dist[] ke (v)th index pr src to dest ka shortest distance likha hai,
        // and since ab ye dekho ki v par aaye toh kaha se aaye vo apan ko parentPointers[v] bataega(let x se aaye toh
        // arraylist mai {x,v} add krdo) . Ab ye dekho x par kaha se aaye vo parentPointers[x] bataega and so on ese hi
        // krte raho jab tak kisi ka parentPointers[i]=1 na ho jaaye , jab 1 hua mtlab vaha se aaye means tumhe 1 to V ka path il gya
        ArrayList<Integer> ans=new ArrayList<>();
        int curr=V;
        while (parentPointers[curr]!=1){
            ans.add(0,parentPointers[curr]);
            curr=parentPointers[curr];
        }


        return ans;
    }

}
