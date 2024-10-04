package BinarySearch.OneDimensionalArrays;

public class PivotElementInRotatedSortedArray {
    
    // This question is same as MinimumElementInRotatedSortedArray , NumberOfTimesArrayHasBeenRotated

    /**
     * Find hinge of the rotated sorted array = Rotated sorted array is discontinous graph toh tumhe agar arr[mid]<arr[high]
     * dikha means tum right side pr ho toh left jaao. Else right jaao
     * */
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
                // but jaaege apan right side,balki hume pata hai right side mid hai jo ki bada hai fir bhi right side jaa rhe,
                // ho skta hai mid bada ho lekin mid ke baad discontinuity aa jaaye graph mai and sabse chota vhi mile
                low = mid + 1;
            } else {
                //  means ki mid to high is sorted toh mid hi minimum hoga, and jaaege bhi mid ke side(chote elements ke side)
                ans=Math.min(ans,arr[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }


    /** or you can think this in another way, code same hi hai explanation is different */
    public static int func2(int arr[]){
        int low = 0;
        int high = arr.length - 1;
        int ans=Integer.MAX_VALUE;

        while (low <= high) {
            // calculate middle index
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                //  means ki low to mid is sorted toh low hi minimum hoga, toh usko answer mai update krdo
                // Now since is part ka min element humne update kr diya but maybe pivot doosre part mai ho
                // toh hume doosre part ka min element dhoondna hai, toh doosre part mai jaao
                ans=Math.min(ans,arr[low]);
                // since abhi apan low-mid means left part mai hai toh apan ko right part mai jaana hai
                low = mid + 1;
            } else {
                //  means ki mid to high is sorted toh mid hi minimum hoga, toh answer update krdo
                // Now since is part ka min element humne update kr diya but maybe pivot doosre part mai ho
                // toh hume doosre part ka min element dhoondna hai, toh doosre part mai jaao
                ans=Math.min(ans,arr[mid]);
                // since abhi apan mid-high means right part mai hai toh apan ko left part mai jaana hai
                high = mid - 1;
            }
        }

        return ans;
    }
}
