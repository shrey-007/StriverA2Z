package Greedy.easy;

/**
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a
 * time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or
 * $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
 *
 * Note that you do not have any change in hand at first.
 *
 * Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every
 * customer with the correct change, or false otherwise.*/
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        // since it is given that customer will give only 5,10, or 20 dollar bill, so we can create an array for the
        // count of these denominations
        int count[]=new int[3];

        int n=bills.length;
        // start from the first person
        for (int i = 0; i < n; i++) {
            if(bills[i]==5){
                // increase count of 5 dollar coins
                count[0]++;
            }
            else if(bills[i]==10){
                // increase count of 10 dollar coins
                count[1]++;

                // but we have to give him one change of 5 dollar
                // if we dont have 5 dollar coin, return false
                if(count[0]==0){return false;}

                // else reduce count of 5 dollar coin
                count[0]--;
            }
            else{
                // increase count of 20 dollar coins
                count[2]++;

                // Now first try to give him 10,5 change
                if(count[0]>=1 && count[1]>=1){count[0]--;count[1]--;}
                // If we can't give him 10,5 change then try to give 5,5,5 change
                else if(count[0]>=3){count[0]=count[0]-3;}
                else{return false;}
            }
        }

        return true;
    }
}
