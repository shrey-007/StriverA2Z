package DP.TwoAndThreeDimensional;

import java.util.ArrayList;
import java.util.Arrays;

public class NinjaTraining {
    /**
     * Geek is going for a training program. He can perform any of these activities: Running, Fighting, and Learning
     * Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same
     * activity on two consecutive days. Help Geek to maximize his merit points as you are given a 2D array of points
     * arr, corresponding to each day and activity.
     * */

    /**
     * Hume nhi pata ki konse din konsi activity krni chaiye jisse max points score ho, coz aaj jo kri voh kal ni kr skte toh
     * we have to try all possisble ways toh is is DP question
     * */
    public int maximumPoints(int arr[][], int N) {
        return func(arr,0,-1,N);
    }

    /**
     * 1. Har din alag activity ke points alag hai, means aaj gym krne ke point agar x hai toh kal krne ke y
     * 2. Aaj gym kra toh kal na kre toh uske lie pointer hai jo ye denote krega ki last day konsi activity kari thi.
     * 3. Toh sirf day parameter nhi hai, last day kya activity kri vo bhi parameter hai toh f(1,2) and f(1,3) ka ans
     *    alag aaega , same day hai dono ka(1) but last day pr alag activity kri toh current day pr vo lastActivity nhi kr skte
     * 4. func(index,lastActivity) denotes ki day=index se day=n-1 tak jaane ki max points if you can't take lastActivity.
     * 5. Initially day 0 se pehle koi activity nhi kri hai toh koi bhi activity kr skte hai isliye -1 daala hai, And -1
     *    index dp array mai problem deta isliye, lastActivity!=-1  vaali lines daali hai if conditions mai.  */
    public int func(int arr[][],int index,int lastActivity,int n){
        if(index==n){
            return 0;
        }

        int faith=Integer.MIN_VALUE;

        // try all possible ways
        for (int activity = 0; activity < 3; activity++) {
            if(activity!=lastActivity){
                faith=Math.max(faith,func(arr,index+1,activity,n)+arr[index][activity]);
            }
        }
        return faith;
    }

    // memoization
    public int func(int arr[][],int index,int lastActivity,int n,int dp[][]){
        if(index==n){
            return 0;
        }
        if(lastActivity!=-1 && dp[index][lastActivity]!=-1){return dp[index][lastActivity];}
        // try all possible ways
        int faith=Integer.MIN_VALUE;

        for (int activity = 0; activity < 3; activity++) {
            if(activity!=lastActivity){
                faith=Math.max(faith,func(arr,index+1,activity,n,dp)+arr[index][activity]);
            }
        }
        if(lastActivity!=-1){dp[index][lastActivity]=faith;}
        return faith;
    }

    // tabulation
    public int tabulation(int arr[][],int n){

        int dp[][]=new int[n][3];
        // Jo f(index,activity) denote kr rha tha vahi dp[index][activity] denote krega

        // Initialize the last day's activities
        dp[n - 1][0] = Math.max(arr[n - 1][1], arr[n - 1][2]);  // dp[n-1][0] means ki (n-1)th day ka max points nikaalo bina 0th activity ko liye isliye 1st, 2nd activity ke points mai se jo bada use store kro
        dp[n - 1][1] = Math.max(arr[n - 1][0], arr[n - 1][2]);
        dp[n - 1][2] = Math.max(arr[n - 1][0], arr[n - 1][1]);

        // Fill the dp table
        for (int index = n - 2; index >= 0; index--) {
            for (int lastActivity = 0; lastActivity < 3; lastActivity++) {
                dp[index][lastActivity] = Integer.MIN_VALUE;
                for (int nextActivity = 0; nextActivity < 3; nextActivity++) {
                    if (lastActivity != nextActivity) {
                        dp[index][lastActivity] = Math.max(dp[index][lastActivity], dp[index + 1][nextActivity] + arr[index][lastActivity]);
                    }
                }
            }
        }

        // The maximum points possible starting from day 0 with no last activity
        return Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
    }

    // Space Optimization
    // Watch its space optimization video

    



}
