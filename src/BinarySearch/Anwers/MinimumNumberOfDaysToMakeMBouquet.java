package BinarySearch.Anwers;

/**
 * You are given an integer array bloomDay, an integer m and an integer k.
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible
 * to make m bouquets return -1.
 * */

/**
 *
 * How to find ki ye BS ka hai ki nhi
 * 1. Jis din last flower bloom krega us din tak saare bloom ho jaaege toh voh pakka ans hai, but hume chaiye minimum.
 * 2. Since ek ans hume already pata hai, still usse chota dhoond rhe hai toh BS lagega
 * */

/**
 * How to find ki ye BS ka hai ki nhi
 *
 * Identify the Search Space
 * The problem asks for the minimum number of days needed to make m bouquets, where each bouquet consists of k adjacent flowers.
 * The possible values for the number of days range from min(bloomDay) (the earliest any flower blooms) to max(bloomDay) (the latest any flower blooms).
 *
 * 2. Define the Problem as a Monotonic Function
 * The key observation here is that if you can make m bouquets by waiting for x days, you can also make m bouquets if
 * you wait for any number of days greater than x. Conversely, if you cannot make the bouquets in x days, you won’t be
 * able to make them in any fewer days.
 * This monotonicity indicates that there is a minimum number of days d such that you can create exactly m bouquets. If
 * you can create m bouquets on day d, you can also create them on any day after d.
 * */
public class MinimumNumberOfDaysToMakeMBouquet {
    public static int bruteForce(int[] bloomDay, int m, int k){
        // find the min and max of array
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i]>max){max=bloomDay[i];}
            if(bloomDay[i]<min){min=bloomDay[i];}
        }

        int day=min;

        while (day<=max){

            int bouquets=0;
            int adjacentCount=0;

            for (int i = 0; i < bloomDay.length; i++) {
                if(bloomDay[i]<=day){
                    // means it is bloomed
                    adjacentCount++;
                }
                else{
                    // it is not bloomed
                    adjacentCount=0;
                }
                if(adjacentCount==k){
                    adjacentCount=0;
                    bouquets++;
                }
            }

            if(bouquets>=m){return day;}
            else{day++;}
        }

        if(day>max){return -1;}

        return day;
    }

    public static int binarySearch(int[] bloomDay, int m, int k){

        // find the min and max of array
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i]>max){max=bloomDay[i];}
            if(bloomDay[i]<min){min=bloomDay[i];}
        }

        int low=min;
        int high=max;
        int ans=-1;

        while (low<=high){

            int mid=(low+high)/2;

            if(predicate(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return ans;

    }

    public static boolean predicate(int[] bloomDay, int m, int k,int days){
        int bouquets=0;
        int adjacentCount=0;

        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i]<=days){
                // means it is bloomed
                adjacentCount++;
            }
            else{
                // it is not bloomed
                adjacentCount=0;
            }
            if(adjacentCount==k){
                adjacentCount=0;
                bouquets++;
            }
        }

        return bouquets>=m;
    }

}
