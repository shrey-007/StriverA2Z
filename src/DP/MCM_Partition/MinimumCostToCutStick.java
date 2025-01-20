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
     * You can change the order of the cuts as you wish.
     *
     * The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
     * When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of
     * the stick before the cut). Please refer to the first example for a better explanation.
     *
     * Return the minimum total cost of the cuts.
     * */

    // so the question is ki tumhe cuts toh krne hai but it is a permutation question, ki konsa cut pehle kro and konsa baad mai
    // it is not take and not-take. we have to take everyone.
     public int minCost(int n, int[] cuts) {
        // Include boundaries in cuts
        //  extendedCuts ka 0th element start of rod, last element end of rod, and beech ke elements are same
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

    // it is similar to merge sort
    private int helper(int[] cuts, int start, int end, int[][] dp) {
        // Base case: No cuts needed
        if (start + 1 >= end) return 0;

        // Return memoized result
        if (dp[start][end] != -1) return dp[start][end];

        int minCost = Integer.MAX_VALUE;

        // You can not cut anywhere, you can only cut at specific indices mentioned in cuts[] array

        // the question is ki agar tumne ith jagah pr cut kr bhi diya toh ye kese aage ki calls mai pass kroge ki maine
        // us jagah cut kr diya hai ab koi aur call mat cut krna. Since we have to cut at all indices toh ye kese pata karoge ki kon-kon si jagah esi hai jaha cut marna reh gaya hai
        // To solve this problem we will use start and end.

        // initially start=0, end=n.
        // ab iterate kro over all options ki kaha cut kar skte hai, toh uske liye cuts[] array hai, but cuts array mai
        // (start,end) hi cut kar skte hai uske alava saare cuts hogye. initially start=0, end=n.

        // ab tumne suppose i par cut kara. Toh i ko kisi jagah store krne ki jagah since tumhe pata hai (start,i) and (i,end)
        // koi cut nhi hai toh ye 2 calls kardo. kiuki cut i par laga hai toh (start,i) and (i,end) par koi cut nhi hai

        // Remember start and end are exclusive(not taken)
        // Toh we have solved our first problem ki ye kese pata kre ki kon se cuts bache hai

        // Now ho get length of current rod
        // start,end,i all are for the cut array.None of them is travesing on length of rod
        // since start and end choose kara hai apan ne cuts mai se, means cuts[start] and cuts[end] index of rod
        // par cut laga hai toh length is  cuts[end] - cuts[start]


        // Try cutting at every possible position between start and end

        // start, end are not index instead cuts[start], cuts[end] are the index jaha rod ko cut kara hai.
        // that's why cuts[end] - cuts[start] gives the length of the rod
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


