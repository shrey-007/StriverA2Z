package Recursion.subsequences;

import java.util.*;

/**
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets.
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order*/
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>(func(nums,0));
        return ans;
    }

    public Set<ArrayList<Integer>> func(int arr[], int index){
        if(index==arr.length){
            Set<ArrayList<Integer>> ans=new HashSet<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        Set<ArrayList<Integer>> faith=func(arr,index+1);
        // faith will give all unique subets from index+1 to n-1
        // Now in all those list once we add arr[index] and once we don't
        Set<ArrayList<Integer>> ans=new HashSet<>();
        for (ArrayList<Integer> subset:faith){
            ArrayList<Integer> temp1=new ArrayList<>(subset);
            ArrayList<Integer> temp2=new ArrayList<>(subset);
            temp2.add(arr[index]);
            Collections.sort(temp1);
            Collections.sort(temp2);
            ans.add(temp1);
            ans.add(temp2);
        }
        return ans;
    }

    // But you should not do it in this way, Instead tou should do it in this way-:
    public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int i = ind;i<nums.length;i++) {
            if(i!=ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }

    }
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

}
