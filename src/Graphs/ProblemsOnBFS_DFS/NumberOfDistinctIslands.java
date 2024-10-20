package Graphs.ProblemsOnBFS_DFS;

public class NumberOfDistinctIslands {
    /**
     * The **"Number of Distinct Islands"** is a problem where you're given a 2D grid representing land (`1`) and water (`0`).
     * An island is a group of connected `1`s, where connection means they are adjacent either horizontally or vertically.
     * The goal is to determine the number of **distinct** islands, where two islands are considered distinct if their
     * shapes (structure and relative positions of land cells) are different.
     *
     * ### Problem Breakdown:
     * - You are given a 2D grid (matrix) of `0`s and `1`s.
     * - Islands are formed by `1`s connected horizontally or vertically.
     * - You need to find out how many distinct shapes of islands are present. Two islands are distinct if their shapes
     * differ, even if one is a rotated or translated version of the other.
     *
     * ### Key Points:
     * 1. **Connected Cells**: Cells are connected if they are adjacent either up, down, left, or right.
     * 2. **Shape of an Island**: The shape of the island is determined by its structure. Two islands with the same set of
     * relative positions of their `1`s will be considered the same, even if they are in different parts of the grid.
     * 3. **Distinct Islands**: Islands are distinct if their shapes are different when normalized for translation
     * (shifting). You should not treat islands as distinct if they are just translations of one another (moved versions).
     *
     * ### Approach:
     * 1. **DFS or BFS for Island Detection**: To detect each island, you can use a depth-first search (DFS) or breadth-first
     * search (BFS) to explore all `1`s connected to a starting `1`.
     * 2. **Relative Positioning**: As you traverse an island, store the relative coordinates of all `1`s in the island,
     * normalized to the starting point.
     * 3. **Normalization**: For distinctness, the island shape should be stored in a normalized form where the coordinates
     * are relative to the top-left corner of the island. This allows you to compare shapes irrespective of their position
     * in the grid.
     * 4. **Set for Distinct Shapes**: Use a set to store unique island shapes. Since sets only keep unique elements,
     * adding the same shape will not duplicate it.
     * */
}
