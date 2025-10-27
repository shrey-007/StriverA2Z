package Heap;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;

        // Step 2: Max-Heap (store counts if greater than 0)
        // agar kisi task 'F' ki freq 0 hai means voh hai hi nhi toh use kiu daalna
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // remember we have added frequencies only, not their respective task
        for (int f : freq) if (f > 0) pq.add(f);

        int time = 0;

        // Step 3: Process until heap is empty
        while (!pq.isEmpty()) {
            // leave this for now, will explain later why we used temp
            List<Integer> temp = new ArrayList<>();

            // if n=2, and you have A and B tasks
            // Toh A->B kara ab vapas se A nhi kr skte coz abhi poori cycle complete nhi hui. A ke baad atleast n=2 task
            // aane chaiye tabhi dobara A aa skta hai abhi sirf ek hi task aaya hai B.
            // A->B->something else->(now you can add A)
            // 1  2   3
            // so we have to do 3 task in a cycle, i.e n+1 tasks
            int cycle = n + 1; // one full cycle

            // execute up to n+1 tasks
            while (cycle > 0 && !pq.isEmpty()) {
                // poll the current task
                int curr = pq.poll();
                // do this task, if you do this, its frequency has to be reduce by 1, if even after reducing its freq,
                // its not 0 means it has to be done more times

                // so we have to add it again to pq, but suppose this curr was having infinite freq, and after this line
                // it has infinite-1 freq, toh vapis se curr hi pq ke top pe aa jaaega but vapis se isi ko execute nhi
                // kr skte same cycle mai toh ya toh visited mark karo, ya ise abhi add mat karo, abhi ise bas kisi
                // temporary list mai add krdo and then cycle complete hone ke baad ise add kr dena pq mai
                if (curr - 1 > 0) temp.add(curr - 1); // still remaining
                time++;
                cycle--;
            }

            // push remaining tasks back into heap(voh jo uper infinite vala toh ab use vapis se daal do, coz new cycle hai)
            for (int remaining : temp) pq.add(remaining);

            // if n=6, and you have A and B tasks
            // Toh A->B kara ab vapas se A nhi kr skte coz abhi poori cycle complete nhi hui. A ke baad atleast n=6 task
            // aane chaiye tabhi dobara A aa skta hai abhi sirf ek hi task aaya hai B.
            // A->B->x->x->x->x->x-> (now you can add A)
            // toh ye x hai kya? its actually idle.
            // toh jitna bhi cycle ka size bacha hai utne idle insert krna padege
            if (!pq.isEmpty()) time += cycle;
        }

        return time;
    }
}

