package DP.TwoAndThreeDimensional;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return func(0,0,grid);
    }
    public int func(int row,int col,int[][] grid){
        if(row==grid.length-1 && col==grid[0].length-1){return grid[row][col];}
        if(row==grid.length-1){return func(row,col+1,grid)+grid[row][col];}
        if(col==grid[0].length-1){return func(row+1,col,grid)+grid[row][col];}

        int faith1=func(row+1,col,grid);
        int faith2=func(row,col+1,grid);

        return Math.min(faith1,faith2)+grid[row][col];
    }

    public int memoization(int row,int col,int[][] grid,int dp[][]){
        if(row==grid.length-1 && col==grid[0].length-1){return grid[row][col];}
        if(dp[row][col]!=-1){return dp[row][col];}
        if(row==grid.length-1){return memoization(row,col+1,grid,dp)+grid[row][col];}
        if(col==grid[0].length-1){return memoization(row+1,col,grid,dp)+grid[row][col];}

        int faith1=memoization(row+1,col,grid,dp);
        int faith2=memoization(row,col+1,grid,dp);

        dp[row][col]=Math.min(faith1,faith2)+grid[row][col];

        return dp[row][col];
    }

    public int tabulation(int grid[][]){
        int n=grid.length;
        int m=grid[0].length;

        int dp[][]=new int[n][m];

        dp[n-1][m-1]=grid[n-1][m-1];

        for (int row = n-1; row >=0; row--) {
            for (int col = m-1; col >=0 ; col--) {
                int faith1=Integer.MAX_VALUE;
                int faith2=Integer.MAX_VALUE;

                if(row+1<n){faith1=dp[row+1][col];}
                if(col+1<n){faith2=dp[row][col+1];}

                dp[row][col]=Math.min(faith1,faith2);
            }
        }

        return dp[0][0];
    }
}
