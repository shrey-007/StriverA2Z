1. A graph should have vertices(nodes) and edges
2. A Tree is also a graph
3. Graph need not to be cyclic, acyclic bhi ho skte hai
4. There r 2 types of graph directed(jinme directed edges hoti hai), undirected(jinme undirected edges hoti hai)
5. There r two types of graphs cyclic(ek node se chale and vaapis usi pe aagye), and acyclic
6. Path-: Contains nodes and which each of them are reachable
##### For Undirected
1. Degree of a node - Number of edges that are attached to that node of undirected graph.
2. Total sum of degree of nodes in a undirected graph - 2*edges
##### For directed
1. InDegree of a node - Number of edges that are incoming to that node of directed graph.
2. OutDegree of a node - Number of edges that are outgoing to that node of directed graph.

### Traversal
1. BFS(Iterative)(done using queue) -: It is ditto same as BFS(level order) of tree, only difference is ki tree mai cycle nhi hoti toh ek node ek hi baar visit hoti hai. But graph mai cycle hoti hai toh, also ek node se doosre node mai jaane ke different paths bhi hote hai toh ek hi node ko multiple baar na answer mai rakhle isliye usme visited[] array banate hai. That's it. else everything is ditto same. Also tree mai 2 children hote the yaha arraylist mai neighbours hote hai toh saare neighbours ke liye vo kaam ko jo vaha 2 children ke liye kara hai.
2. DFS(Recursive) -: Same as DFS of Tree, farak bas visited array, and tree mai 2 children hote the yaha arraylist mai neighbours hote hai toh saare neighbours ko call krna padta hai arraylist ko traverse krke.
3. BFS mai queue mai daalte time hi visited mark kr diya kro, and DFS mai daalne ke baad jab us node par pahucho tab visited mark kro.

