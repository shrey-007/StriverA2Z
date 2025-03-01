package Graphs.MinimumSpanningTree_DisjointSet;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn {
     /**
     * <p>Let’s first understand the thought process that we will be using to solve this problem. In this problem, it is clearly stated that a stone can be removed if it shares either the same row or the same column as another stone that has not been removed. So, we can assume that these types of stones, sharing either the same row or column, are connected and belong to the same group</p>
     * <p>If we carefully observe, for each group we can remove all the stones leaving one stone intact. So, we can conclude that at most we can remove (size of the group -1) no. of stones from a group as we need to leave one stone untouched for each group.</p>
     * <p>In order to connect the cells we will assume that each entire row and column of the 2D plane is a particular node. Now, with each row, we will connect the column no.s in which the stones are located. But column no. may be the same as the row number. To avoid this, we will convert each column no. to (column no. + total no. of rows) and perform the union of row no. and the converted column number i.e. (column no. + total no. of rows) like the following:For the above example, to connect the two stones in the cells [0, 0] and [0, 2] of the first row, we will first take row no. i.e. 0(because of 0-based indexing) as a node and then convert column no.s 0 to (0+5) and 2 to (2+5). Then, we will perform the union of (0 and 5) and (0 and 7).Thus we will connect all the stones that are either in the same row or in the same column to form different connected components.</p>
     * <h2>Approach-:</h2>
     * <p>First, from the stone information, we will find out the maximum row and the maximum column number so that we can get an idea about the size of the 2D plane(i.e. nothing but a matrix).</p>
     * <p>Then, we need to create a disjoint set of sizes (maximum row index+maximum column index). For safety, we may take a size one more than required.</p>
     * <p>Now it’s time to connect the cells having a stone. For that we will loop through the given cell information array and for each cell we will extract the row and the column number and do the following:
     * First, we will convert column no. to (column no. + maximum row index +1).
     * We will perform the union(either unionBySize() or unionByRank()) of the row number and the converted column number.
     * We will store the row and the converted column number in a map data structure for later use.</p>
     * <p>Now, it’s time to calculate the number of components and for that, we will count the number of ultimate parents. Here we will refer to the previously created map.
     * We just need the nodes in the Disjoint Set that are involved in having a stone. So we have stored the rows and the columns in a map in step 3.3, as they will have stones. Now we just need to check them from the map data structure once for getting the number of ultimate parents</p>
     * <p>Finally, we will subtract the no. of components(i.e. no. of ultimate parents) from the total no. of stones and we will get our answer.</p>
     * <p></p><p></p><p></p><p></p>
     *
     *
     * */
    public int removeStones(int[][] stones) {
        int n=stones.length;

//        maxRow and maxCol are initialized to find the maximum row and column indices among all stones.
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionByRank(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;

    }
}
