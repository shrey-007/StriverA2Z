package DP.Rectangle;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * */
public class CountSquareSubmatriceswithAllOnes {

    /**
     * Brute Force Approach:
     * <p>
     * Traverse every element of the matrix.
     * For every element, check if it can be the top-left corner of a square submatrix.
     * For each possible size of the square (starting from 1x1), check if all the elements in that square submatrix are 1s.
     * If they are, increment the count.
     */

    public int countSquares2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        // Traverse every element as the top-left corner
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Consider every possible square size
                int maxSquareSize = Math.min(rows - i, cols - j);
                for (int size = 1; size <= maxSquareSize; size++) {
                    boolean isSquare = true;
                    // Check if this square has all 1s
                    for (int p = 0; p < size; p++) {
                        for (int q = 0; q < size; q++) {
                            if (matrix[i + p][j + q] != 1) {
                                isSquare = false;
                                break;
                            }
                        }
                        if (!isSquare) break;
                    }
                    if (isSquare) {
                        count++; // Increment count if the square is valid
                    }
                }
            }
        }

        return count;
    }

    // There are only few do on rectangles problem
    // try to create similar size dp array
    // We will not use recursion here as it will not be intuitive, we will use tabulation


    public int countSquares(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        // create same size dp array
        int[][] dp = new int[rows][cols];  // dp[i][j] contains number of squares with bottom right corner (i,j)

        // It is simple recursion if there are x squares with bottom right corner (i-1,j),
        // y squares with bottom right corner (i-1,j-1), z squares with bottom right corner (i,j-1)
        // Then number of squares with bottom right corner (i,j) will be min(x,y,z)+1


        // first row and first col of matrix and dp will be same
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


