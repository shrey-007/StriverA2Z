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
                return curr.height;
            }

            for (int i = 0; i < 4; i++) {
                int neighbourX = curr.x + row[i];
                int neighbourY = curr.y + col[i];

                if (neighbourX >= 0 && neighbourX < n && neighbourY >= 0 && neighbourY < m) {
                    int currentEffort = Math.max(curr.height, Math.abs(heights[curr.x][curr.y] - heights[neighbourX][neighbourY]));

                    if (currentEffort < dist[neighbourX][neighbourY]) {
                        dist[neighbourX][neighbourY] = currentEffort;
                        priorityQueue.add(new CellWithHeight(neighbourX, neighbourY, currentEffort));
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }

}

class CellWithHeight implements Comparable<CellWithHeight>{
    int x;
    int y;
    int height; // It is not height of current cel. Is cell tak pahuchne mai maximum adjacent height difference kitna hai(i.e minimum effort)
               // and yahi cheej distance matrix mai store hogi

    public CellWithHeight(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    public int compareTo(CellWithHeight o) {
        return this.height-o.height;
    }
}
