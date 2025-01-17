package DP.subsequences;

import java.util.Arrays;

public class SubsetSumEqualToTarget {
    /** DP 14 */
    /**
     * Given an array of positive integers arr[] and a value target, determine if there is a subset of the given array
     * with sum equal to given target.
     * */
    static Boolean isSubsetSum(int N, int arr[], int sum){
        return func(arr,sum,0);
    }

    // recursion

    public static boolean func(int arr[],int target,int index){
        if(target==0){return true;}
        if(target<0){return false;}

        // base case
        if(index==arr.length){return false;}


        boolean faith1=func(arr,target-arr[index],index+1);
        boolean faith2=func(arr,target,index+1);

        return faith2 || faith1;
    }

    // memoization
    // Since 2 parameters change ho rhe hai index, currentSum toh 2D dp banegi
    // agar dp[][] ka size (length of array)x(target) rakha toh dp[index] access krne mai koi dikkat nhi aaegi kiuki arr[index] mai dikkat nhi aaegi
    // But dp[index][target] mai index out of bound error aaegi coz tumne target size ka array rakha hai and traget index ko access kr rhe ho
    // Toh (length of array)x(target+1) size ka dp array banao

    static Boolean isSubsetSum2(int N, int arr[], int sum){
        int dp[][]=new int[N][sum+1];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        return memoization(arr,sum,0,dp);
    }

    public static boolean memoization(int arr[],int target,int index,int dp[][]){
        // do work
        if(target==0){return true;}
        if(target<0){return false;}

        // base case
        if(index==arr.length){return false;}

        if(dp[index][target]!=-1){
            if(dp[index][target]==1){return true;}
            else{return false;}
        }

        // faith
        // include in current sum
        boolean faith1=memoization(arr,target-arr[index],index+1,dp);
        boolean faith2=memoization(arr,target,index+1,dp);

        boolean ans=faith2 || faith1;

        if(ans==true){dp[index][target]=1;}
        else{dp[index][target]=0;}

        return ans;
    }

    // Tabulation
    public boolean tabulation(int arr[],int sum){
        boolean dp[][]=new boolean[arr.length][sum+1];


        // If target is zero then put true
        // Equivalent to if(target==0){return true;}
        for (int i = 0; i < arr.length; i++) {
            dp[i][0]=true;
        }


        //  Now we have to find base case equivalent to if(index==arr.length){return false;} but apan ne dp, arr.length size ka hi banaya hai toh ye base case
        // nhi daal skte toh apan ko if(index==arr.length-1) ka base case sochna hai
        /** Suppose this is array {3,34,4,12,5,2} and target=9
         *  Agar last element 2 hai and us time required target 5,1,12,.. hai toh subset nhi banega,subset tabhi banega jab required target 2 hoga
         * */
        // Agar array ka last element 90 hai and target 7 hai toh array 8 size ka banega toh 90th index error dega isliye if mai check kr liya pehle
        if(arr[arr.length-1]<=sum)dp[arr.length-1][arr[arr.length-1]]=true;

        for (int index = arr.length-2; index >=0; index--) {
            for (int target = dp[0].length-1; target >0; target--) {
                // maanlo ki tum abhi 5 par ho and target t hai.
                // Ab tumhare paas 2 option hai ya toh 5 ko lo and t-5 ka target dedo aage vaale index ko
                // Ya fir 5 ko mat lo and t ka target dedo aage vaale index ko.
                // Aage vaala index us target ko kr paaega ki nhi vo already calculate ho chuka hai
                // But the problem is t-5 direct nhi daal skte index mai , check krna padega 0 se bada hai ki nhi
                // we can't write this directly-:   dp[index][target]=dp[index+1][target-arr[index]] || dp[index][target];
                boolean faith1=false;
                if(target-arr[index]>0){faith1=dp[index+1][target-arr[index]];}
                boolean faith2=dp[index+1][target];
                dp[index][target]=faith1 || faith2;
            }
        }

        return dp[0][sum];
    }

    // Since row i ke kisi bhi element ko calculate krne ke liye row (i+1) ke kisi bhi element ki jarurat padh skti hai toh
    // space optimization mai row use krege.

}
