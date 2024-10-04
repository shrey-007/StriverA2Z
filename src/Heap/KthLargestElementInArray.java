package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    /**
     * A min-heap is chosen because it allows for efficiently keeping track of the k largest elements. The smallest
     * element in the heap will be the k-th largest element when the heap size reaches k.*/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            int curr=nums[i];

            minHeap.add(curr);

            if(minHeap.size()>k){
                // means minHeap ka size k+1 hua hai, toh top par k+1 elements mai se sabse smallest number hai
                // means top par (k+1)th largest element hai, toh top vaala ans nhi hai
                minHeap.poll();
            }
        }


        return minHeap.peek();
    }

    // Or ese socho
    public static int findKthLargest2(int[] nums, int k) {
        // Min-heap with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (minHeap.size() < k) {
                // Add element if heap size is less than k
                minHeap.add(num);
            }
            else {
                // means ki heap ka size k hogya hai.
                // Toh heap ke top par kth largest element hai
                // But agar ab suppose kro ki nums[i]<peek toh nums[i] k+1,k+2.. largest hoga kiuki voh peek se bhi chota hai, toh voh answer nhi hoga toh use mat lo
                // But if nums[i]>peek toh toh peek k+1 largest ho jaaega and nums[i] kth largest toh peek ans nhi hai use hata do
                // Example-: k=4 , means 4th largest element chaiye. heap->[98|84|75|21|
                // Toh is heap ka peek, kth largest element hoga joki abhi 21 hai
                // Now suppose ki 18 aata hai toh voh 21 se bhi chota hai toh [98|84|75|21|18 esa banega jisme 18 (k+1)th largest banega and 21 is still kth largest toh 18 ko add krne ka sense nhi hai if answer is still same
                // But if 35 aaya toh heap esa banega [98|84|75|35|21|, means ki new 21 is now (k+1)th largest and 35 is kth largest toh answer update hua , toh puraana ans 21 ko hata do
                if (num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}
