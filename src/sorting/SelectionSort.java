package sorting;

public class SelectionSort {
    //best,worst=n2
    //not stable

    //since ith place pr konsa element aayega uske liye apan ye dekte hai ki i se end tak ka smallest element kon hai
    //toh simply apan ko vo pata krne ke liye i se end tak iterate krna padega
    //toh bhale hi already sorted array bhi kiu na ho n2 time hi lagega

    public static int[] func(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            //find smallest element from ith index to end
            //maan lo ki current element hi minimum hai, ab yaha se end tak dekho ki isse chota koi aur element hai kya
            int smallestElementIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[smallestElementIndex]){
                    smallestElementIndex=j;
                }
            }

            //swap the current element with smallest element
            int temp=arr[i];
            arr[i]=arr[smallestElementIndex];
            arr[smallestElementIndex]=temp;

        }
        return arr;

    }
    //humne starting se start kra and dekha min element kon hai and usse starting vaale ko swap kra
    //hum ulta bhi kr skte the
    //last se start kro and dekho ki max element kon hai and usko last vaale ko swap kra

    public static void main(String[] args) {
        int arr[]={2,3,1,7,5};

        func(arr);
        Helper.print(arr);
    }
}
