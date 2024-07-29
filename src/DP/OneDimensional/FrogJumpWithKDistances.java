package DP.OneDimensional;

/**
 * There is an array arr of heights of stone and Geek is standing at the first stone and can jump to one of the following:
 * Stone i+1, i+2, ... i+k stone, where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is
 * incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches the
 * last stone.*/
public class FrogJumpWithKDistances {

    // Recursion
    public int minimizeCost(int arr[], int k) {
        return func(arr,0,k);
    }

    // func(index) denotes ki index to n-1 jaane ki min cost kya hai
    public int func(int arr[],int index,int k){
        // n-1 se (n-1)th stone pr jaane ki cost is 0
        if(index==arr.length-1){return 0;}

        int faith=Integer.MAX_VALUE;

        // call all possible options and return the minimum
        for (int i = 1; i <= k; i++) {
            if(index+i>=arr.length){break;}
            faith=Math.min(faith,func(arr,index+i,k)+Math.abs(arr[index]-arr[index+i]));
        }
        return faith;
    }


    // Memoization
    public int func(int arr[],int index,int k,int dp[]){
        // n-1 se (n-1)th stone pr jaane ki cost is 0
        if(index==arr.length-1){return 0;}
        if(dp[index]!=-1){return dp[index];}

        int faith=Integer.MAX_VALUE;

        // call all possible options and return the minimum
        for (int i = 1; i <= k; i++) {
            if(index+i>=arr.length){break;}
            faith=Math.min(faith,func(arr,index+i,k)+Math.abs(arr[index]-arr[index+i]));
        }
        dp[index]=faith;
        return faith;
    }

    // Tabulation
    // Since func(index) denotes ki index to n-1 jaane ki min cost kya hai
    // Toh dp[index] denotes ki index to n-1 jaane ki min cost kya hai.
    // And jab hum dp[index] calculate kr rhe hoge tab tak apan ne dp[index+1],dp[index+2]...dp[n-1] already calculate kr liya hoga
    // Th un calculated answer ko use krke apan ko dp[index] calculate krna hai
    // Toh dp[index] is min of-:
    // 1. index to index+1 and then dp[index]

    public int tabulation(int arr[],int k){

        int dp[]=new int[arr.length];
        dp[arr.length-1]=0;

        for (int index = arr.length-2; index >=0 ; index--) {
            int faith=Integer.MAX_VALUE;

            // call all possible options and return the minimum
            for (int i = 1; i <= k; i++) {
                if(index+i>=arr.length){break;}
                faith=Math.min(faith,dp[index+i]+Math.abs(arr[index]-arr[index+i]));
            }
            dp[index]=faith;
        }

        return dp[0];
    }

    // You can not do space optimizations, as you will have to create k variables for that


}
