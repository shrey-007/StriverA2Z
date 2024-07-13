package Arrays.medium;


import java.util.Arrays;
import java.util.Map;

public class LongestConsecutiveSequenceInArray {
    /**
     * Naive Approach:
     *
     * The idea is to first sort the array and find the longest subarray with consecutive elements. After sorting the
     * array and removing the multiple occurrences of elements, run a loop and keep a count and max (both initially zero).
     * Run a loop from start to end and if the current element is not equal to the previous (element+1) then set the
     * count to 1 else increase the count. Update max with a maximum of count and max.
     * */


    /**
     * arr[]={1,1,1,2,2,2,3,3,4,100,100,101,101,102}
     *        0 1 2 3 4 5 6 7 8  9   10  11  12  13
     * 1) i=0, element=1 , lastSmaller=Integer.MIN_VALUE, means ki element last sequence ka part nhi hai new sequence start krna hoga toh -> count=1, lastSmaller=1
     * 2) i=1, element=1 , lastSmaller=1, means ki ye repetition hai toh isme kuch nhi krege -> count=1, lastSmaller=1
     * 3) i=2, element=1 , lastSmaller=1, means ki ye repetition hai toh isme kuch nhi krege -> count=1, lastSmaller=1
     * 4) i=3, element=2 , lastSmaller=1, ab check kro ki ye sequence ka part hai ki nhi , since sequence ka last number=lastSmaller=1 hai and current element 2 hai toh ye sequence ka part hai ->  count=2,ans=2,lastSmaller=2
     * 5) i=4, element=2 , lastSmaller=2, means ki ye repetition hai toh isme kuch nhi krege -> count=2, lastSmaller=2
     * 6) i=5, element=2 , lastSmaller=2, means ki ye repetition hai toh isme kuch nhi krege -> count=2, lastSmaller=2
     * 7) i=6, element=3 , lastSmaller=2, ab check kro ki ye sequence ka part hai ki nhi , since sequence ka last number=lastSmaller=2 hai and current element 3 hai toh ye sequence ka part hai ->  count=3,ans=3,lastSmaller=3
     * 8) i=7, element=3 , lastSmaller=3, means ki ye repetition hai toh isme kuch nhi krege -> count=3, lastSmaller=3
     * 7) i=8, element=4 , lastSmaller=3, ab check kro ki ye sequence ka part hai ki nhi , since sequence ka last number=lastSmaller=3 hai and current element 4 hai toh ye sequence ka part hai ->  count=4,ans=4,lastSmaller=4
     * 9) i=9, element=100 , lastSmaller=4 , 4 ke baad 5 aana chaiye tha but 100 aaya hai means ye sequence ka part nhi hai , new sequnce start kro -> count=1, lastSmaller=100
     * and so on....
     * */
    public static int func(int arr[]){

        int count=0;  // stores current ans
        int ans=1;    // stores global ans
        int lastSmaller=Integer.MIN_VALUE;  // stores last number of sequence(initially abhi koi sequnce ni hai toh -infinity daal diya)

        // sort the arrays, but there may be duplicates
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(lastSmaller==arr[i]-1){
                // means ki arr[i] is part of sequence
                count++;
                ans= Math.max(count,ans);
            }
            else if(lastSmaller!=arr[i]){
                // means it is not duplicate toh ye new sequence hai
                count=1;
                lastSmaller=arr[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int arr[]={1,1,1,2,2,2,3,3,4,100,100,101,101,102};
        System.out.println(func(arr));

    }

    
}
