package arrays.medium;

import java.util.HashMap;

public class CountSubArraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> hm=new HashMap<>();
        int prefixSum=0;
        int count=0;

        for(int i=0;i<nums.length;i++){

            prefixSum=prefixSum+nums[i];
            if(hm.containsKey(prefixSum-k)){
                count=count+hm.get(prefixSum-k);
            }

            if(prefixSum==k){
                count++;
            }

            if(hm.containsKey(prefixSum)){
                hm.put(prefixSum,hm.get(prefixSum)+1);
            }
            else{
                hm.put(prefixSum,1);
            }
        }
        return count;
    }
}
