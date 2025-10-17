package DP.MCM_Partition;

import java.util.Arrays;

public class BurstBalloons {
    /**
     * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an
     * array nums. You are asked to burst all the balloons.
     *
     * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out
     * of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
     *
     * Return the maximum coins you can collect by bursting the balloons wisely
     * */
    // It is not a subsequence problem, ki tum bolo take and not take.
    // It is a permutation problem , saare balloons burst hoge but knosa pehle hoga ye ques hai

    // Ab subsequences mai toh index ke though iterate krte the, yaha kese iterate kroge, and kese pata padega ki konsa
    // balloon burst hogya hai and konsa bacha hai

    // it can not be solved using previous concept, suppose arr is given
    // and you made a partition at i, so what you did is arr[i-1]*arr[i]*arr[i+1] then solved for func(start,i-1)+func(i+1,end)
    // it will not work, because left and right part are dependent on each other
    // suppose tumne left part ke rightmost balloon burst kra toh uska nums[i],nums[i-1] to theek hai, but nums[i+1]
    // galat hoga, voh right part mai hoga and nums[i+1] mai hi pichli call mai partition kra toh toh use add nhi karege asn mai
    // in simple terms, we don't know who is the right guy and who is the left guy after separating

    // it is actually very difficult question
    // instead of selecting which to burst first, we have to select which to burst last

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = 1; // virtual balloon on the left
        extendedNums[n + 1] = 1; // virtual balloon on the right
        for (int i = 0; i < n; i++) {
            extendedNums[i + 1] = nums[i];
        }

        // Memoization table
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return func(extendedNums, 1, n, dp);
    }

    public int func(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int maxCoins = 0;

        for (int i = start; i <= end; i++) {
            // Coins from bursting the ith balloon
            int coins = nums[start - 1] * nums[i] * nums[end + 1]
                    + func(nums, start, i - 1, dp) // Coins from left subarray
                    + func(nums, i + 1, end, dp);  // Coins from right subarray

            maxCoins = Math.max(maxCoins, coins);
        }

        dp[start][end] = maxCoins;
        return maxCoins;
    }



}
