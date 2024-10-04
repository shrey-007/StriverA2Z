package Graphs.MinimumSpanningTree_DisjointSet;

import java.util.ArrayList;

/**
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where
 * connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other
 * computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract certain cables between two directly connected
 * computers, and place them between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not
 * possible, return -1.
 * */
public class NumberOfOperationsToMakeNetworkConnected {
    /**
     * 1) It is same as -: Given a graph with different components, find number of operations to make the graph connected
     * 2) Also it is unweighted graph toh kisi ek component ki kisi bhi node ko doosre component ki kisi bhi node se connect kr skte hai
     * 3) For k components i would require k-1 edges to make it connected, so i just need to find number of components which we had already solved.
     * 4) Problem is ki hum directly new edge banakr connect nhi kr skte hume , kisi component ki extra edge ko hi use krke bnana hai, such that if us component se vo edge hata di fir bhi vo component break nhi hua.
     * 5) So we have to count number of extra edges.*/

    // My Method
    public int makeConnected(int n, int[][] connections) {

        // You can not do dfs traversal using edges, you have to use adjacency list
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int u=connections[i][0];
            int v=connections[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }


        int numberOfComponents=0;
        int numberOfEdgesRequired=0;

        int visited[]=new int[n];

        // this section finds total components and total nodes in a component
        // Suppose there are 3 components A,B,C
        // Now let number of nodes in component A = numberOfNodesInAParticularComponent[0]=n1
        // Toh A mai minimum n1-1 edges honi chaiye but agar usse jyaada hai toh vo extra edges hai toh numberOfEdgesRequired=n1-1
        // Similarly let B mai n2 nodes hai toh total edges required numberOfEdgesRequired=n1-1+n2-1
        // Similarly for 3 numberOfEdgesRequired=n1-1+n2-1+n3-1
        // Toh poore graph mai itne edges hone chaiye minimum = numberOfEdgesRequired=n1-1+n2-1+n3-1
        // lekin hai kitne = connections.length
        // toh extra edges= connections.length-numberOfEdgesRequired;
        for (int i = 0; i < n; i++) {
            int[] numberOfNodesInAParticularComponent=new int[1];
            if(visited[i]==0){
                numberOfComponents++;
                dfs(n,i,adjList,visited,numberOfNodesInAParticularComponent);
                numberOfEdgesRequired=numberOfEdgesRequired+numberOfNodesInAParticularComponent[0]-1;
            }
        }

        int numberOfExtraEdges=connections.length-numberOfEdgesRequired;

        if(numberOfComponents-1>numberOfExtraEdges){return -1;}
        return numberOfComponents-1;
    }

    public void dfs(int n,int node,ArrayList<ArrayList<Integer>> adjList,int visited[],int[] numberOfNodesInAParticularComponent){

        if(node==n){return;}

        visited[node]=1;
        numberOfNodesInAParticularComponent[0]++;

        for (int neighbour:adjList.get(node)){
            if(visited[neighbour]==0) {
                dfs(n,neighbour,adjList,visited,numberOfNodesInAParticularComponent);
            }
        }

    }
    // This above method gave 50% faster than java users
    // Method 2-: Using Disjoint Set
    // LOL ye 20% faster dikha rha hai , toh mera vaala better hai

    public int Solve(int n, int[][] edge) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = edge.length;
        // pehle toh edges ko use krke disjoint structure banalo
        for (int i = 0; i < m ; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            if (ds.findUPar(u) == ds.findUPar(v)) {
                cntExtras++;
            } else {
                ds.unionByRank(u, v);
            }
        }

        // jinka parent vo khud hai utne nmber of components hai
        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) cntC++;
        }

        int ans = cntC - 1;
        if (cntExtras >= ans) return ans;
        return -1;
    }

}
