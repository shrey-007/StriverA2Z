package arrays.easy;

public class SecondLargestElement {
    //given an  array return the second largest element in one iteration O(n)
    public static int func(int arr[]){
        int largest=arr[0];
        int secondLargest=-1;

        //initialy first element ko largest and imaginary element ko seconlargest maan liya ab traverse kro and largest and
        //secondlargest ko update krte jaao

        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>=largest){
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest){
                secondLargest=arr[i];
            }
        }
        
        return secondLargest;
    }
    public static void main(String[] args) {
        int arr[]={2,3,56,23,1,54,33};
    }
}
