package Graphs.ShortestPath;

public class FloydWarshall {
    /**
     * 1) It is multisource shortest path algorithm, tumhe n nodes denge and kuch bhi pooch lenge ki 4 to (n-2)th node ka
     *    shortest path batao, 1 to 5 ka shortest path batao and so on...
     * 2) It can work with negative weights also and can also detect negative cycle
     * */
    public void shortest_distance(int[][] matrix) {

        int n = matrix.length;

        // this is the main algo
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                            matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // yaha pr aane ke baad matrix[i][j] will hold the shortest from i to j

        // Now to detect whether it contains negative cycle or not(matrix[i][i] should contain 0, but if it contains
        // negative value means it is having negative cycle)
        for (int i = 0; i < n; i++) {
            if(matrix[i][i]<0){
                // so it is having negative cycle
            }
        }

    }

    /**
     * Time complexity-: n3(n=V) , space complexity-:n2
     * Agar har node pr jaakr Dijkstra lagaoge toh time complexity V*(E*log(V)) aaega jo ki better hai FloydWarshall se
     * but Dijkstra will not work with negative weights, FloydWarshall will.
     * */
}
