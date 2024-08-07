package DP.subsequences;

public class CoinChange {
    /**
     * You can not apply greedy-: arr[]={9,6,5,1} target=11
     * Toh greedy 9,1,1 choose krega but ans 5,6 hona chaiye
     * There is no uniformity because denominations mai difference constant nhi hai (9-6)!=(6-5)!=(5-1)
     * So we will try out all possible ways
     * Buy problem here is ki apan ek index(coin) ko kitne bhi times le skte hai , toh ye take not take nhi hai, ye take how many times and not take  hai
     * Toh jab bhi ese questions aaye jinme ek index ko any number of times le skte hai usme take vaale case mai index+1, vese hi rehne do.Not take vaale mai index+1 kro
     * */
    public int coinChange(int[] coins, int amount) {
        return func(coins,0,amount);
    }

    public int func(int []coins,int index,int amount){
        // positive base case
//        if(amount==0){return 0;}
        if(index==coins.length-1){
            if(amount%coins[index]==0){return amount/coins[index];}
            else{return (int)1e9;}
        }

        int faith1=(int)1e9;
        // take
        if(amount-coins[index]>=0)faith1=func(coins,index,amount-coins[index])+1;
        // not take
        int faith2=func(coins,index+1,amount);

        return Math.min(faith1,faith2);
    }

    public int memoization(int []coins,int index,int amount,int dp[][]){
        // positive base case
//        if(amount==0){return 0;}
        if(index==coins.length-1){
            if(amount%coins[index]==0){return amount/coins[index];}
            else{return (int)1e9;}
        }
        if(dp[index][amount]!=-1){return dp[index][amount];}

        int faith1=(int)1e9;
        // take
        if(amount-coins[index]>=0)faith1=memoization(coins,index,amount-coins[index],dp)+1;
        // not take
        int faith2=memoization(coins,index+1,amount,dp);

        dp[index][amount]=Math.min(faith1,faith2);

        return dp[index][amount];
    }

    public int tabulation(int coins[],int amount){
        int dp[][]=new int[coins.length][amount+1];

        for (int amount2 = 0; amount2 <= amount; amount2++) {
            if(amount2%coins[coins.length-1]==0){dp[coins.length-1][amount2]=amount2/coins[coins.length-1];}
            else{dp[coins.length-1][amount2]=(int)1e9;}
        }

        for (int index = dp.length-1; index >=0; index--) {
            for (int amount2 = amount; amount2 >=0 ; amount2--) {
                int faith1=(int)1e9;
                // take
                if(amount2-coins[index]>=0)faith1=dp[index][amount2-coins[index]]+1;
                // not take
                int faith2=(int) 1e9;
                if(index+1<coins.length) faith2=dp[index+1][amount2];

                dp[index][amount2]=Math.min(faith1,faith2);
            }
        }

        if(dp[0][amount]>=1e9){return -1;}
        return dp[0][amount];
    }


}
