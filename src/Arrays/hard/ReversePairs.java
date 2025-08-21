package Arrays.hard;

public class ReversePairs {
    // ditto same as count inversion
    // bas count inversion mai merge krte-krte count krte the, yaha mat krna
    // yaha pehel count kro fir merge kro
    // yaha har left element ke liye check kro konsa right vala pair baanaega, and fir optimize kro
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int arr[],int start,int end){
        if(start>=end) return 0;
        int mid = (start+end)/2;
        int count = 0;

        count += mergeSort(arr,start,mid);
        count += mergeSort(arr,mid+1,end);
        count += merge(arr,start,mid,end);
        return count;
    }

    public int merge(int arr[],int start,int mid,int end){
        int count = 0;

        // Count reverse pairs
        // for every element on the left, dekho ki usse kon pair banaega right ka
        // then optimize
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && (long)arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));

        }

        int n = arr.length;
        // start to mid is sorted and mid+1 to end is sorted
        int left[] = new int[mid-start+1];
        int right[] = new int[end-mid];
        int n1 = mid-start+1;
        int n2 = end-mid;

        for(int i=0;i<n1;i++){
            left[i] = arr[start+i];
        }

        for(int i=0;i<n2;i++){
            right[i] = arr[mid+1+i];
        }

        int i=0;
        j=0;
        int index = 0;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[start+index] = left[i];
                i++;
                index++;
            }
            else{
                // if(left[i]>2*right[j]) count += (n1-i);
                arr[start+index] = right[j];
                j++;
                index++;
            }
        }

        while(i<n1){
            arr[start+index] = left[i];
            i++;
            index++;
        }
        while(j<n2){
            arr[start+index] = right[j];
            j++;
            index++;
        }

        return count;
    }
}
