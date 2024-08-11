package StackAndQueues.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumberOfNGEsToTheRight {
    /**
     * If you are at index i, you just have to calculate number of elements in right , which are bigger than arr[i]
     * Toh bas i to n-1 loop chala kr dekhlo
     * So this will take O(N2)
     * -----------------------------------NO NEED OF STACK HERE---------------------------------------------------
     * IGNORE BELOW CODE
     *
     * */
    public static int[] countNGEs(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                countMap.put(index, countMap.getOrDefault(index, 0) + 1);
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            result[i] = countMap.getOrDefault(i, 0);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = countNGEs(arr);
        System.out.println(Arrays.toString(result));
    }
}
