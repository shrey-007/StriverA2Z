package DP.MCM_Partition;

public class PartitionArrayForMaximumSum {
    /**
     * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
     * After partitioning, each subarray has their values changed to become the maximum value of that subarray.
     *
     * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits
     * in a 32-bit integer.
     *
     * */

    // this is same as palindromic partition2
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return func(arr,0,k,arr.length);
    }
    // we have to partition the array starting from the index "index"
    public int func(int arr[],int index,int k,int n){
        if(index==n) return 0;
        // we can make a partition of size 1,2,3,4,...k
        // so this is the choice, partition size
        // toh agar index se start krna hai parttion toh index,index+1,index+2...index+k-1, tak krna hoga

        int maxElement = arr[index];
        int currentSum = 0;
        int ans = 0;
        // we have to partition the array starting from the index "index"
        // we are doing parttion from index to i
        // maxElement is the element which is the maximum from index to i
        // toh there are i-index+1 elements in the partition and each of them will be converted to maxElement
        // so sum will be maxElement*(i-index+1)
        for (int i = index; i <index+k && i<n ; i++) {
            maxElement = Math.max(maxElement,arr[i]);
            currentSum = maxElement*(i-index+1)+func(arr,i+1,k,n);
            ans = Math.max(currentSum,ans);
        }

        return ans;
    }
}
