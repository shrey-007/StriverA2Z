package Recursion.allCombinations;

public class WordSearch {

    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
     * vertically neighboring. The same letter cell may not be used more than once.
     * */
    public boolean exist(char[][] board, String word) {
        boolean flag = false;

        int n = board.length;
        int m = board[0].length;

        if(word.length()>n*m){return false;}

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(func(i,j,board,0,word,new int[n][m])){return true;}
            }
        }

        return false;
    }
    public boolean func(int row, int col,char[][] board,int index,String word,int [][] visited){

        if(index == word.length()){
            // means all words are found in the matrix
            return true;
        }

        // return false , if current character of word don't matches with current character of matrix
        if(board[row][col]!=word.charAt(index)){return false;}

        // if it matches the we have to check futher, whether remaining characters also matches or not
        boolean flag = false;

        int[] r = {-1,1,0,0};
        int[] c = {0,0,-1,1};

        for(int i = 0; i<4; i++){
            int nextCellX = row + r[i];
            int nextCellY = col + c[i];

            if(nextCellX>=0 && nextCellX<board.length && nextCellY>=0 && nextCellY<board[0].length && visited[nextCellX][nextCellY]==0){
                visited[nextCellX][nextCellY]=1;
                flag = flag || func(nextCellX,nextCellY,board,index+1,word,visited);
                visited[nextCellX][nextCellY]=0;
            }
        }

        // Now flag contains the answer, abhi vala string ka character board ke character se match kr rha hai
        // But agar baad vaala koi match nhi krta toh flag false hoga else true
        return flag;
    }
}
