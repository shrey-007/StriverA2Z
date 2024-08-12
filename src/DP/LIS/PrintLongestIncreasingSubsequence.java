package DP.LIS;

import java.util.Arrays;

public class PrintLongestIncreasingSubsequence {
    // The memoization code for LIS using previous index is
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }

        return func(nums,0,-1,dp);
    }
    // dp mai previousIndex+1 use kro and arr mai previousIndex use kro

    public int func(int arr[],int index,int previousIndex,int dp[][]){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][previousIndex+1]!=-1){return dp[index][previousIndex+1];}

        // take, and increase number of characters by 1
        int faith1=Integer.MIN_VALUE;
        if(previousIndex==-1 || arr[previousIndex]<arr[index]){
            faith1=func(arr,index+1,index,dp)+1;
        }

        // not take
        int faith2=func(arr,index+1,previousIndex,dp);

        dp[index][previousIndex+1]=Math.max(faith2,faith1);

        return dp[index][previousIndex+1];
    }


    // tabulation
    public int tabulation(int[] nums){
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];

        // fill the base cases
        for (int i = 0; i <=n ; i++) {
            dp[n][i]=0;
        }

        // fill the dp table
        for (int index = n-1; index>=0; index--) {
            // as the name suggests previousIndex peeche ka index hoga index ka toh vo n-1 se nhi index -1 se start hoga
            for (int previousIndex = index-1; previousIndex >=-1; previousIndex--) {
                // not take
                int faith1=dp[index+1][previousIndex+1];

                // take
                int faith2=Integer.MIN_VALUE;
                if(previousIndex==-1 || nums[previousIndex]<nums[index]){faith2=dp[index+1][index+1]+1;}

                dp[index][previousIndex]=Math.max(faith2,faith1);
            }
        }

        return dp[0][0];
    }

    // To print the LIS, we will use hashmap, watch DP 42 for that



}
