package BinarySearch.OneDimensionalArrays;

public class PivotElementInRotatedSortedArray {
    
    // This question is same as MinimumElementInRotatedSortedArray , NumberOfTimesArrayHasBeenRotated

    public static int func(int arr[]){
        int low = 0;
        int high = arr.length - 1;
        int ans=Integer.MAX_VALUE;

        while (low <= high) {
            // calculate middle index
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                //  means ki low to mid is sorted toh low hi minimum hoga
                ans=Math.min(ans,arr[low]);
                low = mid + 1;
            } else {
                //  means ki mid to high is sorted toh mid hi minimum hoga
                ans=Math.min(ans,arr[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }
}
