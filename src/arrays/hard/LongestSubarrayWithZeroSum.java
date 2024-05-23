package arrays.hard;

import java.util.HashMap;

public class LongestSubarrayWithZeroSum {
    // It is same as the one we solved LongestSubarrayHavingSumK in easy questions

    public static int maxLen(int arr[], int n)
    {
        int ans=0;

        HashMap<Integer,Integer> hm=new HashMap<>();

        int prefixSum=0;


        for(int i=0;i<n;i++){
            prefixSum=prefixSum+arr[i];
            if(prefixSum==0){ans=i+1;}
            if(hm.containsKey(prefixSum)){
                ans=Math.max(ans,i-hm.get(prefixSum));
            }
            if(!hm.containsKey(prefixSum)){hm.put(prefixSum,i);}
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
