package arrays.medium;

import sorting.Helper;

import java.util.HashMap;

public class Two_Sum {

    //try out all possible combinations O(n2)
    public static int[] func(int arr[],int target){
        int ans[]=new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }

    //tc=0(n)
    //sc=o(n)
    //use hashmap to store elements of array.

    public static int[] func2(int arr[],int target){
        int ans[]=new int[2];

        HashMap<Integer,Integer> hashMap=new HashMap<>();

        //travese whole array
        for (int i = 0; i < arr.length; i++) {
            //current element is arr[i] and if hashmap already contains target-arr[i] then it is our ans.return it
            if(hashMap.containsKey(target-arr[i])){
                ans[0]=i;ans[1]=hashMap.get(target-arr[i]);
                 return ans;
            }
            //if hashmap does not contain counter part then just store current element in your hashmap
            hashMap.put(arr[i],i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        Helper.print(func2(arr,9));
    }
}
