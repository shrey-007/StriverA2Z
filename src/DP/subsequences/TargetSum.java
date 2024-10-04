package DP.subsequences;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
 * then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
 * expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target
 * */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return func(nums,target,0,0);
    }
    public int func(int nums[],int target,int index,int currentSum){
        if(index==nums.length){
            // positive base case
            if(target==currentSum){return 1;}
            else{return 0;}
        }
        // add it
        int faith1=func(nums,target,index+1,currentSum+nums[index]);
        // subtract it
        int faith2=func(nums,target,index+1,currentSum-nums[index]);
        return faith2+faith1;
    }

    // memoization
    /**
     * In the question , it was given -1000<=target<=1000
     * 1. Suppose target=6 hai and tumne saare elements ko subtract kr diya toh currentsum negative ho jaaega toh dp[index][currentSum]
     *    erro dega.
     * 2. Suppose target hi negative hai (let -7) toh dp array agar ese initilize kara int dp[][]=new int[n][target];   toh error aaega
     * 3. Toh simply apan ko pata hai target 2001 values le skta hai , toh utne size ka banado dp array
     * 4. -1000 index access kroge toh erro aaegi toh +1000 krke access krege sabko toh -:
     *    -1000 becomes 0
     *    0 becomes 1000
     *    1000 becomes 20000
     *    Toh 2000 index tak access krna hai toh 2001 size ka banao dp array
     *    */
    public int findTargetSumWays2(int[] nums, int target) {
        int n=nums.length;
        int dp[][]=new int[n][2001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(nums,target,0,0,dp);
    }
    public int func(int nums[],int target,int index,int currentSum,int dp[][]){
        if(index==nums.length){
            // positive base case
            if(target==currentSum){return 1;}
            else{return 0;}
        }
        if(dp[index][currentSum+1000]!=-1){return dp[index][currentSum+1000];}
        // add it
        int faith1=func(nums,target,index+1,currentSum+nums[index],dp);
        // subtract it
        int faith2=func(nums,target,index+1,currentSum-nums[index],dp);

        dp[index][currentSum+1000]=faith1+faith2;

        return faith2+faith1;
    }

}
