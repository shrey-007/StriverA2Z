package BinarySearch.Anwers;

public class KthElementOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2,int k) {
        // Get the lengths of both arrays
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Ensure that nums1 is the smaller array to minimize the binary search space, you can ignore this line if you
        // don't understand
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1,k);
        }

        // The total number of elements needed in the left partition
        int left = k;

        // Initialize the binary search range
        int low = Math.max(0,k-n2);
        int high = Math.max(k,n1);

        // Perform binary search
        while (low <= high) {
            int mid1 = (low + high) / 2;  // Midpoint of the first array
            int mid2 = left - mid1;       // Midpoint of the second array to balance the partitions

            // Initialize the partition values with extreme limits
            int l1 = Integer.MIN_VALUE; // Max of the left part of nums1
            int l2 = Integer.MIN_VALUE; // Max of the left part of nums2
            int r1 = Integer.MAX_VALUE; // Min of the right part of nums1
            int r2 = Integer.MAX_VALUE; // Min of the right part of nums2

            // Set the partition values if within valid range
            if (mid1 < n1) r1 = nums1[mid1];        // Right part minimum for nums1
            if (mid2 < n2) r2 = nums2[mid2];        // Right part minimum for nums2
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1]; // Left part maximum for nums1
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1]; // Left part maximum for nums2

            // Check if we have found the correct partition
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                // Move the partition to the left in nums1
                high = mid1 - 1;
            }
            else {
                // Move the partition to the right in nums1
                low = mid1 + 1;
            }
        }

        // Return 0 if no valid partition is found (this case should not occur for valid input)
        return 0;
    }

}
