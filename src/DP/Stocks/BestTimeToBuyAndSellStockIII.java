package DP.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    // It is same as 2nd part bas isme sirf 2 transactions kr skte hai
    // Toh ek counter rakhlo to count number of transactions
    // Just update one base case when number of transactions>2 , rest everything will be same
    public int maxProfit(int[] prices) {
        return func(prices,0,false,0);
    }
    public int func(int arr[],int index,boolean isCarryingStock,int numberOfTransactions){
        // This is the only change in the code, rest everything is same
        // negative base case
        if(numberOfTransactions>2){return (int)-1e9;}
        // base case mai 0 profit return krdo jisse kuch farak na pade
        if(index==arr.length){return 0;}

        // do nothing, because may be the current stock is very costly to buy, or very cheap to sell
        int faith1=func(arr,index+1,isCarryingStock,numberOfTransactions);

        // buy the stock if you don't have any yet, and decrease the profit since you are buying stock
        int faith2=Integer.MIN_VALUE;
        if(!isCarryingStock){
            faith2=func(arr,index+1,true,numberOfTransactions+1)-arr[index];
        }

        // sell the stock if you are carrying one, and increase the profit since you are selling stock
        int faith3=Integer.MIN_VALUE;
        if(isCarryingStock){
            faith3=func(arr,index+1,false,numberOfTransactions)+arr[index];
        }

        return Math.max(faith1,Math.max(faith2,faith3));
    }



    // memoization
    public int maxProfit2(int[] prices) {
        int n=prices.length;
        int dp[][][]= new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(prices,0,0,dp,0);
    }
    // Apan ko dp[isCarryingStock] access krne ke liye use integer mai use krna hoga toh 0 represents ki stock nhi hai, 1 means stock hai
    public int func(int arr[],int index,int isCarryingStock,int dp[][][],int numberOfTransactions){
        // negative base case
        if(numberOfTransactions>2){return (int)-1e9;}

        // base case mai 0 profit return krdo jisse kuch farak na pade
        if(index==arr.length){return 0;}

        if(dp[index][isCarryingStock][numberOfTransactions]!=-1){return dp[index][isCarryingStock][numberOfTransactions];}

        // do nothing, because may be the current stock is very costly to buy, or very cheap to sell
        int faith1=func(arr,index+1,isCarryingStock,dp,numberOfTransactions);

        // buy the stock if you don't have any yet, and decrease the profit since you are buying stock
        int faith2=Integer.MIN_VALUE;
        if(isCarryingStock==0){
            faith2=func(arr,index+1,1,dp,numberOfTransactions+1)-arr[index];
        }

        // sell the stock if you are carrying one, and increase the profit since you are selling stock
        int faith3=Integer.MIN_VALUE;
        if(isCarryingStock==1){
            faith3=func(arr,index+1,0,dp,numberOfTransactions)+arr[index];
        }

        dp[index][isCarryingStock][numberOfTransactions] = Math.max(faith1,Math.max(faith2,faith3));

        return dp[index][isCarryingStock][numberOfTransactions];
    }

}
