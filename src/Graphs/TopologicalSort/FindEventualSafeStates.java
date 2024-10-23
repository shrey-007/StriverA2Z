package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> ans = new ArrayList<>();

        // Perform DFS for each node
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, visited)) {
                ans.add(i); // Add the node if it's safe
            }
        }

        return ans;
    }

    public boolean dfs(int node, int[][] graph, int[] visited) {
        if (visited[node] != 0) {
            return visited[node] == 2; // Return true if the node is marked as safe
        }

        // Mark the node as visiting (detect cycle)
        visited[node] = 1;

        // Visit all its neighbors
        for (int neighbor : graph[node]) {
            if (visited[neighbor] == 1 || !dfs(neighbor, graph, visited)) {
                return false; // If a cycle or unsafe neighbor is found, this node is unsafe
            }
        }

        // Mark the node as safe after visiting all neighbors
        visited[node] = 2;
        return true;
    }
}
