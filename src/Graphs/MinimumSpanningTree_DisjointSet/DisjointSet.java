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

// this is used in dynamic graphs( graphs which keep changing their structure )

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        // initially sabke parent vo khud hi hai, means kisi ka koi chidren nhi hai , sabka group alag hai
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        // if node ka parent vo khud hi hai means ki ya toh voh abhi akela node hai us group mai toh vahi parent hai
        // or uske group mai nodes kaafi hai , but un sabka parent vo khud hi hai, toh us case mai bhi vahi parent hai toh node ko return krdo
        if (node == parent.get(node)) {
            return node;
        }

        // hume parent nhi dena ultimate parent dena hai toh, find ultimate parent ko parent
        int ulp = findUPar(parent.get(node));
        // jo parent ka ultimate parent hai voh iska bhi ultimate parent hai, toh simply update krdo  kiuki parent store
        // krne ka mtlb nhi hai agar apan ko ultimate parent pata hai.
        // agar ultimate parent pata hai toh vahi parent mai store krdo
        parent.set(node, ulp);
        // return parent
        return parent.get(node);
    }

    // we have to connect u and v through this function
    public void unionByRank(int u, int v) {
        // find ultimate parent of u and v
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // if ultimate parent of u and v are same means they are already connected, they r in same group , so just return
        if (ulp_u == ulp_v) return;

        // smaller guy gets connected to bigger guy, just for optimization
        // you can also connect larger to smaller, but it will not be optimized

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            // here rank of u is smaller so it gets connected to v
            // So in order to connect u to v , u ka parent v banado
            // there will no change in rank, since smaller is going to attach with bigger
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            // here rank of v is smaller so it gets connected to u
            // So in order to connect v to u , v ka parent u banado
            // there will no change in rank, since smaller is going to attach with bigger
            parent.set(ulp_v, ulp_u);
        } else {
            // now if the rank of ultimate parent of u == rank of ultimate parent of v toh us case mai kisi ko bhi kisi se connect krdo
            // yaha humne v ko u mai joda

            // toh since v ko u mai joda hai toh v ka parent u hoga
            parent.set(ulp_v, ulp_u);

            // or since dono same rank ke the and combine hue toh parent ki rank bada do
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);

        }
    }


}
