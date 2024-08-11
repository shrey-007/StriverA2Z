package DP.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    // It is same as 3rd part , usme 2 transactions kr skte the, isme k hai
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][][]= new int[n][2][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(prices,0,0,dp,0,k);
    }

    // Apan ko dp[isCarryingStock] access krne ke liye use integer mai use krna hoga toh 0 represents ki stock nhi hai, 1 means stock hai
    public int func(int arr[],int index,int isCarryingStock,int dp[][][],int numberOfTransactions,int k){
        // negative base case
        if(numberOfTransactions>k){return (int)-1e9;}

        // base case mai 0 profit return krdo jisse kuch farak na pade
        if(index==arr.length){return 0;}

        if(dp[index][isCarryingStock][numberOfTransactions]!=-1){return dp[index][isCarryingStock][numberOfTransactions];}

        // do nothing, because may be the current stock is very costly to buy, or very cheap to sell
        int faith1=func(arr,index+1,isCarryingStock,dp,numberOfTransactions,k);

        // buy the stock if you don't have any yet, and decrease the profit since you are buying stock
        int faith2=Integer.MIN_VALUE;
        if(isCarryingStock==0){
            faith2=func(arr,index+1,1,dp,numberOfTransactions+1,k)-arr[index];
        }

        // sell the stock if you are carrying one, and increase the profit since you are selling stock
        int faith3=Integer.MIN_VALUE;
        if(isCarryingStock==1){
            faith3=func(arr,index+1,0,dp,numberOfTransactions,k)+arr[index];
        }

        dp[index][isCarryingStock][numberOfTransactions] = Math.max(faith1,Math.max(faith2,faith3));

        return dp[index][isCarryingStock][numberOfTransactions];
    }
}
