package DP.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    // It is same as 2nd part bas sell krne vaale case mai index+1 ki jagah index+2 par jaao
    // Also index+2 krne se 2 length ek saath badh gayi toh base case mai index==n ki jagah index>=n ka lagado
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]= new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }
        return func(prices,0,0,dp);
    }
    // Apan ko dp[isCarryingStock] access krne ke liye use integer mai use krna hoga toh 0 represents ki stock nhi hai, 1 means stock hai
    public int func(int arr[],int index,int isCarryingStock,int dp[][]){
        // base case mai 0 profit return krdo jisse kuch farak na pade
        if(index>=arr.length){return 0;}

        if(dp[index][isCarryingStock]!=-1){return dp[index][isCarryingStock];}

        // do nothing, because may be the current stock is very costly to buy, or very cheap to sell
        int faith1=func(arr,index+1,isCarryingStock,dp);

        // buy the stock if you don't have any yet, and decrease the profit since you are buying stock
        int faith2=Integer.MIN_VALUE;
        if(isCarryingStock==0){
            faith2=func(arr,index+1,1,dp)-arr[index];
        }

        // sell the stock if you are carrying one, and increase the profit since you are selling stock
        int faith3=Integer.MIN_VALUE;
        if(isCarryingStock==1){
            faith3=func(arr,index+2,0,dp)+arr[index];
        }

        dp[index][isCarryingStock] = Math.max(faith1,Math.max(faith2,faith3));

        return dp[index][isCarryingStock];
    }

}
