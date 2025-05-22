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
     * 1) Vese BFS mai starting node ko intially queue mai rakhte hai , but yaha saare initially rooten oranges ko rakhege
     * 2) Pehle paas vaale rott hoge phir door vale hoge toh bfs lagao
     * */
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

            // pop the first cell
            Cell cell=queue.poll();

            // update the max time taken
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

/*
* Key Paints-:
* 1. Har orange sirf ek hi baar Q mai gaya, kuiki ek baar gaya toh uske baad vo visited ho gya toh firse uspe ni jaaege
* 2. 1st level pr sirf rotten oranges hoge Q mai
* 3. Fir 1st level ke baad sir fresh oranges milege Q mai.
* 4. Toh ja tak saare oranges process na ho jaye ans ni aaega
* 5. Toh there is no early condition to stop the loop
*   */

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
