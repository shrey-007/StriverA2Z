package arrays.medium;

/*
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {
    /*
     method1=try all possible case maan lo index 0 per buy kra toh 1 se end tak check kro kisme max profit hai
     fir maan lo index 1 pr buy kra toh 2 se end dekho kisme max profit hai
     and so on i pr maano buy kra and i+1 se n-1 tak dekho kisme jyaada profit hai
    */

    static int func(int arr[]){
        //initial profit is zero
        int profit=0;

        //maan lo day 0th index mai buy kra
        int buy=arr[0];

        //now traverse kro
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>buy){
                //means ki agar mai i mai sell kru toh profit hai.so this could be our answer.
                profit=Math.max(profit,arr[i]-buy);
            }
            else{
                //means ki i mai buy kru toh profit hai.
                buy=arr[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
           int arr[]={5,2,7,1,6,2,9,2,7,5};

           //dry run
           /*
           profit=0, buy=5
           2 aaya toh agar 2 ko buy kre toh sahi rahega= buy=2,profit=0
           7 aaya toh 7 ko buy krne ka sense nhi h, toh sell krege but ho skta hai 7 se jyada mai sell kre but pehle current profit store krlo= profit=5,buy=2
           1 aaya toh usper buy krna sahi rahega, now comes important part.2->7 ka ans already stored h profit mai toh vo lost nhi hua. also agar 7 se bada koi aur number aaya(let 9) toh 2->9 hona chaiye but 1->9 bhi koi problem nhi krega balki aur achha option hai. means ki chota number aaye toh uspr buy kro but puraana result store krlo bas toh data lost nhi hoga.
           */


    }
}
