package Sorting;

public class InsertionSort {
    //best=n(when array is already sorted).coz usme under vaali loop kabhi chalegi hi nhi.
    //worst=n2

    public static int [] func(int arr[]){
        //0th index is always sorted.first non sorted index is 1 so we will start our loop from 1
        for (int i = 1; i < arr.length ; i++) {
           //start from i and go backwards
            //i is pointing to first index of non sorted part
           int j=i;
           while(j>0 && arr[j]<arr[j-1]){
               //swap j and j-1
               int temp=arr[j];
               arr[j]=arr[j-1];
               arr[j-1]=temp;
               j--;
           }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[]={2,3,1,7,5};

        func(arr);
        Helper.print(arr);
    }
}
