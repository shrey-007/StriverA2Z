package BinarySearch.OneDimensionalArrays;

import java.util.ArrayList;

public class SearchInRotatedSortedArray {

    // Here all the elements are unique
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (arr.get(mid) == k)
                return mid;

            // if left part is sorted (yahi condition hai sorted hone ki remember it ki "equal to" bhi aaega)
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    // target element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    // terget element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Here repetition is also possible
    /**
     Take an example [3 1 2 3 3 3 3]
                      l     m     h
     Now here arr[low]<=arr[mid] but still left part is not sorted. Also arr[low]=arr[mid]=arr[high] toh yaha problem hai
     iske kaaran apan ye nhi bata skte ki right part sorted hai ki left part sorted hai toh hiska solution ye hai ki
     h--; l++; krdo. Since arr[low]=arr[mid]=arr[high] hai and arr[mid]!=target toh arr[low] and arr[high] bhi target ke
     equal nhi hai. Toh us part ko hata do h--; l++;

     [3 1 2 3 3 3 3]
        l   m   h
     Ab normal ho gya toh previous code will work good
     */
    public static int search2(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (arr.get(mid) == k)
                return mid;

            // This is the only modication
            if(arr.get(mid)==arr.get(high) && arr.get(mid)==arr.get(low)){low++;high--;continue;}

            // if left part is sorted (yahi condition hai sorted hone ki remeber it ki equal to bhi aaega)
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) <= k && k <= arr.get(mid)) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (arr.get(mid) <= k && k <= arr.get(high)) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

}
