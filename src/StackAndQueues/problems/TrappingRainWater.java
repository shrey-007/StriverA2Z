package StackAndQueues.problems;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {

    /**
     * Concept-:
     * water trapped at i = min(largest element on left,larget element on right)-height[i]
     * And i am saying largest element. Isme NGE ka concept use nhi hoga
     * */

    /**
     * Most brute force approach is-:
     * 1) ith index pr jaao and left mai max height dhundo, right mai dhundo fir unka min lo and usme se apni heigth subtract kro
     * 2) utni height ka water ith index mai hoga and width sabki 1 hi hai
     * 3) Also leftMax and rigthMax current element khud bhi ho skta hai
     * */
    public static int trap(int[] height) {

        int ans=0;

        for (int i = 0; i < height.length; i++) {

            int leftLargestHeight=Integer.MIN_VALUE;
            int rightLargestHeight=Integer.MIN_VALUE;

            for (int j = 0; j <=i; j++) {
                if(leftLargestHeight<height[j]){leftLargestHeight=height[j];}
            }

            for (int j = i; j <height.length; j++) {
                if(rightLargestHeight<height[j]){rightLargestHeight=height[j];}
            }

            int minOfBoth=Math.min(leftLargestHeight,rightLargestHeight);

            int heightOfWater=minOfBoth-height[i];

            ans=ans+heightOfWater;

        }

        return ans;
    }

    /**
     * Method2-: Based on same concept bas is baar har element ke liye baar baar leftMax,rightMax nhi nikala
     * 1) Ek prefixMax array banaya jo ki store krega ki current element tak konsi height max thi
     * 2) Ek suffixMax array banaya jo ki store krega ki current element ke baad se konsi height max hogi
     * 3) leftMax=prefixMax[i]; rightMax=suffixMax[i]
     * */

    public static int trap2(int height[]){

        int ans=0;

        int prefixMax[]=new int[height.length];
        int suffixMax[]=new int[height.length];

        int max=Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            if(max<height[i]){
                max=height[i];
            }
            prefixMax[i]=max;
        }

        max=Integer.MIN_VALUE;

        for (int i = height.length-1; i >=0; i--) {
            if(max<height[i]){
                max=height[i];
            }
            suffixMax[i]=max;
        }


        for (int i = 0; i < height.length; i++) {

            int leftLargestHeight=prefixMax[i];
            int rightLargestHeight=suffixMax[i];

            int minOfBoth=Math.min(leftLargestHeight,rightLargestHeight);

            int heightOfWater=minOfBoth-height[i];

            ans=ans+heightOfWater;

        }

        return ans;
    }



    public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap2(height));

    }

}
