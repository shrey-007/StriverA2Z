package Recursion.subsequences;

import java.util.*;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
 *  of at least one of the chosen numbers is different.
 */

 /**
  * So this question is same as PrintingSubsequenceWhoseSumIsK
  * */

 /**
  * CombinationSum mai list of subsequences return krni hai jinka sum target ho and ek element ko kitni bhi baar le skte
  * hai, toh take vaale case mai index pass krna. CombinationSumII mai bhi same hi kaam krna hai bas ek element ko ek baar
  * le skte hai subsequence mai toh take vaale case mai index+1 pass krdo. So these two are easy questions. But problem
  * tab aati hai jab inme unique subsequence return krne hai jiska method CombinationSumII mai diya hai
  * */
public class CombinationSum {

     // Ek baar mai saare kaam mat kro
     // Pehle normal solve kro, duplicates ko bhi aane do
     public static List<List<Integer>> combinationSum(int[] candidates, int target,int index) {
         if(target<0 || index==candidates.length){
             // negative base case
             return new ArrayList<>();
         }
         if(target==0){
             // positive base case
             List<List<Integer>> ans=new ArrayList<>();
             ans.add(new ArrayList<>());
             return ans;
         }

        // agar mutiple baar same element ko le skte hai toh ye hota hai-:

         // take , but don't increase the index
         List<List<Integer>> faith1=combinationSum(candidates,target-candidates[index],index);

         // not take and increase the index
         List<List<Integer>> faith2=combinationSum(candidates,target,index+1);

         // since faith1 mai take kra hai toh sabme current element ko add krna padega
         for (List<Integer> currentList:faith1){
             currentList.add(candidates[index]);
         }

         List<List<Integer>> ans=new ArrayList<>();
         ans.addAll(faith1);
         ans.addAll(faith2);

         return ans;
     }

    /**
     * This is good, but the problem is for the candidates = [2,3,6,7], target = 7,
     * it is giving output-:[[3,2,2],[2,3,2],[2,2,3],[7]] , but they want unique subsequence
     * expected-[[2,2,3],[7]]
     * Striver ne iska solution nhi diya hai, toh uper vaala code padho bas
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

     // see uper functional recursion use kara hai toh vapis aate hue answer mil rha hai, but agar apan ne parameter use
     // kara hota toh aage jaate time answer milta
     // since isme aage jaate time answer milega toh kahi par store krna padega answr ko(currentAns and ans)
    public static void func(int index,int arr[],int target,List<Integer> currentAns,List<List<Integer>> ans){
        if(index==arr.length){
            if(target==0) {
                ans.add(currentAns);
            }
            else return;
        }
        // take, but don't increase the index since we can take same element multiple times
        currentAns.add(arr[index]);
        func(index,arr,target-arr[index],currentAns,ans);

        // not take
        currentAns.remove(Integer.valueOf(arr[index]));
        func(index+1,arr,target,currentAns,ans);
    }



}
