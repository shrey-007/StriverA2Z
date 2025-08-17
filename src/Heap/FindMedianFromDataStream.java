package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;

    public FindMedianFromDataStream() {
        leftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || leftMaxHeap.peek()>=num){
            // put in left
            leftMaxHeap.offer(num);
        }
        else{
            // put in right
            rightMinHeap.offer(num);
        }

        // maintain size
        if(leftMaxHeap.size()-rightMinHeap.size()>1){
            int element = leftMaxHeap.poll();
            rightMinHeap.offer(element);
        }
        else if(leftMaxHeap.size()<rightMinHeap.size()){
            int element = rightMinHeap.poll();
            leftMaxHeap.offer(element);
        }
    }

    public double findMedian() {
        if(leftMaxHeap.size()==rightMinHeap.size()){
            return (leftMaxHeap.peek()+rightMinHeap.peek()+0.0)/2;
        }
        else return leftMaxHeap.peek()+0.0;
    }
}
