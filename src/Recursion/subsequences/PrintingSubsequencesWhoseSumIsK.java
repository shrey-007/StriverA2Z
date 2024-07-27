package Recursion.subsequences;

import java.util.ArrayList;

public class PrintingSubsequencesWhoseSumIsK{

    //if we have to print all subsequences
    public static void func(int arr[], int k, int index, ArrayList<Integer> currentSubsequence,int currentSum){
        // negative base case
        if(currentSum>k){return;}

        if(arr.length==index){
            if(currentSum==k){System.out.println(currentSubsequence);}
            return;
        }

        // take it
        currentSum=currentSum+arr[index];
        currentSubsequence.add(arr[index]);
        func(arr,k,index+1,currentSubsequence,currentSum);

        // not take
        currentSum=currentSum-arr[index];
        currentSubsequence.remove(Integer.valueOf(arr[index]));
        func(arr,k,index+1,currentSubsequence,currentSum);

    }

    // if we have to print only one subsequence

    public static boolean func2(int arr[], int k, int index, ArrayList<Integer> currentSubsequence,int currentSum){

        // return false in negative base case
        if(currentSum>k){return false;}

        if(arr.length==index){
            if(currentSum==k){System.out.println(currentSubsequence);}
            // return true in positive base case
            return true;
        }

        // take it
        currentSum=currentSum+arr[index];
        currentSubsequence.add(arr[index]);
        boolean flag=func2(arr,k,index+1,currentSubsequence,currentSum);
        // if this already ave you answer then don't further call
        if(flag){return true;}

        // not take
        currentSum=currentSum-arr[index];
        currentSubsequence.remove(Integer.valueOf(arr[index]));
       flag= func2(arr,k,index+1,currentSubsequence,currentSum);
       if (flag){return true;}

       return false;
    }



    // If we have to return subsequences
    public static ArrayList<ArrayList<Integer>> func(int arr[],int k,int index){

        // return null arraylist for negative base cases
        if(k<0){return new ArrayList<>();}

        if(index==arr.length){
            // return empty positive base case
            if(k==0){
                ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
                ans.add(new ArrayList<>());
                return ans;
            }
            else{
                // negative base case
                return new ArrayList<>();
            }
        }

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        // take
        ArrayList<ArrayList<Integer>> faith1=func(arr,k-arr[index],index+1);
        // Since faith1 mai vo saare subsequences hai jinka sum k-arr[index] hai toh agar uske saare subsequences mai
        // apan arr[index] add krde toh sabka sum k hojaaega
        for(ArrayList<Integer> subsequence:faith1){
            subsequence.add(arr[index]);
        }


        // not take
        ArrayList<ArrayList<Integer>> faith2=func(arr,k,index+1);

        ans.addAll(faith1);
        ans.addAll(faith2);

        return ans;
    }

    // if we have to find number of subsequences with sum k
    public static int func(int arr[],int k,int index,int currSum){
        if(index==arr.length){
            // return 1 if condition satisfies
            if(currSum==k){return 1;}
            // return 0 if condition not satisfies
            else return 0;
        }
        // take
        int faith1=func(arr,k,index+1,currSum+arr[index]);
        // not take
        int faith2=func(arr,k,index+1,currSum);

        return faith1+faith2;
    }



    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        func(arr,5,0,new ArrayList<>(),0);
    }
}
