package DP.subsequences;

public class PartitionEqualSubsetSum {
    /**
     * This is same question as SubsetSumEqualToTarget , I have used the same tabulation function of that question
     * */
    public boolean canPartition(int[] nums) {
        int sumOfAllElements=0;
        for(int i=0;i<nums.length;i++){
            sumOfAllElements+=nums[i];
        }
        if(sumOfAllElements%2==1){return false;}
        return tabulation(nums,sumOfAllElements/2);
    }
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
}
