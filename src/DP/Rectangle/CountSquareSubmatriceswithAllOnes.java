package DP.Rectangle;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * */
public class CountSquareSubmatriceswithAllOnes {

    // There are only few do on rectangles problem
    // try to create similar size dp array
    // We will not use recursion here as it will not be intuitive, we will use tabulation
    // dp[i][j] denotes how many squares end at (i,j), means how many squares have their right bottom on (i,j)


    public int countSquares(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        // create same size dp array
        int[][] dp = new int[rows][cols];  // dp[i][j] contains number of squares with bottom right corner (i,j)

        // It is simple recursion if there are x squares with bottom right corner (i-1,j),
        // y squares with bottom right corner (i-1,j-1), z squares with bottom right corner (i,j-1)
        // Then number of squares with bottom right corner (i,j) will be min(x,y,z)+1


        // first row and first col of matrix and dp will be same
        // agar matrix[i][0] is 0 toh means their is no square ending at (i,0)
        // agar matrix[i][0] is 1 , means their is only 1 square that (i,j) itself.
        for (int i = 0; i < rows; i++) {
            dp[i][0]=matrix[i][0];
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j]=matrix[0][j];
        }



        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // if current cell is not 1 then it can not form square and hence it can not be bottom right corner of
                // a square
                if(matrix[i][j]==0){dp[i][j]=0;}
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }

        // Now dp[i][j] contains ki (i,j) ko bottom right corner maano toh kitne squares banege, toh sabhi (i,j) ka
        // sum krdo
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = ans + dp[i][j];
            }
        }

        return ans;
    }

}


