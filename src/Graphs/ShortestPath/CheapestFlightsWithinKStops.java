package Graphs.ShortestPath;

import java.util.*;

/**
 * There are n cities connected by some number of flights. You are given an array flights where
 * flights[i] = [fromi, toi, pricei] indicates that there is a flight from city from i to city toi with cost price i.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 * */


// Neeche vaale code mai PQ , price ke basis pr kaam kr raha hai

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {

        // since hume dijkstra mai node ke neighours visit krne hota hai but yaha directly neighbours ni diye hai
        // so first convert it to an adjacency list
        List<List<List<Integer>>> adjListWithCost = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjListWithCost.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];
            adjListWithCost.get(u).add(List.of(v,cost));
        }

        // initialise PQ and distance(price) array
        int price[] = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;

        PriorityQueue<StopsWithPrices> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new StopsWithPrices(src,0,0));

        while (!priorityQueue.isEmpty()){
            StopsWithPrices stopsWithPrices = priorityQueue.poll();
            int currentStop = stopsWithPrices.stop;
            int currentprice = stopsWithPrices.totalPriceTillNow;
            int currentCountOfStops = stopsWithPrices.totalStopsTillNow;

            // if you have reached destination, return the current cost
            if(currentStop==dst){
                return currentprice;
            }

            // visit all neightbours
            for(List<Integer> neighbour : adjListWithCost.get(currentStop)){
                int neighbourStop = neighbour.get(0);
                int costToReachNeighbour = neighbour.get(1);

                if(currentCountOfStops+1<=k && currentprice+costToReachNeighbour<price[neighbourStop]){
                    priorityQueue.offer(new StopsWithPrices(neighbourStop,currentprice+costToReachNeighbour,currentCountOfStops+1));
                }
            }

        }

        // if you reach here means it is not possible to reach dest in less than k number of stops

        return -1;

    }
    // This approach won't work

    // Isme PQ, price ke basis par kaam kr rha hai.
    // suppose ki koi city x hai vaha jaane ka price p and number of stops s lage. But jab us path se gye destination
    // par toh hume destination tak jaane mai k se jyaada stops lage toh voh valid solution nhi hai, but problem is ki
    // price array mai price[x]=p ho chuka hai.
    // Now suppose doosre path mai x tak jaana p1(p1>p) cost lagi and s1 (s1<s) stops lage. And finally dest tak apan
    // pahuch gye within k stops, esa path exists krta hai but process nhi hoga coz price[x]=p hai and is path mai
    // x tak pahuch ne ki price jyaada hai toh voh is path ko PQ mai daalega hi nhi

    // So you understood the question, apna main objective ye nhi hai ki less min cost mai jaaye , apna objective ye hai
    // ki less than k stops mai min cost mai jaaye. Toh suppose agar tum PQ ko stops ke basis pr chalaoge toh kya sahi
    // ans aaega?. Socho agar tum destination pr pahuche toh since PQ stops ke basis pr chal rhi hai toh jab tum pehli baar
    // destination pahuchoge toh voh path with min number of stops hoga. Jo ki answer ho skta hai but esa bhi ho skta ki
    // there exists a path with more stops than this but less than k, and price is also less.
    // Toh even if we reach the destination, that does not mean ki vahi path hai, we will still go on, to find min cost path
    // Also PQ bhale hi stop ke basis pr ho, but element PQ mai tabhi daalege jab price less ho. It is dijkstra
    // Since stops ek fixed amount(1) se hi badega hamesha, toh we don't need PQ , queue will suffice


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // since hume dijkstra mai node ke neighours visit krne hota hai but yaha directly neighbours ni diye hai
        // so first convert it to an adjacency list
        List<List<List<Integer>>> adjListWithCost = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjListWithCost.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];
            adjListWithCost.get(u).add(List.of(v, cost));
        }

        // initialise PQ and distance(price) array
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        Queue<StopsWithPrices> queue = new ArrayDeque<>();
        queue.offer(new StopsWithPrices(src, 0, 0));

        while (!queue.isEmpty()) {
            StopsWithPrices stopsWithPrices = queue.poll();
            int currentStop = stopsWithPrices.stop;
            int currentPrice = stopsWithPrices.totalPriceTillNow;
            int currentCountOfStops = stopsWithPrices.totalStopsTillNow;

            // If reached destination, return the price
            // don't include this line, coz humne number of stops ke basis par PQ mai element daal rhe hai toh jo abhi
            // pop hua hai voh destination pr min number of stops mai pahucha hai, toh voh answer ho skta hai but esa bhi
            // ho skta hai ki jitne stops isne liye usse thode jyaada stops liye but less than k and min cost mai pahucha
            // diya, esa path bhi ho skta hai toh us path ko consider krna hai
//            if (currentStop == dst) {
//                return currentPrice;
//            }


            if(currentCountOfStops > k) continue;

            // Visit neighbors
            for (List<Integer> neighbor : adjListWithCost.get(currentStop)) {
                int neighborStop = neighbor.get(0);
                int costToReachNeighbor = neighbor.get(1);

                if (currentCountOfStops<= k && currentPrice+costToReachNeighbor<price[neighborStop]) {
                    price[neighborStop] = currentPrice + costToReachNeighbor;
                    queue.offer(new StopsWithPrices(neighborStop, currentPrice + costToReachNeighbor, currentCountOfStops + 1));
                }
            }
        }

        if(price[dst] == Integer.MAX_VALUE) return -1;

        // if you reach here means it is not possible to reach dest in less than k number of stops
        return price[dst];
    }

    class StopsWithPrices{
        int stop;
        int totalPriceTillNow;

        int totalStopsTillNow;

        public StopsWithPrices(int stop, int totalPriceTillNow, int totalStopsTillNow) {
            this.stop = stop;
            this.totalPriceTillNow = totalPriceTillNow;
            this.totalStopsTillNow = totalStopsTillNow;
        }
    }

}






