package Graphs.MinimumSpanningTree_DisjointSet;

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        // first create components of 1
        // now check if i make one cell 1, then how many components get connected to it
        // so due to change in one cell, whole graph will change, so it a dynamic graph, so it is DSU question

        // now for DSU , you have to mark nodes. node value = row * m + col
        int n = grid.length;
        int m = grid[0].length;

        DisjointSet disjointSet = new DisjointSet(n*m);

        // make components
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // if this is 0, then it is not a component
                if(grid[i][j]==0) continue;
                else{
                    // if this is 1, then connect it to all 4 neighbours who are 1
                    int dx[] = {-1,1,0,0};
                    int dy[] = {0,0,1,-1};

                    for(int k=0;k<4;k++){
                        int newRow = i+dx[k];
                        int newCol = j+dy[k];

                        if(newRow>=0 && newCol>=0 && newCol<n && newCol<m && grid[newRow][newCol]==1){
                            int currentNode = i*m+j;
                            int neighbourNode = newRow*m+newCol;
                            disjointSet.unionByRank(currentNode,neighbourNode);
                        }
                    }
                }
            }
        }

        // so the graph has now components, unfortunately you need to use union by size DSU, union by rank won't work here
        // because we need the size of each component
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    // if we make this 1, then it has 4 neighbours, find there 4 ultimate parent, then it will carry size
                    // of the component
                }
            }
        }

        return 0;
    }
}
