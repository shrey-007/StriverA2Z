package Greedy.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still
 * does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.*/
public class InsertInterval {
    // below is a good way to perform insertion
    // another way is , since array is already sorted toh find the first element in the array jiske start-end ke beech mai new interval aaye
    // let k is the index of the element toh 0 to k-1 is chill, same array ans hoga
    // merge the newinterval to the kth index in array itself
    // now k to n vaala may be bigad jaaega toh agar kth index mai change krne ke kaaran k+1 to n mai changes hue toh what to use?
    // ans is stack. First element of the stack will be kth index and then apply merger interval algo.

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge the new interval with overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);  // Add the merged interval

        // Add the remaining intervals after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the list back to an array and return it
        return result.toArray(new int[result.size()][]);
    }

}


