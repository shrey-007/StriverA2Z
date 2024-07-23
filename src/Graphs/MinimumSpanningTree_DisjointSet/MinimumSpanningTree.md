1. You will be given undirected weighted graph, which contains N nodes and M edges.
2. Spanning Tree is a tree in which we have N nodes and N-1 edges and nodes are reachable from each other.
3. All Tree has N nodes ans N-1 edges, and all nodes are reachable ina tree
4. There can be multiple Spanning Trees of a graph.
5. We have to find Minimum Spanning Tree(A Spanning Tree with minimum sum of all its edge weighs)
6. Prims and Kruskal are used to find MST
7. Prims-:  
   Dekho har node kabhi na kabhi connect toh hogi hi toh Prims start with any node.Us node se smallest edge lega and use answr mai include krega.Fir us node and new connected node ki smallest edge lega and answer mai include krega and so on...  
   Means Simply Prims initially selects the smallest one and afterwards it selects the connected smallest one.
8. Kruskal-:  
   Kruskal always selects the minimum cost edge, but if it forms cycle then don't include it. How does it know whether including the current edge will form a cycle or not, so it uses Disjoint Set Data Structure for it.