package BinarySearch.TwoDimensionalArrays;

import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int row;

    int col;
    int value;

    public Pair(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.value-o.value;
    }
}
public class MedianInRowWiseSortedMatrix {
    public static int median(int matrix[][]){

        PriorityQueue<Pair> priorityQueue=new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            priorityQueue.add(new Pair(i,0,matrix[i][0]));
        }

        int count=0;

        while (count!=(matrix.length*matrix[0].length)/2+1){
            Pair pair=priorityQueue.poll();
            int row=pair.row;
            int col=pair.col;
            count++;
            col++;
            if(col<matrix[0].length){
                priorityQueue.add(new Pair(row,col,matrix[row][col]));
            }
        }

        return priorityQueue.poll().value;

    }

    public static int median2(int matrix[][],int m,int n){
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, m, n, mid);
            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
