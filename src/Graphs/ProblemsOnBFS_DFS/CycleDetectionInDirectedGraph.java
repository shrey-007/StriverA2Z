package Graphs.ProblemsOnBFS_DFS;

import java.util.List;

/**
 *
 * <p>Three States:</p>
 * <ul>
 *   <li><b>Not Visited (0):</b>
 *   <p>The vertex has not been encountered by DFS yet. It means no part of this vertex or its
 *   descendants has been explored.So we have to explore it</p></li>
 *
 *   <li><b>Visited but In Progress (Recursion Stack) (1):</b>
 *   <p>The vertex is currently being visited, meaning it’s part of the current DFS call stack
 *   but hasn’t been fully explored. If we revisit a vertex in this state during DFS, it indicates
 *   a back edge, and hence a cycle. This state helps detect cycles because if you encounter a vertex
 *   that’s still in the stack, it implies that you’re revisiting a node that is part of the current path,
 *   forming a cycle.</p></li>
 *
 *   <li><b>Fully Explored (2):</b>
 *   <p>The vertex and all its descendants have been completely explored. It has exited the DFS recursion
 *   stack. If you revisit this vertex later, it means no cycle can occur from this vertex again since it’s
 *   fully processed. So we will not make duplicate calls to process same thing again</p></li>
 * </ul>
 *
 * <p>Steps in DFS with Three Marks:</p>
 * <ol>
 *   <li>Start DFS at any unvisited node.</li>
 *   <li>Mark the node as "Visited but In Progress".</li>
 *   <li>Explore all its outgoing edges (children).</li>
 *   <li>For each neighbor:
 *     <ul>
 *       <li>If the neighbor is "Not Visited", recursively explore it.</li>
 *       <li>If the neighbor is "Visited but In Progress", it’s a back edge, and a cycle is detected.</li>
 *       <li>If the neighbor is "Fully Explored", ignore it since there’s no cycle through it.</li>
 *     </ul>
 *   </li>
 *   <li>Once all neighbors are processed, mark the node as "Fully Explored".</li>
 * </ol>
 */

public class CycleDetectionInDirectedGraph {
    // It is different from cycle detection in undirected graph

    // State constants
    private static final int NOT_VISITED = 0;
    private static final int VISITED_IN_PROGRESS = 1;
    private static final int FULLY_PROCESSED = 2;

    public boolean hasCycle(int vertices,List<List<Integer>> adjList) {
        int[] visited = new int[vertices]; // State array for tracking visited nodes
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == NOT_VISITED) {
                if (dfs(i, visited,adjList)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found
    }

    // DFS helper method
    private boolean dfs(int v, int[] visited,List<List<Integer>> adjList) {
        visited[v] = VISITED_IN_PROGRESS; // Mark the node as currently being visited

        // Explore all adjacent nodes
        for (int neighbor : adjList.get(v)) {
            if (visited[neighbor] == NOT_VISITED) {
                // Recursively visit unvisited neighbor
                if (dfs(neighbor, visited,adjList)) {
                    return true; // Cycle detected in the recursive call
                }
            } else if (visited[neighbor] == VISITED_IN_PROGRESS) {
                // A back edge is detected (cycle)
                return true;
            }
        }

        visited[v] = FULLY_PROCESSED; // Mark the node as fully processed
        return false; // No cycle found in this path
    }
}
