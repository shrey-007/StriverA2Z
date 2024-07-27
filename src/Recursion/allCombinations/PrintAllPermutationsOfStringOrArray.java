package Recursion.allCombinations;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutationsOfStringOrArray {
    /**
     * 1. Since saare characters kabhi na kabhi aaega toh NOT TAKEN vaali calls nhi hogi
     * 2. Hume ye pta krna hai ki konse elements le liye hai uske liye flag array hai, agar string hoti toh (String remainingString) use krte
     * */
    public static void func(int arr[], boolean flag[], int numberOfElementsTaken, ArrayList<Integer> current,List<List<Integer>> ans){
        if(numberOfElementsTaken==arr.length){
            // means all elements are taken
            // Agar ans.add(current) kroge toh galat ans aaega
            /**The issue with your code lies in the func method where you add current directly to ans.
             * When you do this, you add a reference to the same current list throughout the recursion, which gets
             * modified. Instead, you should add a copy of current to ans.
             **/
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(flag[i]==false){
                // means this element is not taken, you can take it
                current.add(arr[i]);
                flag[i]=true;
                func(arr,flag,numberOfElementsTaken+1,current,ans);
                // vo saare permutations store ho chuke hai jinme arr[i] pehle aa rha hai.
                // Ab hume vo permutations laane hai jisme arr[i+1] pehel aa rha hai, and unme abhi arr[i] nhi liya hai
                // vo baad mai lenge toh aga nhi liya toh usko flag , currentAns se hatao
                current.remove(Integer.valueOf(arr[i]));
                flag[i]=false;
            }
        }
    }
    /**
     * Solve this Leetcode Problem 47-:
     * Usme array mai duplicate elements bhi hai and tumhe only unique combinations chaiye -:*/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        func(nums,new boolean[nums.length],0,new ArrayList<>(),ans);
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(permute(nums));
    }


}
