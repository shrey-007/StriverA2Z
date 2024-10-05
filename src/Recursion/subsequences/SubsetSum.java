package Recursion.subsequences;

import java.util.ArrayList;

/**
 * Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.
 */
public class SubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        return func(arr,0);
    }

    // functional recursion
    ArrayList<Integer> func(ArrayList<Integer> arr,int index){
        if(index==arr.size()){
            // Base case ke liye dry run krlo
            ArrayList ans=new ArrayList<>();
            ans.add(0);
            return ans;
        }

        ArrayList<Integer> faith=func(arr,index+1);
        // faith will return sum of all subsets from index+1 to n-1
        // Agar faith mai ke saare sum mai ek baar arr[index] add kre and ek baar nhi kre toh it will give all sums of
        // subsets from index to n-1
        ArrayList<Integer> ans=new ArrayList<>();
        for (int subsetSum:faith){
            ans.add(subsetSum);
            ans.add(subsetSum+arr.get(index));
        }
        return ans;
    }

    // we can also do it parameterised
    // Pehle apan parameterised recursion ka use krke print krvaate the, but apan parameterised recursion ka use krke
    // ans bhi laa skte hai return value void hi hogi coz. Bas ans ko and temporaryAns ko parameter mai paas krege and jab bhi
    // positive base case aaega toh temporaryAns ko ans mai add krdenge.Bas constraint yahi hai ki ans has to be object tabhi
    // vo modify hoga, like in Trees questions apan yahi use kr rhe the but usme ans int tha jo ki modify nhi hoga agar
    // parameter mai bhejege toh , int ans[1] krke bheja tha use.
    // This parameterised recursion is always easier than functional recursion
    public void func(ArrayList<Integer> arr,int index,int currSum,ArrayList<Integer> ans){
        if(index==arr.size()){
            ans.add(currSum);
            return ;
        }

        func(arr,index+1,currSum+arr.get(index),ans);
        func(arr,index+1,currSum,ans);
    }

}
