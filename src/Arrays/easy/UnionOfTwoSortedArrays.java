package Arrays.easy;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[]={2,6,32,54,63,76};
        int arr2[]={2,2,2,56,63,89};
        int ans[]=new int[100];
        //it is same as merging of two sorted arrays in merge sort only differnce is we have to check ki k mai duplicates toh nhi hai
//      //we will only add arr1[i] or arr2[j] if they r not present in ans
        int i=0;
        int j=0;
        int k=0;

        while(i< arr1.length && j< arr2.length){
//            arr1[ i ] > arr2[ j ] so we need to insert arr2[ j ] in union. IF the last element in the union vector is not equal to arr2[ j ], then insert in the union, else don’t inser
           if(arr1[i]<=arr2[j]){
             if(ans[k]!=arr1[i]){
                 ans[k]=arr1[i];
                 k++;
             }
             i++;
           }
           else{

               if(ans[k]!=arr2[j]){
                   ans[k]=arr2[j];
                   k++;
               }
               j++;
           }
        }

        //now remaining cases
        while (i<arr1.length){
            if(ans[k]!=arr1[i]){
                ans[k]=arr1[i];
                k++;
            }
            i++;
        }
        while (j<arr1.length){
            if(ans[k]!=arr2[j]){
                ans[k]=arr2[j];
                k++;
            }
            j++;
        }


    }
}
