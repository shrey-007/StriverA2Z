package arrays.hard;

public class FindRepeatedAndMissingNumber {
    // Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2,....,N} is missing and
    // one number 'B' occurs twice in array. Find these two numbers.
    public static int [] func(int arr[],int n){

        // Calculate the expected sum and sum of squares for the first n natural numbers
        long originalSum = (n * (n + 1)) / 2;
        long originalSumOfSquares = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate the actual sum and sum of squares from the array
        long sum = 0L;
        long sumOfSquares = 0L;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            sumOfSquares += (long) arr[i] * arr[i];
        }

        // Calculate the differences
        // let x be the missing number, and y be the repeating one
        long diffSum = originalSum - sum; // x - y
        long diffSumOfSquares = originalSumOfSquares - sumOfSquares; // x^2 - y^2

        // From diffSum and diffSumOfSquares, we get two equations:
        // 1. x - y = diffSum
        // 2. x^2 - y^2 = diffSumOfSquares
        // => (x - y)(x + y) = diffSumOfSquares
        // => diffSum * (x + y) = diffSumOfSquares
        // => x + y = diffSumOfSquares / diffSum

        long sumXY = diffSumOfSquares / diffSum;

        // Now we have two equations:
        // x - y = diffSum
        // x + y = sumXY

        // Solving these equations:
        int x = (int) (diffSum + sumXY) / 2;
        int y = (int) (sumXY - diffSum) / 2;

        // Prepare the result array
        int[] ans = new int[2];
        ans[0] = y; // The repeating number
        ans[1] = x; // The missing number

        return ans;

        }


    }

