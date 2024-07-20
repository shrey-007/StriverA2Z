package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {
    /**
     * You are given an m x n grid where each cell can have one of three values:
     *
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible,
     * return -1.
     * */

    /**
     * 1) Since ek node apne neighbours ko rotten krti hai toh BFS se traversal krege
     * 2) This time visited array will be a 2d matrix, coz grid jo hai vo nodes represent kr rhi hai adj matrix nhi hai voh
     * */

    /**
     * 1) Vese BFS mai starting node ko intially queue mai rakhte hai , but yaha saare initially rooten oranges ko rakhege*/
    public int orangesRotting(int[][] grid) {

        int visited[][]=new int[grid.length][grid[0].length];
        Queue<Cell> queue=new ArrayDeque<>();
        int numberOfFreshOranges=0;

        // traverse all cells of grid and find initial rotted oranges, and put them in the queue(bfs) and mark them as visited
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    visited[i][j]=1;
                    queue.offer(new Cell(i,j,0));
                }
                else if(grid[i][j]==1){
                    numberOfFreshOranges++;
                }
            }
        }

        int time=0;

        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {

            }
            // pop the first cell
            Cell cell=queue.poll();
            time= Math.max(time,cell.rottenTime);

            // add, its neighbours if they are fresh and not visited, and increase the time by one for its neighbours
            // Also neighbours grid se bahar nhi jaana chaiye. And mark them as visited
            // there are only 4 neighbours
            int row[]={1,-1,0,0};
            int col[]={0,0,1,-1};

            for (int i = 0; i < 4; i++) {
                int neighbour_X_Cordinate=cell.x+row[i];
                int neighbour_Y_Cordinate=cell.y+col[i];
                if(neighbour_X_Cordinate>=0 && neighbour_X_Cordinate<grid.length && neighbour_Y_Cordinate>=0 && neighbour_Y_Cordinate<grid[0].length && grid[neighbour_X_Cordinate][neighbour_Y_Cordinate]==1 && visited[neighbour_X_Cordinate][neighbour_Y_Cordinate]!=1){
                    numberOfFreshOranges--;
                    visited[neighbour_X_Cordinate][neighbour_Y_Cordinate]=1;
                    queue.offer(new Cell(neighbour_X_Cordinate,neighbour_Y_Cordinate, cell.rottenTime+1));
                }
            }



        }

        if(numberOfFreshOranges!=0){return -1;}
        else{return time;}

    }

}

class Cell{
    int x;
    int y;
    int rottenTime;

    public Cell(int x, int y, int rottenTime) {
        this.x = x;
        this.y = y;
        this.rottenTime = rottenTime;
    }
}
