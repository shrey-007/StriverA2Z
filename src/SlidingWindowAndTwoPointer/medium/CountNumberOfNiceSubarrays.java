package SlidingWindowAndTwoPointer.medium;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 * */
public class CountNumberOfNiceSubarrays {

    /** Jaha bhi odd number dikhe vaha 1 maan lo and jah aeven number dikhe vaha 0 maan lo.
     *  Now This question is equivalent to BinarySubarraysWithSum with goal k.
     *
     *  This question can not be done using sliding window as variable size window can't solve counting questions.
     *  But we can solve it using
     *  number of subarrays lesser than equal to count-number of subarrays lesser than equal to (count-1)
     * */
    public int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer,Integer> hashMap=new HashMap<>();

        int ans=0;
        int prefixSum=0;

        for (int i = 0; i <nums.length; i++) {

            int curr=nums[i];

            if((curr&1)==1){curr=1;}
            else{curr=0;}

            prefixSum=prefixSum+curr;

            if(prefixSum==k){ans++;}

            if(hashMap.containsKey(prefixSum-k)){
                ans=ans+hashMap.get(prefixSum-k);
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
}
