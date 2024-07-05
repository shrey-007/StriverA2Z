package StackAndQueues.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class NextGreaterElementI {
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

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // find nge of nums2
        int [] nge=nextGreater(nums2);

        // map elements of nums2 with their index
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i],i);
        }

        // now iterate over nums 1, and find ki nums1 ka element nums2 mai konse index pe hai
        for (int i = 0; i < nums1.length; i++) {
            int positionInNums2=hashMap.get(nums1[i]);
            // now update nums1 with nge
            nums1[i]=nge[positionInNums2];
        }

        return nums1;

    }

    public static void main(String[] args) {
        int arr[]={3,5,1,2,6};
        int nge[]=nextGreater(arr);

        Arrays.stream(nge).forEach(System.out::println);
    }
}
