package StackAndQueues.problems;

import java.util.Stack;

/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 109 + 7
 * */
public class SumOfSubarrayMinimums {

    /**
     * Brute force is find all possible subarrays and then find minimum in that subarray then add it to ans
     * TC - O(N2)
     * */
    public int sumSubarrayMins(int[] arr) {

        int n=arr.length;
        int ans=0;


        for (int startIndex = 0; startIndex <n ; startIndex++) {
            int minimumNumberInCurrentSubarray=Integer.MAX_VALUE;
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                // toh jab bhi is loop ke under aaege toh ek new subarray banega, toh is new subarray ka min nikaalo
                if(minimumNumberInCurrentSubarray>arr[endIndex]){
                    minimumNumberInCurrentSubarray=arr[endIndex];
                }
                // since minimum calculate ho gya toh ab use sum mai add krdo
                ans=ans+minimumNumberInCurrentSubarray;
            }
        }

        return ans;
    }

    /**
     * Another optimal solution is-:
     * The key observation is that for each element in the array, it acts as the minimum for several subarrays. To calculate the contribution of each element to the total sum, you need to determine how many subarrays include this element as the minimum.
     *
     * If an element arr[i] has PSE[i] as its previous smaller or equal element and NSE[i] as its next smaller element:
     * The total number of subarrays where arr[i] is the minimum can be calculated as:
     * (i−PSE[i])×(NSE[i]−i)
     *
     * This is because:
     * There are (i - PSE[i]) subarrays ending at i that start anywhere from PSE[i] + 1 to i.
     * There are (NSE[i] - i) subarrays starting at i that end anywhere from i to NSE[i] - 1.
     * Thus, the contribution of arr[i] to the final sum is:
     * arr[i]×(i−PSE[i])×(NSE[i]−i)
     *
     * // THE ONLY IMPORTANT THING HERE IS KI APAN NE PREVIOUS SMALLER OR EQUAL LIYA HAI PREVIOUS SMALLER NHI
     * */
    // Function to find the next smaller elements
    public int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    // Function to find the previous smaller or equal elements
    public int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    // Function to calculate the sum of subarray minimums
    public int sumSubarrayMins2(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long total = 0;
        int mod = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (right * left * 1L * arr[i]) % mod) % mod;
        }
        return (int) total;
    }
    /**
     * The reason why we used previous smaller or equal to element instead of previous smaller element is-:
     * 1. take a test case [1,1] ab agar pse,nse se kroge toh [1,1] vaala subarray 2 baar aajaega
     * 2. Toh 1,1 vaala subarray 1 baar aaye isliye kisi bhi ek mai equal lagado either nse or pse yaha pse mai equal laga diya
     * */

}
