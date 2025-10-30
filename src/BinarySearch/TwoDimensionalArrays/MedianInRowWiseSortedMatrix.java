package BinarySearch.TwoDimensionalArrays;

/**
 * Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
 * */
public class MedianInRowWiseSortedMatrix {

    public int median(int matrix[][], int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // Step 1: Determine the search space for median.
        // Since each row is sorted, the smallest element is in the first column,
        // and the largest is in the last column of some row.
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);       // minimum element in matrix
            high = Math.max(high, matrix[i][n - 1]); // maximum element in matrix
        }

        // Step 2: Binary search on the value range [low, high]
        // The median is the smallest number for which there are more than (n*m)/2 elements smaller or equal to it.
        int req = (n * m) / 2; // number of elements on the "left side" of the median in sorted order

        while (low <= high) {
            int mid = (low + high) / 2;

            // Count how many numbers are <= mid in the matrix
            int smallEqual = countSmallEqual(matrix, m, n, mid);

            // If there are <= req elements <= mid,
            // that means the true median must be greater than mid
            // (we haven't yet reached enough elements to cross the halfway point)
            if (smallEqual <= req)
                low = mid + 1; // go right
            else
                high = mid - 1; // go left
        }

        // 'low' will end up being the smallest number such that
        // more than half the elements are smaller than or equal to it — i.e., the median.
        return low;
    }

    public int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        // For each row (which is sorted), count how many elements are <= x using upper bound
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    // Custom implementation of upperBound()
// It returns the index of the first element strictly greater than x in arr[]
// So the count of elements <= x is exactly that index.
    public int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n; // if no element > x, then count = n

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;       // potential upper bound found
                high = mid - 1;  // but check if there's a smaller index that also satisfies
            } else {
                low = mid + 1;   // arr[mid] <= x → need to search right
            }
        }
        return ans;
    }

}
