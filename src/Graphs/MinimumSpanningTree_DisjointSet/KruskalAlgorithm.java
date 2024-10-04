package Graphs.MinimumSpanningTree_DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    // Here we don't use adjacency ist, instead we use edges
    // So we hae to convert the adjacency list to the edges
    // Function to find the weight of the Minimum Spanning Tree (MST)
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // List to store all the edges of the graph
        List<Edge> edges = new ArrayList<Edge>();

        // O(N + E) complexity to extract all edges from the adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0); // Adjacent node
                int wt = adj.get(i).get(j).get(1); // Weight of the edge
                int node = i; // Current node
                Edge temp = new Edge(i, adjNode, wt); // Create a new edge
                edges.add(temp); // Add the edge to the list
            }
        }

        // Initialize Disjoint Set for union-find operations
        DisjointSet ds = new DisjointSet(V);
        // Sort edges based on their weight
        // M log M complexity where M is the number of edges
        Collections.sort(edges);

        int mstWt = 0; // Variable to store the weight of the MST
        // Iterate over all the edges
        // Complexity: M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight; // Weight of the current edge
            int u = edges.get(i).src; // Source vertex of the edge
            int v = edges.get(i).dest; // Destination vertex of the edge

            // Check if the current edge forms a cycle
            if (ds.findUPar(u) != ds.findUPar(v)) {
                mstWt += wt; // Add the weight of the edge to the MST
                ds.unionByRank(u, v); // Union the sets containing u and v
            }
        }

        return mstWt; // Return the weight of the MST
    }

}

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight; // Source vertex, destination vertex, and weight of the edge

    // Constructor to initialize an edge
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }

    // Comparator function used for sorting edges based on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};


