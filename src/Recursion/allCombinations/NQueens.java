package Recursion.allCombinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public void func(int n, int row, char board[][],List<List<String>> ans){
        if(row==n){
            // board[][] has the ans
            addAnswer(n,board,ans);
            return;
        }
        for (int col = 0; col < n; col++) {
            if(isSafe(n,row,col,board)){
                // if it is safe to put at (row,col), then put it
                board[row][col]='Q';
                func(n,row+1,board,ans);
                board[row][col]='.';
            }
        }
    }

    public boolean isSafe(int n,int row,int col,char[][] board){
        // check vertically upward
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // check left upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check right upper diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    public void addAnswer(int n,char [][] board,List<List<String>> ans){
        List<String> temp=new ArrayList<>();
        for (int row = 0; row < n; row++) {
            String s="";
            for (int col = 0; col < n; col++) {
                s=s+board[row][col];
            }
            temp.add(s);
        }
        ans.add(temp);
    }


    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List < List < String >> res = new ArrayList();
        func(n,0, board, res);
        return res;
    }

    public static void main(String[] args) {
        NQueens nQueens=new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
}
