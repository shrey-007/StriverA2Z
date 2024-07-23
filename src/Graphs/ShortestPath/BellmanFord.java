package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    /**
     * 1) It also finds the shortest path from one source to all nodes, but unlike dijkstra it also works with negative
     *    weights
     * 2) It helps to detect negative cycle
     * */

    /**
     * Alogorithm-:
     * 1) Relax all the edges N-1 times sequentially
     *    Relax-: if(dist[u]+wt<dist[v]){dist[v]=dist[u]+wt;}
     * 2) Here you will need arraylist of edges, not the adjacency list. Means agar maanlo ek tree hai jisme root hai
     *    0 and uske left child 1 hai and right child 2 hai , both with weights 1
     *    Toh agar adjacency list hoti toh vo esi hoti {{{1,0},{2,0}}}
     *    And edges ki list kuch esi hogi {{0,1,1},{0,2,1}}
     *    Edges can be in any order
     *    */

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int [] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0; // source ka dist 0 kro

        // take n-1 relaxations(means run the loop for n-1 times)
        for (int i = 1; i <= V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // now distance array is storing the answer, and agar ek aur iteration kra tab bhi answer same hi rahega
        // But if graph contains negative cycle(A cycle in a graph jiska path sum negative ho), toh ek aur iteration
        // krne mai dist array maii changes aaege
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            // dist[u] + wt == dist[v] , esa hona chaiye but agar esa nhi hai means ki negative cycle hai
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }
    /**
     * TC is E*V , but in Dijkstra it was E*log(V)
     * */
}
