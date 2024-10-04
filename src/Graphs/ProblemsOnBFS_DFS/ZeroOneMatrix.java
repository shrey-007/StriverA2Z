package Graphs.ProblemsOnBFS_DFS;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 * */

/** Why this is a graph problem?
 *  Kiuki dekho apan ko har cell se nearest 0 nikaalna tha , toh tum uper neeche right left dekh lete ki 0 hai toh
 *  update kr dete but agar nhi hota toh use aur aage jaana padta. Toh vo aage kese jaate , uske bahut ajeeb traversal
 *  krna padta, simply traversal mai tumhe pehle vo nodes travel krni hai jo 1 unit door hai , fir jo 2 unit door hai
 *  and so on, and ye traversal normally matrix se nhi hota, vo tabhi hota jab tum matrix ke har cell ko as a node
 *  of graph treat kro and unme BFS lagao.
 *
 * */

import java.util.ArrayDeque;
import java.util.Queue;

/** 1) It will be solved with BFS only, kiuki nearest distance jaakr check krna hai pehle ki vo 0 hai ki nhi. BFS
 *     first goes to all nearest nodes then it goes deeper
 *  2) Brute force can be ki har cell jiski value 1 hai uspr pr jaao and us pr bfs lagao and find kro ki konsa 0 value vaala cell nearest hai
 *  3) Optimal approach could be same as rotten oranges, toh jo bhi 0 hai un sab ko queue mai daalo as starting point
 *  */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {

        int visited[][]=new int[mat.length][mat[0].length];
        int ans[][]=new int[mat.length][mat[0].length];

        Queue<Cell2> queue=new ArrayDeque<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==0){
                    visited[i][j]=1;
                    // ye khud hi zero hai toh isa distance nearest 0 se 0 hi hoga
                    queue.offer(new Cell2(i,j,0));
                }
            }
        }

        while (!queue.isEmpty()){

            Cell2 cell=queue.poll();

            // update the answer
            ans[cell.x][cell.y]=cell.distance;

            // visit all its 4 neighbours, if they are not visited
            int row[]={-1,1,0,0};
            int col[]={0,0,-1,1};
            for (int i = 0; i < 4; i++) {
                int X_CordinateOfNeighbour=cell.x+row[i];
                int Y_CordinateOfNeighbour=cell.y+col[i];

                if(X_CordinateOfNeighbour>=0 && X_CordinateOfNeighbour<mat.length && Y_CordinateOfNeighbour>=0 && Y_CordinateOfNeighbour<mat[0].length && visited[X_CordinateOfNeighbour][Y_CordinateOfNeighbour]==0){
                    visited[X_CordinateOfNeighbour][Y_CordinateOfNeighbour]=1;
                    queue.offer(new Cell2(X_CordinateOfNeighbour,Y_CordinateOfNeighbour,cell.distance+1));
                }
            }
        }

        return ans;
    }
}

class Cell2{
    int x;
    int y;
    int distance; // distance from nearest 0

    public Cell2(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
