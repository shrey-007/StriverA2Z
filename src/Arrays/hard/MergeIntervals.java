package Arrays.hard;

import java.util.Stack;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
//        Example 1:
//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals {

    static int[][] func1(int [][]intervals){
        //sort the array on basis of startTime, if startTime is same sort on endTime.you can implement this using comparator
        Stack<Interval> stack=new Stack<>();
        //add first interval initially
        stack.add(new Interval(intervals[0][0],intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            //we know that array is sorted toh overlap ka ek hi case banega jab stack ke peek ka end
            //current ke start se bada hoga.
            Interval currentInterval=new Interval(intervals[i][0],intervals[i][1]);

            if(stack.peek().end>= currentInterval.start){
                //means overlapping hui hai and start point stack ke peek ka start hi hoga,but end ka pata nhi
                int startTime=stack.peek().start;
                int endTime= Math.max(stack.peek().end,currentInterval.end);
                //pop the peak coz vo merge ho jaaegi new interval ke saath
                stack.pop();
                //add new interval to stack
                stack.push(new Interval(startTime,endTime));
            }
            else{
                //means no overlapping toh direct add krdo stack m
                stack.push(new Interval(currentInterval.start, currentInterval.end));
            }
//            ab ans stack mai store hai toh stack ko iterate krke ans nikaal lo
        }


      return new int[3][];
    }

    public static void main(String[] args) {


    }
}
