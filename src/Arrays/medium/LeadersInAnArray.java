package Arrays.medium;

import java.util.ArrayList;

public class LeadersInAnArray {
    /*
      Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is a
      leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.
     */

    static ArrayList<Integer> leaders(int arr[], int n){

        ArrayList<Integer> ans=new ArrayList<>();
        int max=arr[n-1];
        ans.add(max);



        for(int i=n-2;i>=0;i--){
            if(arr[i]>=max){
                max=arr[i];
                ans.add(0,max);
            }
        }


        return ans;
    }
    public static void main(String[] args) {

    }
}
