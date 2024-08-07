package DP.subsequences;

/**
 * Given N items where each item has some weight and profit associated with it and also given a bag with capacity W,
 * [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of
 * profits associated with them is the maximum possible.
 *
 * Note: The constraint here is we can either put an item completely into the bag or cannot put it at all
 * [It is not possible to put a part of an item into the bag].
 * */
public class ZeroOneKnapSack {

    // Greedy will not work here
    // Because there is no uniformity, because for more weight profit is less, and for less weight profit is more.
    // So we try to find all possible combinations. And we can do this using Recursion

    public int zeroOneKnapSack(int weight[],int profit[],int maxWeight){
        return func(weight,profit,0,maxWeight);
    }

    public int func(int weight[],int profit[],int index,int currentWeight){

        if(currentWeight<0){return Integer.MIN_VALUE;}
        if(currentWeight==0){return 0;}
        if(index==weight.length){return 0;}

        // take current element
        int faith1=func(weight,profit,index+1,currentWeight-weight[index])+profit[index];
        // dont take current element
        int faith2=func(weight,profit,index+1,currentWeight);

        return Math.max(faith1,faith2);

    }

    public int func(int weight[],int profit[],int index,int currentWeight,int dp[][]){

        if(currentWeight<0){return Integer.MIN_VALUE;}
        if(currentWeight==0){return 0;}
        if(index==weight.length){return 0;}

        if(dp[index][currentWeight]!=-1){return dp[index][currentWeight]; }

        // take current element
        int faith1=func(weight,profit,index+1,currentWeight-weight[index],dp)+profit[index];
        // dont take current element
        int faith2=func(weight,profit,index+1,currentWeight,dp);

        dp[index][currentWeight]=Math.max(faith1,faith2);

        return dp[index][currentWeight];
    }

    public int tabulation(int weight[],int profit[],int maxWeight){
        int dp[][]=new int[weight.length][maxWeight+1];

        // base case is, If are on last index and maxWeight is bigger than weight of current item then we can add its profit
        for (int remainingWeight = 0; remainingWeight < dp[0].length; remainingWeight++) {
            if(remainingWeight>=weight[dp.length-1]){
                dp[dp.length-1][remainingWeight]=profit[dp.length-1];
            }
        }

        // Another base case is, If maxWeight is 0 then none could be taken, so profit is zero, But ye krne ki jarurat nhi hai matrix
        // already default value 0 se bhari hui hai
        for (int row= 0; row< dp.length; row++) {
            dp[row][0]=0;
        }

        for (int index = dp.length-2; index >=0 ; index--) {
            for (int remainingWeight = dp[0].length-1; remainingWeight >0 ; remainingWeight--) {
                // We have 2 options we take it or not

                // take
                // but before taking check whether it could be taken or not, agar remainingWeight>weight of item hoga , tabhi take kr skte hai
                // And agar take kr skte hai toh uske baad index+1 hoga and remaining weight=remaining weight-weight of item hoga.
                int faith1=Integer.MIN_VALUE;
                if(remainingWeight>=weight[index]){faith1=profit[index]+dp[index+1][remainingWeight-weight[index]];}

                // not take
                // is case mai index+1 hoga and remaining weight vesa hi rahega
                int faith2=dp[index+1][remainingWeight];

                // assign answer
                dp[index][remainingWeight]=Math.max(faith1,faith2);
            }
        }

        return dp[0][maxWeight];
    }

}
