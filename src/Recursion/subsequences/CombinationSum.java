package Recursion.subsequences;

import java.util.*;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
 *  of at least one of the chosen numbers is different.
 */

 /**
  * So this question is same as PrintingSubsequenceWhoseSumIsK
  * */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(target<0){return new ArrayList<>();}

        if(target==0){
            // positive base case
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }

        List<List<Integer>> ans=new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> ithFaith=combinationSum(candidates,target-candidates[i]);
            // Since ith faith mai vo saare subsequences hai jika sum target-candidates[i] hai toh uske saare
            // subsequences mai agar apan candidates[i] add krde toh unka sum target ho jaaega
            for (List<Integer> subsequence:ithFaith){
                subsequence.add(candidates[i]);
            }
            // Now add ithFaith to ans
            ans.addAll(ithFaith);
        }

        return ans;
    }

    /**
     * This is good, but the problem is we it is for the candidates = [2,3,6,7], target = 7,
     * it is giving output-:[[3,2,2],[2,3,2],[2,2,3],[7]] , but they want unique subsequence
     * expected-[[2,2,3],[7]]
     * */

    public static Set<List<Integer>> func(int[] candidates, int target) {

        if(target<0){return new HashSet<>();}

        if(target==0){
            // positive base case
            Set<List<Integer>> ans=new HashSet<>();
            ans.add(new ArrayList<>());
            return ans;
        }

        Set<List<Integer>> ans=new HashSet<>();

        for (int i = 0; i < candidates.length; i++) {
            Set<List<Integer>> ithFaith=func(candidates,target-candidates[i]);
            // Since ith faith mai vo saare subsequences hai jika sum target-candidates[i] hai toh uske saare
            // subsequences mai agar apan candidates[i] add krde toh unka sum target ho jaaega
            for (List<Integer> subsequence:ithFaith){
                subsequence.add(candidates[i]);
                Collections.sort(subsequence);
            }
            // Now add ithFaith to ans
            ans.addAll(ithFaith);
        }

        return ans;
    }

     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans=new ArrayList<>(func(candidates,target));
         return ans;
     }


         public static void main(String[] args) {



    }
}
