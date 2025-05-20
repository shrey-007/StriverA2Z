package SlidingWindowAndTwoPointer.medium;

import java.util.HashMap;

/**
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 * */
public class BinarySubarraysWithSum {

    /** We have already solved this question before , in Arrays/medium/CountSubArraysWithGivenSum , so first solve it
     * using that method only */
    /**It is same as 2 sum , bas use ab sliding window se krna hai*/

    /**
     * It is obviously variable size window, but here question is count number of sub-arrays. So count questions don't
     * work on varibale size window. So it is not sliding window question
     * */

    public static int func(int[] nums, int goal){
        // maps sum to the number of times that sum is occurring
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        int prefixSum=0;
        int ans=0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum=prefixSum+nums[i];

            if(prefixSum==goal){ans++;}

            if(hashMap.containsKey(prefixSum-goal)){
                ans=ans+hashMap.get(prefixSum-goal);
            }

            if(hashMap.containsKey(prefixSum)){
                hashMap.put(prefixSum,hashMap.get(prefixSum)+1);
            }
            else{
                hashMap.put(prefixSum,1);
            }

        }

        return ans;
    }

    /**
     * variable sliding window don't work on count questions.
     *
     * It can not find count of subarrays with sum equal to k, because jab sum==k hoga toh uske baad start++ kre ya
     * end++ kre ni pata
     *
     * But it can work on count subarrays with sum lesser than or equal to k. Kiuki jab sum equal to k hoga toh sirf vo
     * subarray count nhi hoga balki saare subarrays count hoge,and fir end++ kr denge
     * */

    public int numSubarraysWithSum(int[] nums, int goal) {
        return numberOfSubarraysWithSumLesserThanOrEqualToGoal(nums,goal)-numberOfSubarraysWithSumLesserThanOrEqualToGoal(nums,goal-1);
    }

    public int numberOfSubarraysWithSumLesserThanOrEqualToGoal(int nums[],int goal){
        if(goal<0){return 0;}

        int start=0;
        int end=0;
        int ans=0;
        int sum=0;

        while (end<nums.length){
            // do work on end
            sum=sum+nums[end];

            while (sum>goal){
                sum=sum-nums[start];
                start++;
            }

            // yaha par aaye means ki sum<=goal toh agar start se end tak ke poore subarray ka sum <= goal hai toh
            // voh saare subarrys jo start ke baad start hoge and end pr khatam hoge unke bhi sum<=goal hoga
            // [start+1,end], [start+4,end], [start+5,end]....
            // toh ese total end-start+1 sub-arrays hai

            ans=ans+end-start+1;
            end++;
        }

        return ans;
    }

    /**
     * if sliding window don't work correctly on count subaarays with sum equal to goal, then why does it work on count subarrays with sum lesser than equal to goal
     *
     * Great question! The difference lies in the nature of the conditions being checked and how sliding window techniques are designed to work.
     *
     * ### Sliding Window and Exact Sum:
     *
     * When using the sliding window technique to find subarrays with an **exact sum** equal to a specific `goal`, the challenge is that the window's sum can fluctuate above and below the `goal` as you adjust the window. This creates ambiguity:
     * - If the sum matches the `goal`, should you expand the window to include more elements, or shrink it to try and find other subarrays?
     * - The problem with exact matches is that adjusting the window (either expanding or shrinking) can disrupt the sum in an unpredictable way, and there's no straightforward method to guarantee that you correctly count all subarrays.
     *
     * This is why the sliding window approach is unreliable for counting subarrays with an exact sum.
     *
     * ### Sliding Window and Sum Less Than or Equal to Goal:
     *
     * In contrast, when counting subarrays with a sum **less than or equal to** a given `goal`, the sliding window approach works because of the following reasons:
     *
     * 1. **Monotonic Behavior**:
     *    - When adding elements to the window (by moving the `end` pointer), the sum either increases or remains the same.
     *    - When the sum exceeds the `goal`, you can safely move the `start` pointer to reduce the sum. This behavior is consistent and predictable.
     *
     * 2. **Non-Ambiguity**:
     *    - When the sum is within the required range (less than or equal to `goal`), every valid subarray that ends at the current `end` index can be counted. This count is given by `(end - start + 1)` because all subarrays starting from any index between `start` and `end` will have a sum less than or equal to `goal`.
     *    - There's no ambiguity because if the sum exceeds the `goal`, you simply shrink the window by moving `start` forward until the sum is again within the allowed range.
     *
     * 3. **Efficiency**:
     *    - The sliding window efficiently narrows down the window size when needed, and expands it to include new elements, ensuring that all potential subarrays are counted without redundant calculations.
     *
     * ### Summary:
     * - **Exact Sum:** Finding subarrays with an exact sum using sliding windows is challenging because you can't easily decide whether to expand or shrink the window without potentially missing valid subarrays or counting duplicates.
     * - **Less Than or Equal to Sum:** Counting subarrays with a sum less than or equal to a goal is straightforward with sliding windows because the conditions for expanding or shrinking the window are clear and unambiguous. The sum is either within the limit, in which case you count all valid subarrays, or it exceeds the limit, in which case you adjust the window.
     *
     * This predictability and monotonic behavior make the sliding window technique well-suited for problems involving sums with inequalities (like "less than or equal to") rather than exact matches.

     */



    public static void main(String[] args) {
        int arr[]={1,1,0,1,1};
        System.out.println(func(arr,3));
    }
}
