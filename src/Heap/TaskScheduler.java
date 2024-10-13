package Heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Pair2> priorityQueue = new PriorityQueue<>();
        int [] freqArray = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            char curr = tasks[i];
            freqArray[curr-'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if(freqArray[i]!=0){
                char task = (char) (i + 'A');
                Pair2 pair = new Pair2(task,freqArray[i]);
                priorityQueue.offer(pair);
            }
        }

        HashSet<Character> lastNTasks = new HashSet<>();

        while (!priorityQueue.isEmpty()){
            // check that any job in pq can be done or not
            Iterator iterator = priorityQueue.iterator();
            boolean canBeDone = false;
            while (iterator.hasNext()){
                Pair2 pair2 = (Pair2) iterator.next();
                char task = pair2.task;
                // check whether this task can be done or not
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        char arr[]={'A','A','A','B','B','B'};
        leastInterval(arr,2);
    }

}

class Pair2 implements Comparable<Pair2>{
    char task;
    int count;

    public Pair2(char task, int count) {
        this.task = task;
        this.count = count;
    }

    @Override
    public int compareTo(Pair2 o) {
        return this.count-o.count;
    }

    @Override
    public String toString() {
        return "Pair2{" +
                "task=" + task +
                ", count=" + count +
                '}';
    }
}

