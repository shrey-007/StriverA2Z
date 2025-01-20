package DP.MCM_Partition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MinimumCostToCutStick {
    /**
     * Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is
     * labelled as follows:
     *
     *
     * Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
     *
     * You should perform the cuts in order, you can change the order of the cuts as you wish.
     *
     * The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
     * When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of
     * the stick before the cut). Please refer to the first example for a better explanation.
     *
     * Return the minimum total cost of the cuts.
     * */
     public int minCost(int n, int[] cuts) {
        // Include boundaries in cuts
        int[] extendedCuts = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, extendedCuts, 1, cuts.length);
        extendedCuts[0] = 0;
        extendedCuts[extendedCuts.length - 1] = n;

        // Sort the cuts
        Arrays.sort(extendedCuts);

        // Memoization table
        int[][] dp = new int[extendedCuts.length][extendedCuts.length];

        // Fill the table with -1 (indicating uncomputed)
        for (int[] row : dp) Arrays.fill(row, -1);

        // Call the helper function
        return helper(extendedCuts, 0, extendedCuts.length - 1, dp);
    }

    private int helper(int[] cuts, int start, int end, int[][] dp) {
        // Base case: No cuts needed
        if (start + 1 >= end) return 0;

        // Return memoized result
        if (dp[start][end] != -1) return dp[start][end];

        int minCost = Integer.MAX_VALUE;

        // Try cutting at every possible position between start and end
        for (int i = start + 1; i < end; i++) {
            int cost = cuts[end] - cuts[start]
                    + helper(cuts, start, i, dp)
                    + helper(cuts, i, end, dp);
            minCost = Math.min(minCost, cost);
        }

        // Store the result
        dp[start][end] = minCost;
        return minCost;
    }
}


