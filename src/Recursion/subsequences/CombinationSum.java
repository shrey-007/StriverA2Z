package Recursion.subsequences;

import java.util.ArrayList;
import java.util.List;


public class CombinationSum {
    public static void combinationSum(int[] candidates,int index, int target,List<List<Integer>> ans,List<Integer> curr) {
        if(index== candidates.length){
            // base case
            if(target==0){
                // positive base case
                ans.add(curr);
                return ;
            }
            else {
                // negative base case
                return;
            }
        }



            // pick
            curr.add(candidates[index]);
            combinationSum(candidates,index,target-candidates[index],ans,curr);

            // not pick
            curr.remove(candidates[index]);
            combinationSum(candidates,index+1,target,ans,curr);


    }

    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();
        int candidates[]={1,2,3};
        combinationSum(candidates,0,7,list,new ArrayList<>());

        System.out.println(list);


    }
}
