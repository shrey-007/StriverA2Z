package Recursion.subsequences;

import java.util.*;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the
 * combinations may be returned in any order
 * */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {

        // since we can use only 1-9 numbers so create an array of 1-9
        int arr[] = {1,2,3,4,5,6,7,8,9};

        // since we can use one number only once so we have to use CombinationSumII approach, but with slight modification
        // we have to use only k numbers.

        List<List<Integer>> ans = new ArrayList<>(combinationSum2(arr,n,0,0,k));

        return ans;
    }

    public static Set<List<Integer>> combinationSum2(int arr[], int target, int index,int numberOfElementsUsed,int k){

        // return null arraylist for negative base cases
        if(target<0 || numberOfElementsUsed>k){return new HashSet<>();}

        if(index==arr.length){
            // return empty positive base case
            if(target==0 && numberOfElementsUsed==k){
                Set<List<Integer>> ans=new HashSet<>();
                ans.add(new ArrayList<>());
                return ans;
            }
            else{
                // negative base case
                return new HashSet<>();
            }
        }

        Set<List<Integer>> ans=new HashSet<>();

        // take
        Set<List<Integer>> faith1=combinationSum2(arr,target-arr[index],index+1,numberOfElementsUsed+1,k);
        // Since faith1 vo saare subsequences hai jinka sum k-arr[index] hai toh agar uske saare subsequences mai
        // apan arr[index] add krde toh sabka sum k hojaaega
        for(List<Integer> subsequence:faith1){
            subsequence.add(arr[index]);
            Collections.sort(subsequence);
        }


        // not take
        Set<List<Integer>> faith2=combinationSum2(arr,target,index+1,numberOfElementsUsed,k);

        ans.addAll(faith1);
        ans.addAll(faith2);

        return ans;
    }



}
