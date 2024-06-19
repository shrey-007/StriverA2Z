package BinarySearch.OneDimensionalArrays;

public class FindPeakInMountainArray {
    /**
      The graph of mountain array is like

         *
        * *
       *   *
      *


     This mountain array can have multiple peaks and u can return any one of it.
     The condition for the peak element is

     (i==0 || arr[i]>arr[i+1]) && (i==arr.length-1 || arr[i]>arr[i-1])

      */

    public static int func(int arr[]){

        int low=0;
        int high= arr.length-1;

        while (low<=high){

            int mid=(low+high)/2;

            // check whether mid is peak element or not
            if((mid==0 || arr[mid]>arr[mid+1]) && (mid==arr.length-1 || arr[mid]>arr[mid-1])){
                return mid;
            }

            else if(arr[mid]<arr[mid+1]){
                // we are on increasing part so go up
                low=mid+1;
            }
            else{
                // we are on decreasing part so go up
                high=mid-1;
            }
        }

        return -1;
    }

}
