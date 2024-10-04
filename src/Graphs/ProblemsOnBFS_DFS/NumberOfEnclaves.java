package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 *
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the
 * boundary of the grid.
 *
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 * */

/** This is also same as rotten oranges
 * Boundary of matrix ke jitne 1 hai unse jitne bhi 1 valued cell tak jaa skte hai voh sab answers mai nhi aaege, remaining 1 vaale aaege
 * Toh Boundary valued 1 cell  vaale rotten hai hai unhe remaining 1 ko rott krna hai jitne rott nhi hue vo ans*/
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {

        int visited[][]=new int[grid.length][grid[0].length];
        Queue<Cell3> queue=new ArrayDeque<>();

        int numberOfIslands=0;

        // add all boundary islands in queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1 && (i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1)){
                    // Ye boundary vaale islands hai toh yahi starting point hai
                    visited[i][j]=1;
                    queue.offer(new Cell3(i,j));
                }
                else if(grid[i][j]==1){
                    // count kro ki kitne Islands
                    numberOfIslands++;
                }
            }
        }

        while(!queue.isEmpty()){
            Cell3 cell= queue.poll();

            // add its neighbours
            int row[]={-1,1,0,0};
            int col[]={0,0,-1,1};
            for (int i = 0; i < 4; i++) {
                int X_CordinateOfNeighbour=cell.x+row[i];
                int Y_CordinateOfNeighbour=cell.y+col[i];

                if(X_CordinateOfNeighbour>=0 && X_CordinateOfNeighbour<grid.length && Y_CordinateOfNeighbour>=0 && Y_CordinateOfNeighbour<grid[0].length && visited[X_CordinateOfNeighbour][Y_CordinateOfNeighbour]==0 && grid[X_CordinateOfNeighbour][Y_CordinateOfNeighbour]==1){
                    visited[X_CordinateOfNeighbour][Y_CordinateOfNeighbour]=1;
                    queue.offer(new Cell3(X_CordinateOfNeighbour,Y_CordinateOfNeighbour));
                    // Hum boundary se start kre the traverse krna and mid pr aagye ek island mai, means is island se boundary
                    // tak jaane ka raasta hai toh ye hamara answer nhi hai toh ise subtract krdo
                    numberOfIslands--;
                }
            }
        }

        return numberOfIslands;

    }
}

class Cell3{
    int x;
    int y;

    public Cell3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
