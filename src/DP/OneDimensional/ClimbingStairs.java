package DP.OneDimensional;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top
 * */

/**
 * Count number of ways mai positive base case mai 1 return krte hai and negative base case mai 0 return krte hai.*/
public class ClimbingStairs {

    // simple recursion
    public int climbStairs(int n) {
        if(n==0){return 1;}
        if(n<0){return 0;}

        int faith1=climbStairs(n-1);
        int faith2=climbStairs(n-2);

        return faith2+faith1;
    }

    /**There are many repetitive calls of f(n),So we will use dp
     * In above code climbStairs(int n) denote distinct number of ways to climb to the top
     * So dp[n] will also denote same meaning
     *   */
    public int climbStairs(int n,int dp[]) {
        if(n==0){return 1;}
        if(n<0){return 0;}
        // if answer is already stored then return it
        if(dp[n]!=0){return dp[n];}
        int faith1=climbStairs(n-1);
        int faith2=climbStairs(n-2);
        // store the answer
        dp[n]=faith2+faith1;
        return faith2+faith1;
    }

}
