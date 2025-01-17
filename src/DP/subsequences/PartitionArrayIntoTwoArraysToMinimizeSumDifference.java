package DP.subsequences;

import java.util.Arrays;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    /**
     * You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to
     * minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one
     * of the two arrays.
     *
     * Return the minimum possible absolute difference.
     * */

    public int minimumDifference(int[] nums) {
        int totalSum=0;
        for (int i = 0; i < nums.length; i++) {
            totalSum+=nums[i];
        }

        return func(nums, nums.length/2, 0,0,0,totalSum);
    }
    public int func(int arr[],int n,int index,int sumOfFirstSubarray,int numberOfElementsInFirstSubarray,int totalSum){
        if(index==2*n){
            return totalSum-sumOfFirstSubarray;
        }
        // take this element in first subarray
        int faith1 = Integer.MAX_VALUE;
        if(numberOfElementsInFirstSubarray<n) faith1 = func(arr,n,index+1,sumOfFirstSubarray+arr[index],numberOfElementsInFirstSubarray+1,totalSum);

        // take it into another subarray
        int faith2 = Integer.MAX_VALUE;
        int numberOfElementsInSecondSubarray = 2*n - numberOfElementsInFirstSubarray;
        if(numberOfElementsInSecondSubarray<n) faith2 = func(arr,n,index+1,sumOfFirstSubarray,numberOfElementsInFirstSubarray,totalSum);

        return Math.min(faith1,faith2);
    }

    // This question is solved using meet in middle approach, also see what striver did

}
