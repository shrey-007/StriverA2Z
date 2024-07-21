package Graphs.ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

import java.util.PriorityQueue;

/**\
 Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear
 path, return -1.

 A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
 (i.e., (n - 1, n - 1)) such that:

 All the visited cells of the path are 0.
 All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 The length of a clear path is the number of visited cells of this path\*/
public class ShortestPathInBinaryMatrix {
    /**
     * BFS with distance array is Dijkstra
     * */
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Check if the starting or ending cell is blocked(agar starting hi blocked hai i.e 1 hai toh aage ja hi nhi paaege)
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }

        // Direction vectors for 8 possible moves (up, down, left, right, and 4 diagonals)
        int[] row = {1, -1, 0, 0, -1, -1, 1, 1};
        int[] col = {0, 0, 1, -1, -1, 1, -1, 1};

        PriorityQueue<CellWithDistance> priorityQueue = new PriorityQueue<>();
        int[][] dist = new int[n][n];

        // Initialize the distance array with a large value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Starting cell
        dist[0][0] = 1;  // distance to start is 1 because we include the starting cell
        priorityQueue.add(new CellWithDistance(0, 0, 1));

        while (!priorityQueue.isEmpty()) {
            CellWithDistance curr = priorityQueue.poll();
            int currX = curr.x;
            int currY = curr.y;
            int currDist = curr.distance;

            // If we reached the destination cell, return the distance
            if (currX == n - 1 && currY == n - 1) {
                return currDist;
            }

            // Visit its neighbours, only when it is a valid cell, and cell is not blocked(it is having 0 value) and
            // distance to reach that cell is smaller than previously mentioned in distance array
            for (int i = 0; i < 8; i++) {
                int neighbourX = currX + row[i];
                int neighbourY = currY + col[i];

                if (neighbourX >= 0 && neighbourX < n && neighbourY >= 0 && neighbourY < n &&
                        grid[neighbourX][neighbourY] == 0 && currDist + 1 < dist[neighbourX][neighbourY]) {

                    dist[neighbourX][neighbourY] = currDist + 1;
                    priorityQueue.add(new CellWithDistance(neighbourX, neighbourY, currDist + 1));
                }
            }
        }

        // If we reach here, the destination cell is not reachable
        return -1;
    }

    class CellWithDistance implements Comparable<CellWithDistance> {
        int x;
        int y;
        int distance;

        public CellWithDistance(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(CellWithDistance o) {
            return this.distance - o.distance;
        }
    }
}
