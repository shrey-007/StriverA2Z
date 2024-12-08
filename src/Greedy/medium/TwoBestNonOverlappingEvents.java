package Greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents2(int[][] events) {
        // sort on start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int n = events.length;
        return func2(events,n,0,0,-1);
    }
    public int func2(int [][] events,int n,int index,int numberOfEvents,int endTimeOfLastEvent){
        if(index==n){return 0;}
        // at each index we have 2 choices whether we take this event or not

        // attend this event
        // i can only attend this event if the endtime of last event was less than the start time of current event
        // also i can not attend a event if i already attended 2
        int faith1 = (int)-1e9;
        int startTimeOfCurrentEvent = events[index][0];
        int endTimeOfCurrentEvent = events[index][1];
        int profitOfCurrentEvent = events[index][2];
        if(endTimeOfLastEvent<startTimeOfCurrentEvent && numberOfEvents<2){
            faith1 = func2(events,n,index+1,numberOfEvents+1,endTimeOfCurrentEvent)+profitOfCurrentEvent;
        }

        // don't attend this event
        int faith2 = func2(events,n,index+1,numberOfEvents,endTimeOfLastEvent);

        return Math.max(faith2,faith1);
    }

    public int maxTwoEvents(int[][] events) {
        // sort on start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));


        int n = events.length;
        int maxEndTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxEndTime = Math.max(maxEndTime,events[i][1]);
        }
        int dp[][][] = new int[n][maxEndTime+1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maxEndTime+1; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return func(events,n,0,0,0,dp);
    }
    public int func(int [][] events,int n,int index,int numberOfEvents,int endTimeOfLastEvent,int dp[][][]){
        if(index==n){return 0;}
        // at each index we have 2 choices whether we take this event or not
        if(numberOfEvents<2 && dp[index][endTimeOfLastEvent][numberOfEvents]!=-1){
            return dp[index][endTimeOfLastEvent][numberOfEvents];
        }

        // attend this event
        // i can only attend this event if the endtime of last event was less than the start time of current event
        // also i can not attend a event if i already attended 2
        int faith1 = (int)-1e9;
        int startTimeOfCurrentEvent = events[index][0];
        int endTimeOfCurrentEvent = events[index][1];
        int profitOfCurrentEvent = events[index][2];
        if(endTimeOfLastEvent<startTimeOfCurrentEvent && numberOfEvents<2){
            faith1 = func(events,n,index+1,numberOfEvents+1,endTimeOfCurrentEvent,dp)+profitOfCurrentEvent;
        }

        // don't attend this event
        int faith2 = func(events,n,index+1,numberOfEvents,endTimeOfLastEvent,dp);

        if(numberOfEvents<2) dp[index][endTimeOfLastEvent][numberOfEvents] = Math.max(faith2,faith1);

        return Math.max(faith2,faith1);
    }

    public static void main(String[] args) {
        TwoBestNonOverlappingEvents twoBestNonOverlappingEvents = new TwoBestNonOverlappingEvents();
        int arr[][]={{1,3,2},{4,5,2},{2,4,3}};
        System.out.println(twoBestNonOverlappingEvents.maxTwoEvents(arr));
    }

}
