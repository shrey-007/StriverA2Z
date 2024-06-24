package Arrays.custom;

import Sorting.Helper;

//sort an array containing only 0 and 1
public class sort_0_1 {
    public static int[] func(int arr[]){
        //take two pointers at start and end
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            if(arr[start]==0){
                //favourable case of start
                start++;
            }
            else if (arr[end]==1) {
                //favourable case of end
                end--;
            }
            else{
                //non favouable case for both
                //swap start and end
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        return arr;    }

    public static void func2(int arr[]){

    }


    public static void main(String[] args) {
        int arr[]={0,0,1,1,0,0,1};
        Helper.print(func(arr));
    }
}
