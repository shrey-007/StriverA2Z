package Heap;

import java.util.PriorityQueue;

/**
 * You are part of a university admissions office and need to keep track of the kth highest test score from applicants
 * in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit
 * their scores.
 *
 * You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously
 * returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the
 * kth highest score in the sorted list of all scores.
 *
 * Implement the KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
 * int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element
 * in the pool of test scores so far
 * */

public class KthLargestElementInAStream {
    // this is very easy question, don't waste your time here
    // it is just a min heap to get kth largest element.
    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.priorityQueue = new PriorityQueue<>();
        this.k = k;

        for(int i: nums){
            priorityQueue.offer(i);
            if(priorityQueue.size()>k) priorityQueue.poll(); // size exceeds by k, remove (k+1)th largest i.e topmost
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if(priorityQueue.size()>k) priorityQueue.poll(); // size exceeds by k, remove (k+1)th largest i.e topmost
        return priorityQueue.peek(); // return kth largest
    }
}
