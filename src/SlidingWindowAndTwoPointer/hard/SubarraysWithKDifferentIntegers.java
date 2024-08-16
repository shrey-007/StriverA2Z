package SlidingWindowAndTwoPointer.hard;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {
    /**
     * Given an integer array nums and an integer k, return the number of good subarrays of nums.
     *
     * A good array is an array where the number of different integers in that array is exactly k.
     *
     * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
     * */

    /**
     * This questionis counting question toh f(k)-f(k-1) se solve kro
     * Same as BinarySubarraysyWithSum
     * */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }

    public int func(int[] nums, int k){
        int count=0;
        int start=0;
        int end=0;

        HashMap<Integer,Integer> hashMap=new HashMap<>();

        while (end<nums.length){
            int curr=nums[end];

            hashMap.put(curr,hashMap.getOrDefault(curr,0)+1);

            while (hashMap.size()>k){
                int elementAtStart=nums[start];
                hashMap.put(elementAtStart,hashMap.get(elementAtStart)-1);
                if(hashMap.get(elementAtStart)==0) hashMap.remove(elementAtStart);

                start++;
            }

            count=count+end-start+1;
            end++;
        }

        return count;
    }
}
