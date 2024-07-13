package SlidingWindowAndTwoPointer.medium;

import java.util.HashMap;

public class CountNumberOfNiceSubarrays {

    /** Jaha bhi odd number dikhe vaha 1 maan lo and jah aeven number dikhe vaha 0 maan lo.
     * Now This question is equivalent to BinarySubarraysWithSum with goal k
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
