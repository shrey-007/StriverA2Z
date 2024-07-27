package Recursion.subsequences;

import java.util.*;

public class CombinationSumII {

    // Method1-:
    // PrintingSubsequencesWHoseSumIsK hi hai bas , isme duplicates allowed nhi hai toh Set mai store krege and sort krke
    // daalege subsequence ko
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>(func(candidates,target,0));
        return ans;
    }

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

    // Efficient method is(Striver)-:
    /**
     * This is not based on TAKE and NOT TAKE, this is general format for the solutions without duplicates.
     * 1. Sort the given array
     * 2. Isme index nhi hai, jaise pehle hota tha ki us index ko le ya nhi le
     * 3. Instead ,isme startingIndex hai means kis index se start hai hamara subsequence
     * 4. startingIndex ko hamesha include krna hai subsequence mai(NOT TAKE ka option nhi hai), coz jab call kra toh
     *    dekho
     *    findCombinations(i + 1, arr, target - arr[i], ans, ds);      ko call kra hai
     *    findCombinations(i + 1, arr, target, ans, ds);               ko kabhi call nhi kara
     * 5. Simply isme TAKE and NOT TAKE ki jagah hum ye decide krte hai ki konsa index se start kare subsequence ko
     * 6. Also ye use kr rha hai parameterised recursion , but edge case aane pr print krne ki jagah answer(jo parameter mai hai), use update kr rha hai.
     * 6. Watch video
     * . */

    static void findCombinations(int startingIndex, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = startingIndex; i < arr.length; i++) {
            if (i > startingIndex && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public static List < List < Integer >> combinationSum2(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

}
