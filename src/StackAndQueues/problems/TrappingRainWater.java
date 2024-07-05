package StackAndQueues.problems;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
    public static int trap(int[] height) {

        int ans=0;

        int nge[]=nextGreaterIndexes(height);

        for (int i = 1; i < height.length; i++) {
            int leftHeight=height[i];
            if(nge[i]!=-1){
                int rightHeight=height[nge[i]];
                int width=nge[i]-i-1;
                ans=ans+(width*Math.min(leftHeight,rightHeight));
            }
        }

        return ans;

    }


    public static int[] nextGreaterIndexes(int nums[]){

        int [] nge=new int[nums.length];
        Stack<Integer> stack=new Stack<>();

        // traverse whole array to find nge of all elements
        for (int i = 0; i < nums.length; i++) {

            int currElement=nums[i];

            // jin bhi element se currElement bada hai un sab ka nge hai voh
            while (!stack.isEmpty() && nums[stack.peek()]<currElement){
                // nge banao
                nge[stack.peek()]=i;
                // pop kro coz unka nge pata pad chuka hai
                stack.pop();
            }
            // ab us element ko stack mai daalo jisse vo apna nge find kr ske
            stack.add(i);
        }

        // remaining saare elements jo stack mai hai unka nge -1 hoga
        while (!stack.isEmpty()){
            nge[stack.pop()]=-1;
        }

        return nge;
    }


    public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));

    }

}
