package DP.LIS;

public class LongestBitonicSubsequence {
    /**
     * Given an array of positive integers. Find the maximum length of Bitonic subsequence.
     * A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
     * Return the maximum length of bitonic subsequence.
     *
     * Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence
     * */

    // the code requires understanding of dp[] array int the tabulation code
    public static int LongestBitonicSequence(int n, int[] nums) {
        // Arrays to store LIS and LDS
        int[] lis = new int[n];
        int[] lds = new int[n];

        // Initialize LIS for each element as 1
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        // Compute LIS for every index
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Initialize LDS for each element as 1
        for (int i = 0; i < n; i++) {
            lds[i] = 1;
        }

        // Compute LDS for every index
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        // Find the maximum length of bitonic subsequence
        int maxBitonicLength = 0;
        for (int i = 0; i < n; i++) {
            maxBitonicLength = Math.max(maxBitonicLength, lis[i] + lds[i] - 1);
        }

        return maxBitonicLength;
    }

}
