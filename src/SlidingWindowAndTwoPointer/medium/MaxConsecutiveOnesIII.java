package SlidingWindowAndTwoPointer.medium;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can
 * flip at most k 0's.
 *
 * 
 * So this question is basically longest subarray with all 1, if you can flip atmost k 0's
 * Toh longest subarray means variable size sliding window
 */
public class MaxConsecutiveOnesIII {

    /** Variable size sliding window */
    public int longestOnes(int[] nums, int k) {

        int start=0;
        int end=0;
        int ans=0;
        int flips=0;

        while (end<nums.length) {

            if(nums[end]==1){
                // update answer
                ans=Math.max(ans,end-start+1);
                end++;
            }
            else{
                // means nums[end]=0 hai
                // agar flip lr skte hai toh flip kro
                if(flips<k){
                    flips++;
                    ans=Math.max(ans,end-start+1);
                    end++;
                }
                // ab flip ni kr skte toh start ko aage hi badana padega
                else if(flips==k){
                    // start ko aage badao
                    while (nums[start]!=0){
                        start++;
                    }
                    // nums[start] is now 0, ise include krne par flips badi thi ab ise exclude krdo toh flips decrease ho jaaegi
                    start++;
                    flips--;
                }
            }
        }


        return ans;

    }
}
