package Greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals  where intervals[i] = [starti, endi], return the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 *
 * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 * */
public class NonOverlappingIntervals {

    /** same as n meeting in one room */
    public int eraseOverlapIntervals(int[][] intervals) {

        // sort the intervals on end time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int n = intervals.length;

        // first meeting with always performed
        int count=1;
        int endTimeOfLastMeeting = intervals[0][1];

        // check from index 1 whether 1-n meeting can be peformed or not
        for (int i = 1; i < n; i++) {
            // if start time of current meeting is more than end time of last meeting then this meeting can be
            // performed else not
            if(intervals[i][0]>=endTimeOfLastMeeting){count++;endTimeOfLastMeeting=intervals[i][1];}
        }

        return n-count;
    }
}
