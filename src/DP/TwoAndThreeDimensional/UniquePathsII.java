package DP.TwoAndThreeDimensional;

import java.util.Arrays;

/** Path with obstacle*/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            Arrays.fill(dp[i],-1);
        }

        return memoization(0,0,obstacleGrid,dp);
    }
    public int recursion(int row,int col,int[][] obstacleGrid){
        // positive base case
        if(row==obstacleGrid.length && col==obstacleGrid[0].length){return 1;}
        // negative base case
        if(obstacleGrid[row][col]==1){return 0;}

        if(row==obstacleGrid.length){return recursion(row,col+1,obstacleGrid);}
        if(col==obstacleGrid[0].length){return recursion(row+1,col,obstacleGrid);}


        int faith1=recursion(row+1,col,obstacleGrid);
        int faith2=recursion(row,col+1,obstacleGrid);

        return faith2+faith1;
    }
    public int memoization(int row,int col,int[][] obstacleGrid,int dp[][]){
        // positive base case
        if(row==obstacleGrid.length-1 && col==obstacleGrid[0].length-1){return 1;}
        // negative base case
        if(obstacleGrid[row][col]==1){return 0;}

        if(row==obstacleGrid.length-1){return memoization(row,col+1,obstacleGrid,dp);}
        if(col==obstacleGrid[0].length-1){return memoization(row+1,col,obstacleGrid,dp);}


        if(dp[row][col]!=-1){return dp[row][col];}


        int faith1=memoization(row+1,col,obstacleGrid,dp);
        int faith2=memoization(row,col+1,obstacleGrid,dp);

        dp[row][col]=faith1+faith2;

        return faith2+faith1;
    }

    public int tabulation(int[][] obstacleGrid){
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;

        int dp[][]=new int[n][m];

        dp[n-1][m-1]=1;


        for (int row = n-1; row >=0 ; row--) {
            for (int col = m-1; col >=0 ; col--) {
                if(row==n-1 && col==m-1){continue;}

                int faith1=0;
                int faith2=0;

                if(row+1<n) faith1=dp[row+1][col];
                if(col+1<m) faith1=dp[row][col+1];

                dp[row][col]=faith1+faith2;
            }
        }

        return dp[0][0];
    }


}
