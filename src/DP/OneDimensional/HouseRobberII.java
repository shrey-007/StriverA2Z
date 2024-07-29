package DP.OneDimensional;

import java.util.Arrays;

public class HouseRobberII {
    /**
     * 1. My answer can not contain both first and last element
     * 2. Toh dono mai se koi ek aaega ya dono hi nhi aaege.
     * 3. Create arr1[0 to n-2] and apply same logic to get answer of house 0 to n-2
     * 4. Create arr1[1 to n-1] and apply same logic to get answer of house 1 to n-1
     * 5. Return answer given by max of both the arrays
     * */
    public int rob(int[] nums) {

        int arr1[]=Arrays.copyOfRange(nums,0,nums.length-1);
        int arr2[]=Arrays.copyOfRange(nums,1,nums.length);

        return Math.max(spaceOptimization(arr1),spaceOptimization(arr2));

    }
    public int spaceOptimization(int arr[]){

        int afterAfter=0;

        // ye test case memoization mai nhi daala tha but yaha daalna padega, else wrong ans aa rha tha
        // Dry run krke nikaal liya kro missing test cases
        int after=arr[arr.length-1];

        for (int index= arr.length-2; index>=0 ; index--) {
            int faith1=after;
            int faith2=Integer.MIN_VALUE;
            faith2=afterAfter+arr[index];

            int curr=Math.max(faith1,faith2);

            afterAfter=after;
            after=curr;
        }


        return after;
    }
}
