
package Sorting;



public class BubbleSort {
    //worst=n2
    //best=n2, it can be n if we optimise the bubble sort taking a flag variable
    //stable


    public static int [] func(int arr[]){
        ////iteration 1 mai sabse chota vaala 0th index pr aa jaaega

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }


        return arr;
    }
    //we can also write this as
    public static void func2(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            //har ith iteration pr i items sahi jaga pe place ho jaaege, ab agar apan ko saare elements sahi jagah
            // rakhna hai toh n times loop chalao coz n elements hai.
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]>arr[j+1]){
                    //swap j and j+1
                }
            }
        }
    }

    //above dono methods mai har case mai 0(n2) hi aaegi complexity coz farak nhi pdta ki array sorted hai ya nhi hum
    //hamesha n2 iterations kr rhe hai.

    // Q=find number of maximum swaps required to sort an array.
    //Ans=simply take desending array.  ans is n*(n-1)/2

    //in this below method worst case is still n2
    //but best case (sorted array) vo n2 nhi n time lega

    public static void func3(int arr[]){
        boolean flag=false;
        //hume ye pta krna hai ki array kisi iteration mai swaps hue h ya nhi
        //agar poore iteration mai swap nhi hue toh means ki array is sorted. we dont need to go further
        for (int i = 0; i < arr.length; i++) {
            //har ith iteration pr i items sahi jaga pe place ho jaaege, ab agar apan ko saare elements sahi jagah
            // rakhna hai toh n times loop chalao coz n elements hai.
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]>arr[j+1]){
                    //swap j and j+1
                    //since swap hua hai toh flag ko true krdo
                    flag=true;
                }
            }
            //ab yaha check kro ki i ki is iteration mai swaps hue h ki nhi
            if(!flag){//nhi hue toh stop right here
                return;
                 }

        }

    }

    public static void main(String[] args) {
        int arr[]={2,3,1,7,5};

        func(arr);
        Helper.print(arr);
    }
}
