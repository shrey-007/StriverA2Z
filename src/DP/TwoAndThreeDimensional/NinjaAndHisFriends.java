package DP.TwoAndThreeDimensional;

public class NinjaAndHisFriends {
    /**
     * 1. Tum pehle Robot1 ke chocolates nikaal lo, fir Robot2 ke nikaalo fir dono ko sum up krdo toh ese nhi kr skte kuiki
     * esa krne mai jo common cells hai jo dono robot ne visit kre unki chocolates ek hi baar count hogi toh fir hume
     * dono ka path trace krna padega fir common cells nikaalne padege fir unhe ans se subtract krna padega
     *
     * 2. Since 2 robots hai toh 4 parameters(r1,c1,r2,c2) hoge for denoting their current row, col. But since dono robot
     * same row mai hoge ek time par, bas column different hoge toh (row,c1,c2) will be parameters.
     *
     * */
    public int solve(int n, int m, int grid[][]) {
        return func(grid,0,0,m-1,n,m);
    }
    public int func(int grid[][],int row,int c1,int c2,int n,int m){
        // positive base case
        if(row==n){return 0;}
        // negative base case
        if(c1<0 || c2<0 || c1>=m || c2>=m){return Integer.MIN_VALUE;}

        // explore all paths
        int col[]={-1,0,1};
        int ans=Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value=0;
                if(c1==c2){value=grid[row][c1];}
                else{value=grid[row][c1]+grid[row][c2];}
                value=value+func(grid,row+1,c1+i,c2+j,n,m);
                ans=Math.max(ans,value);
            }
        }

        return ans;
    }


    // memoization
    public int memoization(int grid[][],int row,int c1,int c2,int n,int m,int dp[][][]){
        // positive base case
        if(row==n){return 0;}
        // negative base case
        if(c1<0 || c2<0 || c1>=m || c2>=m){return Integer.MIN_VALUE;}
        if(dp[row][c1][c2]!=-1){return dp[row][c1][c2];}

        // explore all paths
        int col[]={-1,0,1};
        int ans=Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value=0;
                if(c1==c2){value=grid[row][c1];}
                else{value=grid[row][c1]+grid[row][c2];}
                value=value+memoization(grid,row+1,c1+i,c2+j,n,m,dp);
                ans=Math.max(ans,value);
            }
        }

        dp[row][c1][c2]=ans;

        return ans;
    }

}
