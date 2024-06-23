package BinarySearch.Anwers;

/**
 Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

 Return the kth positive integer that is missing from this array.
 */

public class KthMissingPositiveNumber {
    /** Take an example,
     arr = [2,3,4,7,11] this is original array
     arr2 = [1,2,3,4,5]  this is the array if no number was missing so if i simply want ki ith index tak kitne number
    index=   0 1 2 3 4
     number of numbers missing = 1 1 1 3 6
     miss ho chuke hai toh arr[i]-(i+1)= arr[i]-i-1

     k=5 toh apan ko 5th missing number chaiye hai, toh brute force mai apan simply har index pr jaaege nad check krege ki us index tak kitne number missing hai
     */

    public static int bruteForce(int[] arr, int k){
        int ans=-1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]-i-1>=k){
                // means ki apan 4th index pr aagye jaha pr 6 numbers missing hai, but apan ko chaiye hai 5th missing
                // number toh answer arr[i-1] and arr[i] ke beech mai se koi hoga i.e 7 se 11 ke beech mai hoga
                //
             }
             i--;   // ab apan 3rd index pr aagye i.e 7 pr yaha tak 3 numbers missing hai and apan ko 5th missing number
            // chaiye toh 2 number aage chale jaao
            // current element= arr[i]
            // number of missing elements we want = arr[i]-i-1
            // number of missing elements we want= k
            // answer tak pahuchne ke liye kitne aage jaana hai= (number of missing elements we want)-(number of missing elements we want)
            //                                                 = k-(arr[i]-i-1)
            // Toh ans= current element+answer tak pahuchne ke liye kitne aage jaana hai
            //          arr[i]+k-(arr[i]-i-1) = k+i+1
            return k+i+1;
        }

        /**
         Agar yaha tak aagye and answer nhi mila means esa case hai
         arr = [1,2,3,4,5] and k=4
         toh missing elements are = {6,7,8,9,10,11,12..} so answer is 9

         Is case mai arr[i]-i-1>=k vaali condition kabhi true nhi hogi toh answer jo hai vo last index ke baad aane vaale numbers hoge
         Toh answer vahi hai is baar bhi bas i ki jagah arr.length-1 hoga
         */
        return k+arr.length-1+1;

    }

    // Ab ye question binarySearch se krlo
    public boolean predicate(int arr[],int k,int index){
        return arr[index]-index-1>=k;
    }
    public int binarySearch(int[] arr, int k) {
        int high=arr.length-1;
        int low=0;
        int ans=-1;

        while (low<=high){

            int mid=(high+low)/2;

            if(predicate(arr,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(ans==-1){ans= arr.length;}

        if(ans!=0){
            int numberOfMissingNumbersTillLastIndex=arr[ans-1]-ans;
            int numberOnLastIndex=arr[ans-1];
            while (numberOfMissingNumbersTillLastIndex!=k){
                numberOnLastIndex++;
                numberOfMissingNumbersTillLastIndex++;
            }

            return numberOnLastIndex;
        }
        else{
            if(arr[0]>k){return k;}
            else{return arr[0]+k;}
        }


    }

    public static void main(String[] args) {

    }

}
