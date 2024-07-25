package Recursion.subsequences;

import java.util.ArrayList;

public class PrintAllSubsequences {
    public static void func(int arr[], int index, ArrayList<Integer> currentSubSequence){
        if (arr.length==index){
            System.out.println(currentSubSequence);
            return;
        }
        // add the current element to the subsequence
        currentSubSequence.add(arr[index]);
        func(arr,index+1,currentSubSequence);

        // don't add the current element to the subsequence
        currentSubSequence.remove(Integer.valueOf(arr[index]));
        func(arr,index+1,currentSubSequence);

    }

    // If we are asked to return all the subsequences
    public static ArrayList<ArrayList<Integer>> func(int arr[],int index){

        if(index==arr.length){
            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }

        // get all subsequences from index+1 to last
        ArrayList<ArrayList<Integer>> faith=func(arr,index+1);

        // Now in every subsequence once you have to add it and once don't
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < faith.size(); i++) {
            ArrayList<Integer> temp1=new ArrayList<>(faith.get(i));
            ArrayList<Integer> temp2=new ArrayList<>(faith.get(i));
            temp2.add(0,arr[index]);
            ans.add(temp1);
            ans.add(temp2);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        func(arr,0,new ArrayList<>());
        System.out.println("ji");
        System.out.println(func(arr,0));
    }
}
