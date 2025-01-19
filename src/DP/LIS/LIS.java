package DP.LIS;

import java.util.ArrayList;

public class LIS {
    // this is striver code-:
    // I am not using lastNumber since usse memoization mai problem hogi
    // since there is a constraint ki nums[i] negative bhi ho skta hai toh dp array mai shifting krni padegi, usse
    // achha hai ki hum lastIndex use kre
    public int recursion(int arr[],int index,int lastIndex){
        if(index==arr.length){
            return 0;
        }
        // take only if current is bigger than last
        // or there is no lastIndex(lastIndex=-1), means this is the first element we are taking
        int faith1 = Integer.MIN_VALUE;
        if(lastIndex==-1 || arr[index]>arr[lastIndex]){
            faith1 = recursion(arr,index+1,arr[index])+1;
        }

        int faith2 = recursion(arr,index+1,index);
        return Math.max(faith2,faith1);
    }

    // index varies from 0 to n-1 (n elements)
    // lastIndex varies from -1 to n-1 (n+1 elements) so do a cordinate change
    // so just create n*n+1 size array
    // remember baaki sab same rahega , bas dp array mai hota hai coordinate shift
    public int memoization(int arr[],int index,int lastIndex,int dp[][]){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][lastIndex+1]!=-1) return dp[index][lastIndex+1];
        
        // take only if current is bigger than last
        int faith1 = Integer.MIN_VALUE;

        if(lastIndex==-1 || arr[index]>arr[lastIndex]){
            faith1 = memoization(arr,index+1,index,dp)+1;
        }

        // not take
        int faith2 = memoization(arr,index+1,lastIndex,dp);
        
        dp[index][lastIndex+1] = Math.max(faith2,faith1);
        return Math.max(faith2,faith1);
    }



    // f(index,lastIndex) means find the LIS starting from index "index" with lastIndex as "lastIndex"
    // we will start recursion from f(0,-1) means find the LIS from 0th index with lastIndex = -1, means last element koi nhi hai

    // f(3,0) means find length of lis from index 3, whose previous index is 0


    // now for the memoization , if were ourselve dealing with the case index=n, but here in tabulation, we have to do it in dp array
    // so index-> 0 to n(n+1 size)
    // lastIndex-> (-1 to n-1) (n+1 size)
    static int tabulation(int arr[]){
        int n = arr.length;

        int dp[][]=new int[n+1][n+1];

        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = 0 + dp[ind+1][prev_index +1];

                int take = 0;

                // we can take if prev_index(means this is the first element we are taking)
                // or current is bigger then previous
                if(prev_index == -1 || arr[ind] > arr[prev_index]){

                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][prev_index+1] = Math.max(notTake,take);
            }
        }

        // the answer is in f(0,-1) means dp[0][-1] , since we have done shifting so answer is dp[0][-1+1] = dp[0][0]
        return dp[0][0];
    }

    static ArrayList<Integer> printLIS(int arr[]){
        // skip this
        return null;
    }

}
