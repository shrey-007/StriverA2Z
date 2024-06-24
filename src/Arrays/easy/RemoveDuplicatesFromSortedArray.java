package Arrays.easy;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

    //method1=iterate over whole array and store elements in set which stores only unique elements
    public static void func1(int arr[]){
        HashSet < Integer > set = new HashSet < > ();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int j = 0;
        for (int x: set) {
            arr[j++] = x;
        }
    }

    /*
    method2= example={0,0,1,1,1,2,2,3,3,4}
    toh i=0 and j=1
    fir j=2 hoga
    fir j=3 par unique element mila toh use store kro toh {0,1,1,1,1,2,2,3,3,4} and i=2,j=4

    */
    public static void func2(int arr[]){
        int i=0;          //index of last unique element
        int j=i+1;        //iterator, it iterates over whole array
        while (j< arr.length){
            if(arr[j]==arr[i]){
                //it is a duplicate of ith element so go ahead
                j++;
            }
            else{
                //it is a unique element toh pehle unique element ko store kro and unique element ko i store krta hai toh uska
                //index badao and usme usme store  krao
                i++;
                arr[i]=arr[j];
                j++;
            }
        }

    }

    public static void main(String[] args) {

    }
}
