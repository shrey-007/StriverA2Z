package DP.subsequences;

/**
 * Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 *
 * Note: Consider 1-based indexing.
 * */
public class RodCutting {
    public int cutRod(int price[], int n) {
        return func(price,n,1);
    }

    public int func(int price[],int remainingLength,int index){
        // means ki sahi parts mai cut gyi
        if(remainingLength==0){return 0;}
        // means ki galat parts ma cuti hai 8 lenght ki rod 4,5 mai cut gyi jo ki possible nhi hai
        if(remainingLength<0){return Integer.MIN_VALUE;}
        if(index==price.length){
            // means ki abhi rod cuti nhi hai , but aage ke index mai nhi jaa skte
            return func(price,remainingLength-index,index);
        }

        // take, but index same rakho coz same lenght ke parts mai baar baar break kr skte hai
        int faith1=func(price,remainingLength-index,index);
        // not take
        int faith2=func(price,remainingLength,index+1);

        return Math.max(faith1,faith2);
    }

    // memoization
    public int cutRod2(int price[], int n) {
        // Using memoization to avoid recomputation of subproblems
        int[][] dp = new int[n+1][price.length];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < price.length; j++) {
                dp[i][j] = -1;
            }
        }
        return func(price, n, 0, dp);
    }

    public int func(int price[], int remainingLength, int index, int[][] dp){
        // If the remaining length is zero, no more cuts are possible, return 0
        if (remainingLength == 0) {
            return 0;
        }
        // If index exceeds price array length, no more valid cuts are possible, return a very small value
        if (index >= price.length) {
            return (int)-1e9;
        }
        // If result is already computed, return the cached result
        if (dp[remainingLength][index] != -1) {
            return dp[remainingLength][index];
        }
        // Do not take the current index and move to the next index
        int notTake = func(price, remainingLength, index + 1, dp);

        // Take the current index if it's valid (remainingLength >= index + 1)
        int take = (int)-1e9;
        if (remainingLength >= index + 1) {
            take = price[index] + func(price, remainingLength - (index + 1), index, dp);
        }

        // Store and return the maximum of both options
        dp[remainingLength][index] = Math.max(take, notTake);
        return dp[remainingLength][index];
    }

    // tabulation


}
