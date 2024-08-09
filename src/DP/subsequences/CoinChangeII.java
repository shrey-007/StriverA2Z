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

    // tabulation
    public int tabulation(int coins[],int amount){
        int n=coins.length;

        int dp[][]=new int[n][amount+1];

        // base case is if the index is anything but amount is 0, then ans will be 1
        for (int index = 0; index < n; index++) {
            dp[index][0]=1;
        }

        // another base case is, if the index=n-1 toh ans tabhi aaega if amount%coins[n-1]==0 kiuki suppose amount 12 hai
        // toh last coin ko 3 baar lelo toh answr aajaega
        for (int remainingAmount = 1; remainingAmount <= amount; remainingAmount++) {
            if(remainingAmount%coins[n-1]==0){
                dp[n-1][remainingAmount]=1;
            }
            // else dp[n-1][remainingAmount] 0 hi rahega
        }

        // fill the dp table
        for (int index = n-2; index >=0; index--) {
            for (int remainingAmount = 1; remainingAmount <= amount; remainingAmount++) {
                int faith1=0;
                if(remainingAmount>=coins[index]) faith1=dp[index][remainingAmount-coins[index]];
                int faith2=dp[index+1][remainingAmount];

                dp[index][remainingAmount]=faith1+faith2;
            }
        }

        return dp[0][amount];
    }

}
