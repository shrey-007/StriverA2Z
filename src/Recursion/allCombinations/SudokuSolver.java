package Recursion.allCombinations;

public class SudokuSolver {

    /**
     * Level-: cell ek ek krke visit krege(ye parameter mai hoge)
     * Options-: 1 to 9 kya put kre us cell mai(ye options mai hoge)
     * */
    public void func(int row,int col,char [][] board,int n,char ans[][]){
        if(row==n){
            // save the answer
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    ans[i][j]=board[i][j];
                }
            }
            return;
        }

        if(board[row][col]!='.'){
            // so it is already filled(as given in question) don't do anything, go to next cell
            if(col==n-1){func(row+1,0,board,n,ans);}
            else{func(row,col+1,board,n,ans);}
        }

        // try options on this cell
        for (char value = '1'; value <= '9'; value++) {
            if(isValid(row,col,board,n,value)){

                // cell mai value daalo
                board[row][col]=value;

                // ab next level(cell) pr call kro
                if(col==n-1){func(row+1,0,board,n,ans);}
                else{func(row,col+1,board,n,ans);}

                // Backtrack
                board[row][col]='.';
            }
        }
    }

    public boolean isValid(int row,int col,char [][] board,int n,char value){

        for (int i = 0; i < 9; i++) {
            if(board[i][col]==value){return false;}
            if(board[row][i]==value){return false;}
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==value){return false;}
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        char ans[][]=new char[board.length][board.length];
        func(0,0,board,9,ans);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j]=ans[i][j];
            }
        }
    }
}
