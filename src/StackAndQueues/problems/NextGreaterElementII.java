package StackAndQueues.problems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    /**Method1 is shown below*/
    /**Method 2 is ki tum nge find krne vala function mai 2*n tak loop chalao n ki jagah*/
    public static int[] nextGreaterElements(int[] nums) {

        // create an array of double size of nums
        // nums=[9,5,2,1]
        int nums2[]=new int[2*nums.length];

        // copy all elements of nums twice jisse rotations ho ske
        // nums2=[9,5,2,9,5,2,1]
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=nums[i%nums.length];
        }

        // find nge of nums2
        int nge[]=nextGreater(nums2);

        // copy starting elements of nums2 to nums
        for (int i = 0; i < nums.length; i++) {
            nums[i]=nge[i];
        }
        return nums;
    }

    public static int[] nextGreater(int nums[]){

        int [] nge=new int[nums.length];
        Stack<Integer> stack=new Stack<>();

        // traverse whole array to find nge of all elements
        for (int i = 0; i < nums.length; i++) {

            int currElement=nums[i];

            // jin bhi element se currElement bada hai un sab ka nge hai voh
            while (!stack.isEmpty() && nums[stack.peek()]<currElement){
                // nge banao
                nge[stack.peek()]=currElement;
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
        int arr[]= {9,5,2,1};
        int [] nge=nextGreaterElements(arr);
        Arrays.stream(nge).forEach(System.out::println);

    }
}
