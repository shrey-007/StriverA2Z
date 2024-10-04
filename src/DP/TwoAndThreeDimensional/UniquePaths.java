package DP.TwoAndThreeDimensional;

public class UniquePaths {
    /**
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
     * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either
     * down or right at any point in time.
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
     * bottom-right corner.
     */

    /**
     * Since we have to find all possible ways to go there, toh question mai hi diya hai ki recursion DP use krna hai
     * */
    public int uniquePaths(int m, int n) {
        return recursion(0,0,m,n);
    }
    public int recursion(int row,int col,int m,int n){
        if(row==m-1 && col==n-1){
            // positive base case pr 1 return krte hai counting problems mai
            return 1;
        }
        else if(row==m-1){return recursion(row,col+1,m,n);}
        else if(col==n-1){return recursion(row+1,col,m,n);}
        int faith1=recursion(row+1,col,m,n);
        int faith2=recursion(row,col+1,m,n);
        return faith2+faith1;
    }

    // memoization
    // Isme row and col both change ho rhe hai toh dp array 2D hoga
    public int recursion(int row,int col,int m,int n,int dp[][]){
        if(row==m-1 && col==n-1){
            // positive base case pr 1 return krte hai counting problems mai
            return 1;
        }
        if(dp[row][col]!=-1){return dp[row][col];}
        else if(row==m-1){return recursion(row,col+1,m,n,dp);}
        else if(col==n-1){return recursion(row+1,col,m,n,dp);}
        int faith1=recursion(row+1,col,m,n,dp);
        int faith2=recursion(row,col+1,m,n,dp);
        dp[row][col]=faith2+faith1;
        return faith2+faith1;
    }

    // tabulation
    public int tabulation(int m,int n){
        // initialise dp array
        int dp[][]=new int[m][n];

        // fill answer of base cases
        dp[m-1][n-1]=1;            // (m-1,n-1) se (m-1,n-1) jaane ka ek hi way hai

        // fill remaining
        for (int row = m-1; row >= 0; row--) {
            for (int col = n-1; col >= 0; col--) {
                if(row==m-1 && col==n-1){continue;}
                int faith1=0;
                int faith2=0;
                if(row+1<m){faith1=dp[row+1][col];}
                if(col+1<n){faith2=dp[row][col+1];}
                dp[row][col]=faith2+faith1;
            }
        }

        return dp[0][0];
    }



}
