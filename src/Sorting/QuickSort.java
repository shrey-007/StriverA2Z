package Sorting;

public class QuickSort {
    //best=nlogn
    //worst=n2(mostly be avoided by using randomised quickSort)
    //recurrence relation=T(n)=2*T(n/2)+n  (for average case but dekho hum array ko half mai divide nhi krte instead pivot ke left and right mai divide krte hai)

    //suppose already sorted array mila tumhe.ab tum pivot element arr[0] ko maanoge and jab tum elements smaller than it
    //nikaaloge toh 0 aaega coz sorted array hai.toh right call  T(n/2) nhi hogi T(n-1) hogi
    //recurrence relation for worst case=T(n)=T(n-1)+n
    //jisse worst case n2 ho jaaega

    //you can improve the worst case by not taking start as pivot element
    //take pivot as random element bw start and end.

    //jab array sort krne ki baat ho toh quicksort is better than merge since it does not use any extra space
    //but jab linked list sort krna ho toh merge sort is preffered, coz usme random pivot nikaalna dificult hota hai




    //   Algorithm=
    //1) take a pivot element (first element)
    //2) pivot element ko usko sahi jagah pr rakho
    //3) pivot se chote elements uske left m rkho and usee bade elements right side pr rakho(implemented by partition method)
    //4) ab left side and right side pr individually quicksort call krdo recursively.
    public static void quickSort(int arr[],int start,int end){

        //base condition for recursion
        if(start>=end){return;}

        //starting element ko pivot maano
        //remember starting point is not always 0. toh arr[0] nhi arr[start] likhna
        int pivotElement=arr[start];

        //find number of elements smaller than pivot element
        int count=0;
        //remember 0 to n-1 nhi chalana
        //start to end chalana hai
        for (int i = start+1; i < end; i++) {
            if(arr[i]<pivotElement){count++;}
        }

        //remember start is not always 0 toh start ko add kro
        int pivotElementIndex=start+count;

        //swap start and pivotElementIndex
        int temp=arr[start];
        arr[start]=arr[pivotElementIndex];
        arr[pivotElementIndex]=temp;

        //now put all elements smaller than pivot index at left of it
        int i=start;
        int j=end;
        while (i<pivotElementIndex  && j>pivotElementIndex){
        while (i<arr.length && arr[i]<arr[pivotElementIndex]){i++;}
        while (j>0 && arr[j]>arr[pivotElementIndex]){j--;}
        //ab i pr vo element hai jo pivot se bada hai and j pr vo hai jo pivot se chota hai. so swap i and j
            if(i<pivotElementIndex  && j>pivotElementIndex){
                int temp2=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
            }

        //call recursively
        quickSort(arr,0,pivotElementIndex-1);
        quickSort(arr,pivotElementIndex+1,arr.length-1);

    }

    public static void main(String[] args) {

    }
}
