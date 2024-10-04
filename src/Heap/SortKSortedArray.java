package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static int[] func(int arr[],int k){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();

        // first insert k+1 elemenrt in heap
        for (int i = 0; i < arr.length && i<k+1; i++) {
            priorityQueue.add(arr[i]);
        }

        // Now is heap ka top mai hi 0th index vaala element hai, new array ka
        int ans[]=new int[arr.length];
        int index=0;   // new array ka konsa index fill krna hai, uska pointer

        // Now since apan ko remaining elements k+2 to n-1 ko bhi heap mai daalte rehna hai one-by-one toh arr pr iterate kro
        for (int i = k+1; i <arr.length; i++) {
            // abhi k+1 elements hai toh pehele answer update kro
            ans[index]=priorityQueue.poll();
            index++;
            // ab k elements ho gye, toh new element daalo
            priorityQueue.add(arr[i]);
        }

        // sab elements iterate hone ke baad bhi kuch elements heap mai bach jaaega toh unhe ans mai daalna hai
        while (!priorityQueue.isEmpty()){
            ans[index]=priorityQueue.poll();
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[]={2,3,1,4,6,7,5,8,9};
        int ans[]=func(arr,2);
        Arrays.stream(ans).forEach(n-> System.out.print(n+" "));

        /**
         * {2,3,1,4,6,7,5,8,9} but the array should be
         * {1,2,3,4,5,6,7,8,9} , toh har element ya toh k(2) places aage gaya hai ya peeche
         *
         * Toh lets creat a new array
         * 1. Us new array ke 0th index par 0 to k+1 index tak ka koi bhi element aa skta hai
         * 2. Toh starting k+1 elements ko heap mai daalo, [1,2,3] banegi heap. jisse 1 top pr hoga toh use 0th index pr daal denge new array ke
         * 3. Ab heap ka size k ho gya. And 1st index par jo element aaega vo 1 to k+2 index mia se koi hoga toh (k+2)th index vaale ko heap mai daalo. Ab heap mai k+1 elements ho gye, heap=[2,3,4], toh 2 nikalega and use new array ke 1st index pr daal denge
         *    and so on....
         * 4. Important thing where confusion arises is, ki since arr[i] jo hai vo i-1 to i+k kahi bhi ho skta hai toh 2*k elements
         *    daalo heap mai. Kiuki hume aage and peeche k elements dekhne hai but it is wrong
         *    Once an element is removed from the heap and placed in its correct position, all elements that come before it (up to k positions) are guaranteed to have been correctly placed in previous steps.
         *    Therefore, there’s no need to look backwards. The sorting algorithm guarantees that the current element, after processing, will be in the correct place relative to the elements that have already been placed.
         * */
    }

}
