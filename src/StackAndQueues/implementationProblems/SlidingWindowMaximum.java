package StackAndQueues.implementationProblems;

import java.util.ArrayList;

public class SlidingWindowMaximum {
    /** This problem is already solved in Aditya verma sliding window problems
     * */

    public int[] maxSlidingWindow(int[] nums, int k) {

        int ans[]=new int[nums.length-k+1];
        ArrayList<Integer> list=new ArrayList<>();

        int start=0;
        int end=0;

        while(end<nums.length){

            // do work on end
            while(!list.isEmpty() && nums[end]>list.get(list.size()-1)){
                list.remove(list.size()-1);
            }
            list.add(nums[end]);

            // if window size is less
            if(end-start+1<k){end++;}

            // maintain window size
            else if(end-start+1==k){
                // update ans
                ans[start]=list.get(0);

                // slide window
                if(nums[start]==list.get(0)){
                    list.remove(0);
                }
                start++;
                end++;
            }

        }
        return ans;
    }

}
