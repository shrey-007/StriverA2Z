package DP.Strings;

import java.util.Arrays;

public class DistinctSubsequences {
    /**
     * Given two strings s and t, return the number of distinct subsequences of s which equals t.
     *
     * The test cases are generated so that the answer fits on a 32-bit signed integer.
     * */
    // first did the brute force, generate all subsequences of s and then check whether the generated subsequence is
    // equal to t or not
    // better way is-:
    public int numDistinct(String s, String t) {
        // Initialize a memoization table
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Fill with -1 to indicate uncomputed states
        }
        return func(s, t, 0, 0, dp);
    }

    private int func(String s, String t, int i, int j, int[][] dp) {
        // Base case: if we've matched the entire string t
        if (j == t.length()) return 1;

        // Base case: if we've exhausted string s without fully matching t
        if (i == s.length()) return 0;

        // Check if the result is already computed
        if (dp[i][j] != -1) return dp[i][j];

        // Recurrence relation
        int result = 0;

        // If the characters match, we can choose to use this character or skip it
        if (s.charAt(i) == t.charAt(j)) {
            result += func(s, t, i + 1, j + 1, dp); // Use the character
        }

        // Skip the current character in s
        result += func(s, t, i + 1, j, dp);

        // Store the result in the memoization table
        dp[i][j] = result;

        return result;
    }
}
