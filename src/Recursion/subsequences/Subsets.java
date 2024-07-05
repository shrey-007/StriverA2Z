package Recursion.subsequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> func(int[] nums,int index,List<List<Integer>> list) {

        // This checks if index has reached the length of the array nums. If it has, it means we have processed all
        // elements, and we return the current list of subsequences.
        if (index == nums.length) {
            return list;
        }

        // Here, newList is created as a copy of the current list. This is important to ensure that we do not modify
        // the original list while iterating over it.
        /**
         *  let list = {[],[1],[2],[1,2]} and index points to 3
         * */
        List<List<Integer>> newList = new ArrayList<>(list); // Copy the existing list
        // kiuki hum original list ko iterate kr rhe hai toh usi mai changes krege toh problem aaegi isliye new list banai

        /**
         *  let newList = {[],[1],[2],[1,2]}
         * */

        for (List<Integer> currentList : list) {
            List<Integer> newSubsequence = new ArrayList<>(currentList);
            newSubsequence.add(nums[index]);
            newList.add(newSubsequence);
        }

        /**
         *  1st Iteration-:
         *  currentList=[]
         *  newSubsequence=[3]
         *  newList={[],[1],[2],[1,2],[3]}
         *
         *  2nd Iteration-:
         *  currentList=[1]
         *  newSubsequence=[1,3]
         *  newList={[],[1],[2],[1,2],[3],[1,3]}
         *
         *  3nd Iteration-:
         *  currentList=[2]
         *  newSubsequence=[2,3]
         *  newList={[],[1],[2],[1,2],[3],[1,3],[2,3]}
         *
         *  4th Iteration-:
         *  currentList=[1,2]
         *  newSubsequence=[1,2,3]
         *  newList={[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]}
         *
         * */


        /**
         *  Now the newList we created is passed on to next call of the function
         * */
        return func(nums, index + 1, newList);

    }

    public static void main(String[] args) {

        int [] nums={1,2,3};

        List<List<Integer>> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        list.add(list1);

        func(nums,0,list);
        System.out.println(list);

    }
}
