package Graphs.ShortestPath;

import java.util.PriorityQueue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and
 * you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or
 * right, and you wish to find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell*/
public class PathWithMinimumEffort {
    // This is similar to ShortestPathInBinaryMatrix
    /**
     * Concept-:
     * 1) dist[i][j] represents the minimum effort required to travel from the top-left cell (0, 0) to the cell (i, j)
     * */
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<CellWithHeight> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new CellWithHeight(0, 0, 0));
        dist[0][0] = 0;

        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, 1, -1};

        while (!priorityQueue.isEmpty()) {
            CellWithHeight curr = priorityQueue.poll();

            if (curr.x == n - 1 && curr.y == m - 1) {
                return curr.effortToReachThisCell;
            }

            for (int i = 0; i < 4; i++) {
                int neighbourX = curr.x + row[i];
                int neighbourY = curr.y + col[i];

                if (neighbourX >= 0 && neighbourX < n && neighbourY >= 0 && neighbourY < m) {
                    int currentEffort = Math.max(curr.effortToReachThisCell, Math.abs(heights[curr.x][curr.y] - heights[neighbourX][neighbourY]));

                    if (currentEffort < dist[neighbourX][neighbourY]) {
                        dist[neighbourX][neighbourY] = currentEffort;
                        priorityQueue.add(new CellWithHeight(neighbourX, neighbourY, currentEffort));
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }

    // This question can also be solved using normal recursion, use dp to improve efficiency
    public int func(int [][] heights, int row,int col,int visited[][]){
        if(row==heights.length-1 && col==heights[0].length-1){return 0;}
        // try all possible ways
        int[] r = {1, -1, 0, 0};
        int[] c = {0, 0, 1, -1};

        int ans=(int)1e9;

        for (int i = 0; i < 4; i++) {
            int neighbourX=row+r[i];
            int neighbourY=col+c[i];

            if(neighbourX>=0 && neighbourY>=0 &&
               neighbourX<heights.length && neighbourY<heights[0].length &&
               visited[neighbourX][neighbourY]==0){
                    visited[neighbourX][neighbourY]=1;
                    ans=Math.min(ans,Math.max(Math.abs(heights[row][col]-heights[neighbourX][neighbourY]),func(heights,neighbourX,neighbourY,visited)));
                    visited[neighbourX][neighbourY]=0;
            }

        }
        return ans;
    }

}

class CellWithHeight implements Comparable<CellWithHeight>{
    int x;
    int y;
    int effortToReachThisCell; // It is not height of current cel. Is cell tak pahuchne mai maximum adjacent height difference kitna hai(i.e minimum effort)
               // and yahi cheej distance matrix mai store hogi

    public CellWithHeight(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.effortToReachThisCell = height;
    }

    @Override
    public int compareTo(CellWithHeight o) {
        return this.effortToReachThisCell-o.effortToReachThisCell;
    }
}
