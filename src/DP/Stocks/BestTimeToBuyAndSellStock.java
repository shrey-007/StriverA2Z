package DP.Stocks;

public class BestTimeToBuyAndSellStock {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
     * the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * */
    public static int maxProfit(int[] prices){
        // Assuming i bought at infinite price and sold at 0 price, earning 0 profit
        int buy=Integer.MAX_VALUE;
        int sell=0;
        int profit=0;

        for (int currentDay = 0; currentDay < prices.length; currentDay++) {
            if(prices[currentDay]<buy){
                // then you should buy at this day
                buy=prices[currentDay];
            }
            else{
                // then you can sell at this day
                sell=prices[currentDay];
                // Since i sold it, so i must update my profit
                profit=Math.max(profit,sell-buy);
            }
        }

        return profit;
    }

    /***
     * You can also think int this way-:
     * 1. Agar mai ith day pr sell karuga toh socho mujhe konse day par buy krna chaiye?
     * 2. Answer is (0 to i-1) jo bhi sabse chota hai us din buy krlo
     * 3. Toh har i ke liye mujhe (0 to i-1) ka min chaiye
     * 4. Toh ya pehle i ko iterate kro then har i ke liye 0 to i-1 ka min nikaalne ke liye iterate kro toh n2 ho jaaegi complexity
     * 5. So do one thing if you are at kth index and you know the min from (0 to k-1), so if you reach k+1 then how can you find min for (0 to k), simple it will be either arr[k] or min from 0 to k-1
     *   i.e
     *   min from 0 to k = (min from 0 to k-1 which is already known) or arr[k]
     * */

    public int func(int prices[]){
        int n=prices.length;
        int profit=0;
        int min=Integer.MAX_VALUE; // at ith index it points to the min from 0 to i-1

        for (int i = 0; i <n ; i++) {
            // find what will be the cost if you sell today
            int cost=prices[i]-min;
            // update the profit, if its possible
            profit=Math.max(profit,cost);

            // update the min
            min=Math.min(min,prices[i]);
        }

        return profit;
    }
    // We are remembering the past(min from 0 to i-1) thats why it is also a dp problem



}
