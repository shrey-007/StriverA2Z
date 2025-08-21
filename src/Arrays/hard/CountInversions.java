package Arrays.hard;

import java.util.ArrayList;

public class CountInversions {
    // method 1 is simple 2 for loops

    // method 2 mai ese socho ki 2 sorted arrays hai
    // [2,3,5,6] and [2,2,4,4,8]
    // and i tumhe 1st array se lena hai and j tumhe 2nd array se lena hai
    /**
     * [2,3,5,6]   [2,2,4,4,8]
     *  i           j  toh yaha arr[i]>arr[j] nahi hai toh socho kaha jaoge, tumhe chaiye ki left array vala bada ho
     *  right array vale se, toh tum i++ karoge na.
     *
     *  [2,3,5,6]  [2,2,4,4,8]
     *     i        j         abhi arr[i]>arr[j] hai toh left array mai i ke baad jitne bhi elements hai voh sab bhi
     *  arr[j] se bade hai, toh total pairs 3. {3,2}{5,2}{6,2}. Toh is j ko bada do ab
     *
     *  [2,3,5,6]  [2,2,4,4,8]
     *     i          j         abhi arr[i]>arr[j] hai toh left array mai i ke baad jitne bhi elements hai voh sab bhi
     *  arr[j] se bade hai, toh total pairs 3. {3,2}{5,2}{6,2}. Toh is j ko bada do ab
     *
     *  [2,3,5,6]  [2,2,4,4,8]
     *     i            j         abhi arr[i]>arr[j] nahi hai toh i++ kro
     *
     *  [2,3,5,6]  [2,2,4,4,8] abhi arr[i]>arr[j] hai toh left array mai i ke baad jitne bhi elements hai voh sab bhi
     *       i          j
     *  arr[j] se bade hai, toh total pairs 2. {5,4}{6,4}. Toh is j ko bada do ab.
     *
     *  and so on. Toh ye question agar esa hota 2 sorted vala toh easy hota, toh ise esa bana do, isme merge sirt lagao
     *  merge function mai tumhe 2 sorted arrays milege unse coun nikaal lena inverse pairs ka, and unko merge bhi kr dena
     *
     *  means count bhi krte jaaoa and sort bhi krte jaao
     *
     * */



    // method 2 we use mergeSort, watch striver video get how its working or if you can dry run mergeSort it will easy for you

    static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(arr,0,arr.length-1);
    }

    static int mergeSort(int arr[],int start,int end){
        if(start>=end) return 0;
        int mid = (start+end)/2;
        int count = 0;

        count += mergeSort(arr,start,mid);
        count += mergeSort(arr,mid+1,end);
        count += merge(arr,start,mid,end);
        return count;
    }

    static int merge(int arr[],int start,int mid,int end){
        int count = 0;
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
        int j=0;
        int index = 0;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[start+index] = left[i];
                i++;
                index++;
            }
            else{
                arr[start+index] = right[j];
                j++;
                index++;
                count += (n1-i);
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
