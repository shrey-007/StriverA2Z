package Arrays.hard;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> func1(int [] arr,int target){
        HashSet<List<Integer>> listHashSet=new HashSet<>();
        for (int i = 0; i <arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                //toh apan ko arr[i]+arr[j] sum mil gya h ab , remaining sum ke lie 2 sum laga do
                HashSet<Integer> hashSet=new HashSet<>();
                for (int k = j+1; k < arr.length; k++) {
                    // i, j , k look for all possible combinations while hashSet mai sirf i to k vaali values hi add krte hai
                    if(hashSet.contains(target-arr[i]-arr[j]-arr[k])){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(target-arr[i]-arr[j]-arr[k]);
                        Collections.sort(temp);
                        listHashSet.add(temp);
                    }
                    else{hashSet.add(arr[k]);}
                }
            }
        }

        List<List<Integer>> ans=new ArrayList<>(listHashSet);
        return ans;
    }

//    this above methos is totally correct , but problem is ki 4 numbers ka sum int ki range se bahar jaa ja rha hai.
//    so below is corrected code, method same hai hai dono ka
    public static List<List<Integer>> func2(int nums[],int target){
        int n = nums.length; // size of the array
        Set<List<Integer>> st = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    // put the kth element into the hashset:
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    public static List<List<Integer>> func3(int nums[],int target){
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // fix i and j
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
