package DP.LIS;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LargestDivisibleSubset {
    /**
     * Given a set of distinct positive integers nums, return the largest subset answer such that every pair
     * (answer[i], answer[j]) of elements in this subset satisfies:
     *
     * answer[i] % answer[j] == 0, or
     * answer[j] % answer[i] == 0
     * If there are multiple solutions, return any of them.
     * */
    /**
     * let arr = [1,4,2,8]
     * - subsequence means ki take and not take karo but order is fixed means 1,4,8 is a subsequence bu 8,1,4 is not
     *   subset means take and not take + aorder also don't matter means 8,1,4 is a subset here.
     *
     * - first sort the array-: {1,2,4,8}
     * - Now take 1.
     * - We can take 2 since it is divisible by 1
     * - we can take 4 since it is divisible by 2, also 2 is divisible by 1 so 4 is also divisible by 1.
     * - we can take 8 since it is divisible by 4, also 4 is divisible by 2,1 so 8 is also divisible by 2,1
     * - Toh LIS mai apan take and not take kar rahe the and take tabhi kar rhe the jab current element previous element se bada ho
     * - Toh yaha bhi take and not take kro and take tabhi karo jab current element previous se divisible ho. Toh it is same code
     *
     *
     * */

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        // Step 2: Initialize dp and prev arrays
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1); // Every element is a subset of size 1
        Arrays.fill(prev, -1); // Initialize previous indices to -1

        // Step 3: Fill dp array using LIS logic
        int maxIndex = 0; // To keep track of the index with the maximum subset size
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // Update previous index
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i; // Update the maxIndex
            }
        }

        // Step 4: Reconstruct the largest divisible subset
        List<Integer> result = new ArrayList<>();
        int currentIndex = maxIndex;
        while (currentIndex != -1) {
            result.add(nums[currentIndex]);
            currentIndex = prev[currentIndex];
        }

        // Reverse the result to get the correct order
        Collections.reverse(result);
        return result;
    }

}
