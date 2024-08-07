package DP.subsequences;

import java.util.Arrays;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {

    public int minimumDifference(int[] nums) {
        int totalSum=0;
        for (int i = 0; i < nums.length; i++) {
            totalSum+=nums[i];
        }

        int dp [][]=new int[nums.length][totalSum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }

        return func2(nums,0,0,0,totalSum,nums.length,dp);
    }

    public int func2(int arr[],int index,int sumOfFirstSubarray,int numberOfElementsInFirstSubarray,int totalSum,int totalElements,int dp[][]){

        int sumOfSecondSubarray=totalSum-sumOfFirstSubarray;
        int numberOfElementsInSecondSubarray=totalElements-numberOfElementsInFirstSubarray;

        if(index==arr.length){
            // We want ki dono ka size same ho, agar nhi hai toh ye negative base case hai toh return infinity
            if(numberOfElementsInFirstSubarray!=numberOfElementsInSecondSubarray){return Integer.MAX_VALUE;}
            // In positive base case return absolute difference
            return Math.abs(sumOfFirstSubarray-sumOfSecondSubarray);
        }

        if(dp[index][sumOfFirstSubarray]!=-1){return dp[index][sumOfFirstSubarray];}

        // include cuurent element in first subarray
        int faith1=func2(arr,index+1,sumOfFirstSubarray+arr[index],numberOfElementsInFirstSubarray+1,totalSum,totalElements,dp);
        // include current element in second subarray
        int faith2=func2(arr,index+1,sumOfFirstSubarray,numberOfElementsInFirstSubarray,totalSum,totalElements,dp);

        dp[index][sumOfFirstSubarray]=Math.min(faith1,faith2);

        return dp[index][sumOfFirstSubarray];
    }

}
