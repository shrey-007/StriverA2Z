package DP.Stocks;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock
 * at any time.
 * Find and return the maximum profit you can achieve.
 * */

import java.util.Arrays;

/**
 * B=buy , S=sell , N= do nothing
 * Suppose array irregular hai , kabhi badh rha hai kabhi kam. Toh agar apan BSBSBSBS ese kre jisme kuch BS mai profit
 * aaye and kuch BS mai loss ho ans overall profit nikaal le
 * But esa bhi ho skta hai ki BNNNNNNS ans BS mai bhut profit kama liya
 * Toh kuch bhi ho skta hai , we have to try all possible thing
 * */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        return func(prices,0,false);
    }
    // Agar apan ke pass stock already hai toh apan vaapis nhi le leste jab tak sell nhi krte means we can't do BBBSSS , but we can BSBSBS
    // Toh ek variable ye bataega ki currently stock hai apne paas ki nhi
    // Apan ke paas 3 option hai -: kuch mt kro us din, khareedo, becho so try them all and return the max profit
    public int func(int arr[],int index,boolean isCarryingStock){
        // base case mai 0 profit return krdo jisse kuch farak na pade
        if(index==arr.length){return 0;}

        // do nothing, because may be the current stock is very costly to buy, or very cheap to sell
        int faith1=func(arr,index+1,isCarryingStock);

        // buy the stock if you don't have any yet, and decrease the profit since you are buying stock
        int faith2=Integer.MIN_VALUE;
        if(!isCarryingStock){
            faith2=func(arr,index+1,true)-arr[index];
        }

        // sell the stock if you are carrying one, and increase the profit since you are selling stock
        int faith3=Integer.MIN_VALUE;
        if(isCarryingStock){
            faith3=func(arr,index+1,false)+arr[index];
        }

        return Math.max(faith1,Math.max(faith2,faith3));
    }

    // memoization
    public int maxProfit2(int[] prices) {
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
        if(index==arr.length){return 0;}

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
            faith3=func(arr,index+1,0,dp)+arr[index];
        }

        dp[index][isCarryingStock] = Math.max(faith1,Math.max(faith2,faith3));

        return dp[index][isCarryingStock];
    }

}
