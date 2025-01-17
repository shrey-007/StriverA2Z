package DP.LIS;

import java.util.ArrayList;
import java.util.List;

public class LISUsingBinarSearch {
    public static int lengthOfLIS(int[] nums) {
        List<Integer> subsequence = new ArrayList<>();

        for (int num : nums) {
            // Find the position to replace or extend the subsequence
            int pos = binarySearch(subsequence, num);
            if (pos < subsequence.size()) {
                subsequence.set(pos, num); // Replace to maintain the smallest possible value
            } else {
                subsequence.add(num); // Extend the subsequence
            }
        }
        return subsequence.size();
    }

    private static int binarySearch(List<Integer> subsequence, int target) {
        int left = 0, right = subsequence.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (subsequence.get(mid) >= target) {
                right = mid - 1; // Move left for smaller or equal values
            } else {
                left = mid + 1; // Move right for larger values
            }
        }
        return left; // Position to replace or insert
    }
}
