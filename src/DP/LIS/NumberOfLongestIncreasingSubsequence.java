package DP.LIS;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        return func(nums,0,-1);
    }
    public int func(int arr[],int index,int lastNumber){
        if(index==arr.length) return 1;

        // take, only if current is greater
        int faith1 = 0;
        if(arr[index]>=lastNumber) faith1 = func(arr,index+1,arr[index]);

        // not take
        int faith2 = func(arr,index+1,lastNumber);
        return faith2+faith1;
    }
}
