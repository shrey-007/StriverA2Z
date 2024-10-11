package Greedy.medium;

import java.util.Arrays;

public class JumpGame2 {
    public static int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return func(nums,0,dp);
    }

    public static int func(int[] nums,int index,int dp[]){
        if(index==nums.length-1){return 0;}
        if(index>=nums.length){return (int)1e9;}
        if(dp[index]!=-1){return dp[index];}

        int maxJumps = nums[index];
        if(maxJumps==0){
            // yaha se kahi nhi jaa skte
            return (int)1e9;
        }

        int moves = (int)1e9;

        for(int i=1;i<=maxJumps;i++){
            moves = Math.min(moves,func(nums,index+i,dp)+1);
        }

        dp[index]=moves;

        return moves;
    }

    public static void main(String[] args) {
        int nums[]={2,3,1,1,4};
        jump(nums);
    }
}
