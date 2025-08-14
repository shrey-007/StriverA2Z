package Heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumSumCombination {
    /**
     * You are given two integer arrays A and B, each of size N, and an integer K.
     * You need to find the K maximum possible sums where each sum is formed by adding one element from A and one
     * element from B.
     *
     * A = [1, 4, 2, 3]
     * B = [2, 5, 1, 6]
     * K = 4
     *
     * Possible sums-:
     * 1+2=3, 1+5=6, 1+1=2, 1+6=7
     * 4+2=6, 4+5=9, 4+1=5, 4+6=10
     * 2+2=4, 2+5=7, 2+1=3, 2+6=8
     * 3+2=5, 3+5=8, 3+1=4, 3+6=9
     *
     * return top k maximum sum
     * [10, 9, 9, 8]
     * */

    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        // Max heap to store pairs with the largest sums first
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Sort both arrays so the largest elements are at the end
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Set to keep track of visited index pairs to avoid duplicates
        Set<String> visited = new HashSet<>();

        // Start with the largest possible sum: last element of nums1 + last element of nums2
        priorityQueue.offer(new Pair(n1 - 1, n2 - 1, nums1[n1 - 1] + nums2[n2 - 1]));
        visited.add((n1 - 1) + "," + (n2 - 1));

        int ans[] = new int[k]; // To store the top k sums

        // Extract the largest k sums
        for (int i = 0; i < k; i++) {
            // Get the largest sum from the heap
            Pair pair = priorityQueue.poll();
            ans[i] = pair.sum;

            int x = pair.i; // Index in nums1
            int y = pair.j; // Index in nums2

            // Try moving one step left in nums1 (decrease index in nums1)
            if (x - 1 >= 0 && visited.add((x - 1) + "," + y)) {
                priorityQueue.offer(new Pair(x - 1, y, nums1[x - 1] + nums2[y]));
            }

            // Try moving one step left in nums2 (decrease index in nums2)
            if (y - 1 >= 0 && visited.add(x + "," + (y - 1))) {
                priorityQueue.offer(new Pair(x, y - 1, nums1[x] + nums2[y - 1]));
            }
        }
        return ans; // Return the k largest sums
    }

    // Pair class to store indices (i, j) and their sum
    class Pair implements Comparable<Pair> {
        int i;   // Index in nums1
        int j;   // Index in nums2
        int sum; // Sum of nums1[i] + nums2[j]

        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        // Sort in descending order of sum (max heap behavior)
        @Override
        public int compareTo(Pair o) {
            return o.sum - this.sum;
        }
    }


}
