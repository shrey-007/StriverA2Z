package BinarySearch.Anwers;

public class KokoEatingBananas {
    /**
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone
     * and will come back in h hours.
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k
     * bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any
     * more bananas during this hour.
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * Return the minimum integer k such that she can eat all the bananas within h hours
     * */


    /**
     Ok so first comes the brute force approach
     1) Apan ko minimum speed chaiye jisme koko apne bananas khaale toh simply 1 se start kro and speed badate jaao jis
        jis speed pr vo finish krle banana vahi answer hai
     2) Since apan i=1 to infinite jaa rhe hai hai and check kr rhe hai ki konsi speed ans hogi toh jo apne answer ki range
        hai vo sorted hai agar x speed pr nhi khaa paayi toh x-1 pr bhi nhi khaa paaegi toh BS lagaya
     */

    /***
     * <h1> HOW TO FIND THIS WILL BE SLOVED USING BS ON ANSWERS</h1>
     *
     * 1. Identify the Search Space
     * The problem asks for the minimum integer k (bananas-per-hour speed) that allows Koko to eat all the bananas within h hours.
     * The possible values of k range from 1 (the slowest speed) to max(piles) (the maximum number of bananas in a single
     * pile, which would be the fastest speed, as Koko could finish any pile in one hour).
     *
     * 2. Define the Problem as a Monotonic Function
     * The key observation here is that if Koko can eat all the bananas at a certain speed k, she can also eat all of them
     * at any speed greater than k. Conversely, if she cannot finish eating at speed k, she won't be able to finish at
     * any speed less than k.
     * This monotonicity means that there exists a minimum value k for which Koko can finish eating all the bananas within
     * h hours. For all values greater than or equal to k, she can also finish in time.*/

    // method 1
    public static int bruteForce(int [] piles,int h){
        int speed=0;

        while (speed<100000000){
            // check whether ki is speed pr kahatam kr legi vo banana ki nhi
            int timeTaken=0;
            for (int i = 0; i <piles.length; i++) {
                if(piles[i]%speed==0){timeTaken=timeTaken+piles[i]/speed;}
                else{timeTaken=timeTaken+piles[i]/speed+1;}
            }

            // toh speed(speed) se agar vo khaaegi toh use timeTake time lagega but use h mai khatam krna hai toh dekho h bada h ki timeTaken
            if(timeTaken>h){
                // means jyaada time laga toh speed badao
                speed++;
            }
            else{
                break;
            }
        }

        return speed;
    }
    public static boolean predicate(int[] piles, int speed,int h){
        int timeInHours=0;

        for (int i = 0; i < piles.length; i++) {
            if(piles[i]%speed==0){timeInHours=timeInHours+piles[i]/speed;}
            else{timeInHours=timeInHours+piles[i]/speed+1;}
        }

        return timeInHours<=h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int start=piles.length;
        int end=1000000000;
        int ans=-1;

        while (end>=start){

            int mid=(start+end)/2;

            if(predicate(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}
