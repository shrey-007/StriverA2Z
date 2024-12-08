package Greedy.medium;

import java.util.Arrays;

/**
 * Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms
 * required for the railway station so that no train is kept waiting.
 * Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never
 * be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given
 * instance of time, same platform can not be used for both departure of a train and arrival of another train. In such
 * cases, we need different platforms.
 *
 * Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 )
 * and the last two characters represent minutes (this will be <= 59 and >= 0).
 * */
public class MinimumPlatforms {
    // try it doing sorting on start, endtime etc, and u will not get ans
    // the point is greedy problems are very difficult to grasp whether they are greedy or DP
    // even if we know it is greedy , then we dont know how to perform greedy
    // there are some standard greedy problems , toh bas unhe ratt lo

    /**
     * arr[] = {900,945,955,1100,1500,1800}
     * dept[]= {920,1200,1130,1150,1900,2000}
     *
     * Sort the array individually
     *
     * arr[] = {900,945,955,1100,1500,1800}
     * dept[]= {920,1130,,1150,1200,1900,2000}
     *
     * Now we have to iterate through time, ya toh arr,dept ko merge kro and merge vaale ko sort kro
     * ye dono ko sort kro individually and merge sort lagao to get time in increasing order
     * i iterates over arrival, j iterates iver departure
     * pehle 900 aayi(count=1),920 pr gyi(count=0),945 pr aayi(count=1),955 ek new train aayi and 945 vaali abhi gyi nhi hai(count=2),
     * 1100 par new train aayi and abhi 945,955 vaali gyi nhi hai(count=3), 1200 par ek train gy toh station khaali toh count--(count=2),
     * and so on esa krte rahi
     */


    static int findPlatform(int arr[], int dep[]) {
        // Sort the arrival and departure time individually
        // no need to sort them concurrently
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n=arr.length;

        int count=0;
        int ans=0;

        int i=0;
        int j=0;

        while (i<n){
            if(arr[i]<=dep[j]){
                count++;
                ans=Math.max(count,ans);
            }
            else{
                count--;
            }
        }


        return ans;
    }

}
