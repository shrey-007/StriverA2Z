package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> hashMap=new HashMap<>();  // element to its frequency

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }

        // Now hashmap contains all element->frequency
        PriorityQueue<Pair> priorityQueue=new PriorityQueue<>();

        // we have to put values of hashmap into the heap, so we have to iterate over hashmap
        // now we can either create a max heap and usme poora hashmap daaldo toh top k elements will point to k frequent elements, but usse tc-: nlogn ho jaaegi
        // Or we can create a min heap of size k
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if(priorityQueue.size()<k){
                // if size is lesser than k than just add it to priorityQueue
                priorityQueue.add(new Pair(entry.getKey(),entry.getValue()));
            }
            else{
                // means size is heap ka size k hai.
                if(priorityQueue.peek().frequency < entry.getValue()){
                    // since heap ka size k hai, toh top element is kth largest frequency element
                    // Ab agar esa element aaya jiski frequency pee se bhi jyaada hai toh peak (k+1) largest ban jaaege jo ki hum nhi chiye toh ise hata do
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(entry.getKey(),entry.getValue()));
                }
            }
        }

        // Now heap contains most top k freq elements, but in reverse order, jo sabse jyaada frequent hai voh last mai heap ke
        // toh ans array mai ulta daalna shuru kro
        int ans[]=new int[k];
        for (int i = k-1; i >=0 ; i--) {
            ans[i]=priorityQueue.poll().element;
        }

        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int element;
    int frequency;

    public Pair(int element, int frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Pair o) {
        return this.frequency-o.frequency;
    }
}
