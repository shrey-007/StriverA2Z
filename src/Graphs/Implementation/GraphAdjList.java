package Graphs.Implementation;

import java.util.LinkedList;

public class GraphAdjList {
    private LinkedList<Integer>[] adjLists;
    private int numVertices;

    // Initialize the list
    public GraphAdjList(int numVertices) {
        this.numVertices = numVertices;
        adjLists = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // Add edge
    public void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        adjLists[dest].add(src); // For undirected graph
    }

    // Print the adjacency list
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (Integer node : adjLists[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphAdjList g = new GraphAdjList(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printGraph();
    }
}

