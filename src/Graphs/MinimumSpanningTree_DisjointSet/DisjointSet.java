package Graphs.MinimumSpanningTree_DisjointSet;

import java.util.ArrayList;
import java.util.List;

/**
 * A Disjoint Set, also known as a Union-Find data structure, is a data structure that keeps track of a set of elements
 * partitioned into a number of disjoint (non-overlapping) subsets.
 *
 * It supports two primary operations:
 * Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.
 * Union: Join two subsets into a single subset.
 *
 * Key Concepts
 * Parent Array: An array where each element points to its parent. If an element is a root, it points to itself.
 * Rank/Size Array: Used to keep the tree flat. This helps optimize the time complexity of operations.
 *
 * Operations
 * Find Operation with Path Compression:
 * Path compression ensures that the trees remain flat, making future operations faster. During the find operation, the nodes visited are made direct children of the root.
 * Union Operation with Union by Rank/Size:
 * Union by rank attaches the shorter tree under the root of the taller tree, minimizing the increase in tree height.
 * */

/**
 * The DisjointSet class represents a disjoint-set data structure,
 * also known as a union-find data structure. It keeps track of a set
 * of elements partitioned into disjoint subsets.
 *
 * <p>This implementation uses path compression for the find operation
 * and union by rank for the union operation to ensure near-constant time
 * complexity for both operations.</p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2024-07-22
 */

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }


}
