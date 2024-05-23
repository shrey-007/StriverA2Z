package arrays.medium;

import java.util.Arrays;

public class MaximumSubarray {

//    Q = Given an integer array nums, find the subarray with the largest sum, and return its sum.
//    IMPORTANT = DONT GET CONFUSED KI APAN KO SABSE BADA SUBARRAY CHAIYE, ESA NHI HAI , APAN KO SABSE BADA SUM VAALA SUBARRAY CHAIYE.



    // method1 = 2 for loops

    // method2 = KADANES algorithm

    public static int func(int nums[]){

        int maxSum=nums[0];
        int currentSum=nums[0];

        for (int i = 1; i <nums.length ; i++) {
            // now we have to take choice whether to include current element in the subarray or to start a new subarray from this element
            // agar curret element ko subarray mai include krege toh sum=currentSum+nums[i] hoga and agar current element se new subarray start
            // krege toh sum nums[i] hoga ab dekh lo kon bada hai

            // we included
            if(currentSum+nums[i]>nums[i]){
                currentSum=currentSum+nums[i];
            }
            // we didn't included
            else{
                currentSum=nums[i];
            }
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    // FollowUp Question From Striver Sheet = Now we have to print the subarray with maximum sum
    // simply take start and end pointer denoting the start and end index of the subarray and tumhe pata hai ki kab subarray change ho rha hai toh us according start and end ko update kr dena

    public static void func2(int nums[]){

        // start and end index of subarray(but ye chnage hote rahege even after getting the answer)
        int start=0;
        int end=0;

        // ye tabhi change hoge jab answer milege
        int astart=0;
        int aend=0;

        int maxSum=nums[0];
        int currentSum=nums[0];

        for (int i = 1; i <nums.length ; i++) {
            if(currentSum+nums[i]>nums[i]){
                currentSum=currentSum+nums[i];
                end++;    // since isme subarray mai include hua
            }
            else{
                currentSum=nums[i];
                start=i;  // since yaha se new subarray choose kra humne toh start and end yahi hoga
                end=i;
            }
            if(maxSum<currentSum){
                // since start and end frequently change hoge to get the answer but real answer vahi hoga jab last baar currentSum>maxSum hoga toh isliye inko change kra
                maxSum=Math.max(maxSum,currentSum);
                astart=start;
                aend=end;}
        }
        Arrays.stream(nums,astart,aend+1).forEach(i-> System.out.print(i+" "));
        System.out.println();
    }

    // Follow Up question by Leetcode to solve this problem using dp(divide and conquer)

    public static int func3(int index,int nums[],int ans){
        if(index==nums.length){return 0;}
        int faith=func3(index+1,nums,ans);
        if(nums[index]+faith<nums[index]){
            ans=0;
        }
        else{
            ans=ans+nums[index];
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(func(arr));
        func2(arr);
        System.out.println(func3(0,arr,0));

    }

}
