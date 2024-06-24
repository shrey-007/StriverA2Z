package Sorting;

public class MergeSort {
    public static void merge(int arr[],int start,int mid,int end){
        int left[]=new int[mid-start+1];
        int right[]=new int[end-mid];

        for (int i =0; i < left.length ; i++) {
            left[i]=arr[start+i];
        }
        for (int i =0; i < right.length ; i++) {
            right[i]=arr[mid+i];
        }

        int l=0;
        int r=0;
        int k=start;
        while(l<left.length && r< right.length){
            if(left[l]<right[r]){
                arr[k]=left[l];
                l++;
                k++;
            }
            else{
                arr[k]=right[r];
                k++;
                r++;
            }
        }

        while (l<left.length){
            arr[k]=left[l];
            l++;
            k++;
        }
        while ( r< right.length){
            arr[k]=right[r];
            k++;
            r++;
        }

    }

    public static void func(int [] arr,int start,int end){
        int mid=(start+end)/2;
        func(arr,start,mid);
        func(arr,mid,end);
        merge(arr,start,mid,end);
    }

    public static void main(String[] args) {
        int arr[]={2,3,1,7,5};

        func(arr,0, arr.length-1);
        Helper.print(arr);
    }
}
