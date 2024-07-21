package Graphs.ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // since there are n cities means there are n nodes
        int prices[]=new int[n];  // this is same as dist array
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src]=0;

        PriorityQueue<StopsWithPrices> priorityQueue=new PriorityQueue<>();

        priorityQueue.add(new StopsWithPrices(src,0,0));

        while (!priorityQueue.isEmpty()){

            StopsWithPrices stopsWithPrices=priorityQueue.poll();
            int currentStop=stopsWithPrices.stop;
            int currentPriceTillNow=stopsWithPrices.totalPriceTillNow;
            int currentNumberOfStopsTillNow=stopsWithPrices.totalStopsTillNow;

            if(currentStop==dst){
                // this is the destination
                return currentPriceTillNow;
            }

            // check kro currentStop se kaha jaa skte hai
            for (int i = 0; i < flights.length; i++) {
                if(flights[i][0]==currentStop){
                    int nextStop=flights[i][1];
                    int costToGoNextStop=flights[i][2];
                    if(currentNumberOfStopsTillNow<=k && currentPriceTillNow+costToGoNextStop<prices[nextStop]){
                        prices[nextStop]=currentPriceTillNow+costToGoNextStop;
                        priorityQueue.add(new StopsWithPrices(nextStop,currentPriceTillNow+costToGoNextStop,currentNumberOfStopsTillNow+1));
                    }
                }
            }
        }

        return prices[dst];

    }

}

class StopsWithPrices implements Comparable<StopsWithPrices>{
    int stop;
    int totalPriceTillNow;

    int totalStopsTillNow;

    public StopsWithPrices(int stop, int totalPriceTillNow, int totalStopsTillNow) {
        this.stop = stop;
        this.totalPriceTillNow = totalPriceTillNow;
        this.totalStopsTillNow = totalStopsTillNow;
    }

    @Override
    public int compareTo(StopsWithPrices o) {
        return this.totalPriceTillNow-o.totalPriceTillNow;
    }
}

/**
 * Since in this problem, we have to calculate the minimum cost to reach the destination from the source but with a
 * restriction on the number of stops, we would be using Dijkstra’s Algorithm. Now, one must wonder that based on what
 * parameter we should add elements to the priority queue.
 *
 * Now, if we store the elements in the priority queue with the priority given to the minimum distance first, then after
 * a few iterations we would realize that the Algorithm will halt when the number of stops would exceed. This may result
 * in a wrong answer as it would not allow us to explore those paths which have more cost but fewer stops than the
 * current answer.
 *
 * To tackle this issue, we store the elements in terms of the minimum number of stops in the priority queue so that
 * when the algorithm halts, we can get the minimum cost within limits.
 *
 * Also, a point to note here is that do we really need a priority queue for carrying out the algorithm? The answer for
 * that is No because when we are storing everything in terms of a number of stops, the stops are increasing monotonically
 * which means that the number of sops is increasing by 1 and when we pop an element out of the queue, we are always
 * popping the element with a lesser number of stops first. Replacing the priority queue with a simple queue will let us
 * eliminate an extra log(N) of the complexity of insertion-deletion in a priority queue which would in turn make our
 * algorithm a lot faster.*/

/**
 * so you need to make few changes-:
 *
 * 1) while loop ke under agar dest mai pahuchte hai toh return kr rha hai , vo mat kro
 *             if(currentStop==dst){
 *                 // this is the destination
 *                 return currentPriceTillNow;
 *             }
 * 2) instead include this line             if(currentNumberOfStopsTillNow > k) continue;
 * 3) Priority queue ko stops ke basis pr compare kro prices ke basis pr nhi.
 * 4) And stops ek-ek kr rhe ke badh rhe hai toh queue hi use krlo(PQ bhi kr skte hai)
 * */
