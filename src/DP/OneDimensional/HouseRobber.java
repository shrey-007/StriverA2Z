package DP.OneDimensional;

public class HouseRobber {
    public int rob(int[] nums) {
        return recursion(nums,0);
    }

    // recursion
    public int recursion(int nums[],int index){
        if(index>=nums.length){
            return 0;
        }

        int faith1=recursion(nums,index+1);
        int faith2=recursion(nums,index+2)+nums[index];

        return Math.max(faith1,faith2);
    }

    // memoization
    public int memoization(int nums[],int index,int dp[]){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index]!=-1){return dp[index];}

        int faith1=memoization(nums,index+1,dp);
        int faith2=memoization(nums,index+2,dp)+nums[index];

        dp[index]=Math.max(faith1,faith2);

        return Math.max(faith1,faith2);
    }


    public int tabulation(int arr[]){
        int dp[]=new int[arr.length+1];

        dp[arr.length]=0;

        // ye test case memoization mai nhi daala tha but yaha daalna padega, else wrong ans aa rha tha
        // Dry run krke nikaal liya kro missing test cases
        dp[arr.length-1]=arr[arr.length-1];

        for (int index= arr.length-2; index>=0 ; index--) {
            int faith1=dp[index+1];
            int faith2=Integer.MIN_VALUE;
            if(index+2<dp.length){
                faith2=dp[index+2]+arr[index];
            }
            dp[index]=Math.max(faith1,faith2);
        }

        return dp[0];
    }

    // space optimization
    public int spaceOptimization(int arr[]){

        int afterAfter=0;

        // ye test case memoization mai nhi daala tha but yaha daalna padega, else wrong ans aa rha tha
        // Dry run krke nikaal liya kro missing test cases
        int after=arr[arr.length-1];

        for (int index= arr.length-2; index>=0 ; index--) {
            int faith1=after;
            int faith2=Integer.MIN_VALUE;
            faith2=afterAfter+arr[index];

            int curr=Math.max(faith1,faith2);

            afterAfter=after;
            after=curr;
        }


        return after;
    }



}
