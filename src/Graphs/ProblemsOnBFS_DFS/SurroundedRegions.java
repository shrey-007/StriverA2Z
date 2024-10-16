package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class SurroundedRegions {

    /**
     * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
     *
     * Connect: A cell is connected to adjacent cells horizontally or vertically.
     * Region: To form a region connect every 'O' cell.
     * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the
     * region cells are on the edge of the board.
     * A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
     * */

    /**
     * Basically question ye hai ki jo bhi zeroes se l,r,u,d jaane par matrix ke bahar nikal skte hai voh zeroes ko
     * zero hi rehne do and remaining zeroes ko X banado.
     * Apan agar matrix ki edges vale zero se start kre and l,r,u,d jaaye toh apan ko voh saare zeroes milege jaha se
     * matrix se bahar jaa skte hai. we will mark them as *.
     * Apan ko voh O ni milege jo bahar nhi jaa skte apan ko voh O milege jinse bahar jaa skte hai isliye * mark kra
     * Then Now jo * mark hai unhe O banao and jo O mark hai unhe X banao*/
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        int visited[][] = new int[n][m];

        Queue<Cell> queue = new ArrayDeque<>();


        // put all the 0 which are in the edge of board into matrix
        for (int row = 0; row <n ; row++) {
            if(board[row][0]=='O'){
                queue.offer(new Cell(row,0));
                visited[row][0]=1;
                board[row][0]='*';
            }
            if(board[row][m-1]=='O'){
                queue.offer(new Cell(row,m-1));
                visited[row][m-1]=1;
                board[row][m-1]='*';
            }
        }

        for (int col = 0; col < m; col++) {
            if(board[0][col]=='O'){
                queue.offer(new Cell(0,col));
                visited[0][col]=1;
                board[0][col]='*';
            }
            if(board[n-1][col]=='O'){
                queue.offer(new Cell(n-1,col));
                visited[n-1][col]=1;
                board[n-1][col]='*';
            }
        }



        while (!queue.isEmpty()){
            Cell cell = queue.poll();

            //visit all its unvisited neighbours which are O
            int row[]={-1,1,0,0};
            int col[]={0,0,-1,1};
            for (int i = 0; i < 4; i++) {
                int xCordinate = cell.x+row[i];
                int yCordinate = cell.y+col[i];

                if(xCordinate<n && yCordinate<m && xCordinate>=0 && yCordinate>=0 && board[xCordinate][yCordinate]=='O' && visited[xCordinate][yCordinate]==0){
                    queue.offer(new Cell(xCordinate,yCordinate));
                    visited[xCordinate][yCordinate]=1;
                    // mark it *, means ki ye voh O hai jo edge se connected hai, toh inhe X mark nhi krna inhe O hi rehne dena
                    // hai remaining O ko X mark mark krna hai, but apne paas remaining O nhi milege apan ko voh O milege jinko
                    // X mark nhi krna toh unhe * mark krdo
                    board[xCordinate][yCordinate]='*';
                }
            }
        }

        // now those who are marked as * unko O hi banado, and remaining O ko X bana do
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='*'){board[i][j]='O';}
                else if(board[i][j]=='O'){board[i][j]='X';}
            }
        }

        // but ye krne se jo edge vaale O the voh X mark ho gye toh unhe bhi * mark krdo

    }



    class Cell{
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
