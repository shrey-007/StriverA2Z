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
                int visited[][]=new int[n][m];
                // since we are starting from (i,j) so mark it visited
                visited[i][j] = 1;
                if(func(i,j,board,0,word,visited)){return true;}
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

        // if it matches then, we have to check further, whether remaining characters also matches or not
        boolean flag = false;

        int[] r = {-1,1,0,0};
        int[] c = {0,0,-1,1};

        for(int i = 0; i<4; i++){
            int nextCellX = row + r[i];
            int nextCellY = col + c[i];

            // koi ek bhi agar true return krta hai means ki us case mai remaining string match ho rhi hai toh means answer mil gya
            // is liye flag ka or liya hai
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


class AnotherMethod{
    // This is another way to do this question ,and this is easy one
    public boolean exist(char[][] board, String word) {
        // the problem is we don't know the starting point
        int n = board.length;
        int m = board[0].length;

        // we don't know the starting point, so consider every cell as starting
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean ans = func(i,j,new int[n][m],board,n,m,word,0);
                if(ans) return true;
            }
        }

        return false;
    }

    // r,c and index are changing
    // instead of storing whole word, we just store current index. if index i, means 0 to i-1 already match kr gaya hai
    // i to n-1 match krna hai
    public boolean func(int r,int c,int visited[][],char[][] board,int n,int m,String targetWord,int index){
        if(index==targetWord.length()) return true;
        if(r<0 || c<0 || r>=n || c>=m || visited[r][c]==1) return false;

        char curr = board[r][c];
        if(curr!=targetWord.charAt(index)) return false;
        visited[r][c] = 1;

        // we can go left,up,down,right
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,1,-1};

        boolean ans = false;

        for(int i=0;i<4;i++){
            int newR = r+dx[i];
            int newC = c+dy[i];
            boolean faith = func(newR,newC,visited,board,n,m,targetWord,index+1);
            // any of the return true, then return true
            if(faith) return true;
        }

        visited[r][c] = 0;
        // none combination return true, so return false
        return false;
    }
}
