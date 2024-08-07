package DP.subsequences;

import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        return func(coins,amount,0);
    }
    public int func(int coins[],int amount,int index){
        if(amount==0){return 1;}
        if(amount<0){return 0;}

        if(index==coins.length){
            return 0;
        }
        // take
        // amount reduce kro but index vaisa hi rehne do
        int faith1=func(coins,amount-coins[index],index);
        // not take
        int faith2=func(coins,amount,index+1);

        return faith2+faith1;
    }

    // memoization
    public int change2(int amount, int[] coins) {

        int n=coins.length;

        int dp[][]=new int[n][amount+1];
        for (int i = 0; i <n ; i++) {
            Arrays.fill(dp[i],-1);
        }
        return func(coins,amount,0,dp);
    }
    public int func(int coins[],int amount,int index,int dp[][]){
        if(amount==0){return 1;}
        if(amount<0){return 0;}

        if(index==coins.length){
            return 0;
        }
        if(dp[index][amount]!=-1){return dp[index][amount];}
        // take
        // amount reduce kro but index vaisa hi rehne do
        int faith1=func(coins,amount-coins[index],index,dp);
        // not take
        int faith2=func(coins,amount,index+1,dp);

        dp[index][amount]=faith1+faith2;

        return faith2+faith1;
    }

}
