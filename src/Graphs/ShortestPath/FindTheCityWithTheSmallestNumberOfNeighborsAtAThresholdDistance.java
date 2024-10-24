package Graphs.ShortestPath;

import java.util.Arrays;

/**
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents
 * a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.
 *
 * Return the city with the smallest number of cities that are reachable through some path and whose distance is at most
 * distanceThreshold, If there are multiple such cities, return the city with the greatest number.
 *
 * Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that
 * path.
 * */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1: Initialize distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // Use large value, not Integer.MAX_VALUE to avoid overflow
            dist[i][i] = 0; // Distance to self is 0
        }

        // Fill initial distances with the given edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Step 2: Apply Floyd-Warshall to compute all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Step 3: Count reachable cities within the distance threshold for each city
        int resultCity = -1;
        int minReachableCities = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }

            // Step 4: Find the city with the smallest number of reachable cities
            // If there's a tie, return the city with the greatest index
            if (reachableCities < minReachableCities || (reachableCities == minReachableCities && i > resultCity)) {
                minReachableCities = reachableCities;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
