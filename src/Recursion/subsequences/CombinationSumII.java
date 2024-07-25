package Recursion.subsequences;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>(func(candidates,target,0));
        return ans;
    }

    // This code is from PrintingSubsequencesWHoseSumIsK with minor changes
    public static Set<List<Integer>> func(int arr[], int k, int index){

        // return null arraylist for negative base cases
        if(k<0){return new HashSet<>();}

        if(index==arr.length){
            // return empty positive base case
            if(k==0){
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
        Set<List<Integer>> faith1=func(arr,k-arr[index],index+1);
        // Since faith1 vo saare subsequences hai jinka sum k-arr[index] hai toh agar uske saare subsequences mai
        // apan arr[index] add krde toh sabka sum k hojaaega
        for(List<Integer> subsequence:faith1){
            subsequence.add(arr[index]);
            Collections.sort(subsequence);
        }


        // not take
        Set<List<Integer>> faith2=func(arr,k,index+1);

        ans.addAll(faith1);
        ans.addAll(faith2);

        return ans;
    }
}
