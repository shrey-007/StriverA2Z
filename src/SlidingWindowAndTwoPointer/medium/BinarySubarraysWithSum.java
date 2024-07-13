package SlidingWindowAndTwoPointer.medium;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    /**It is same as 2 sum , bas use ab sliding window se krna hai*/


    /** We have already solved this question before , in Arrays/medium/CountSubArraysWithGivenSum , so first solve it
     * using that method only */

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


    public static void main(String[] args) {
        int arr[]={1,1,0,1,1};
        System.out.println(func(arr,3));
    }
}
