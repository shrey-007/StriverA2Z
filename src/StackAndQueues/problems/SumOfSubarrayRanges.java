package StackAndQueues.problems;

/**
 * You are given an integer array nums. The range of a subarray of nums is the difference between the largest and
 * smallest element in the subarray.
 *
 * Return the sum of all subarray ranges of nums.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.*/
public class SumOfSubarrayRanges {

    // Brute force is simply same as SumOfSubarrayMinimums-:
    // Find all possible subarray and then find min,max then find difference then add it to ans
    // so i am not going to do it through brute force

    /**
     * Another way is-:
     * For all subarray-: sumOf(maxOfSubarray-minOfSubarray)
     * For all subarray-: sumOf(maxOfSubarray)-sumOf(minOfSubarray)
     * SumOfSubarrayMaximums - SumOfSubarrayMinimums
     * */
    public long subArrayRanges(int[] nums) {
        return 0;
    }

}
