package DP.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /**
     * If the question was Longest Increasing Substring, toh easy ho jaata coz jaise hi arr[i]>arr[i+1] hota vaise hi
     * currentAns =0 kr dete hai ans ko end-start+1 kr dete
     * **/

    /**
     * Brute force is ki generate all possible subsequence and check whether it is increasing or not
     * */

    /**
     * How do we solve subsequences question-: TAKE and NOT TAKE, Toh isme bhi esa hi kro coz isme bhi subsequence nikaalna hai
     * Bas TAKE krte time ye check kro ki current element previous se bada hai tabhi take kro else not, toh ek aur variabl lena padega previous
     * */

    public int lengthOfLIS(int[] nums) {
        return func(nums,0,Integer.MIN_VALUE);

    }

    public int func(int arr[],int index,int previousElement){
        if(index==arr.length){
            return 0;
        }

        // take, and increase number of elements by 1
        int faith1=Integer.MIN_VALUE;
        if(previousElement<arr[index]){
            faith1=func(arr,index+1,arr[index])+1;
        }

        // not take
        int faith2=func(arr,index+1,previousElement);

        return Math.max(faith2,faith1);
    }

    // memoization
    /**
     * The problem here is ki apan ne previousElement liya hai, and -10000<nums[i]<10000 hai, means ki apan ko index
     * shifting krni padegi else dp[previousElement] error dega
     * Neeche vaale code mai index shifting hi kri hai
     * But it is better ki previousElement ki jagah previousIndex daalo toh usme shifting nhi krni padegi
     * */
    public int lengthOfLIS2(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][20002];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }

        return func(nums,0,-10001,dp);
    }

    public int func(int arr[],int index,int previousElement,int dp[][]){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][previousElement+10001]!=-1){return dp[index][previousElement+10001];}

        // take, and increase number of characters by 1
        int faith1=Integer.MIN_VALUE;
        if(previousElement<arr[index]){
            faith1=func(arr,index+1,arr[index],dp)+1;
        }

        // not take
        int faith2=func(arr,index+1,previousElement,dp);

        dp[index][previousElement+10001]=Math.max(faith2,faith1);

        return dp[index][previousElement+10001];
    }

}
