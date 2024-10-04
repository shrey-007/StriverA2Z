package BinarySearch.Anwers;

import com.sun.security.auth.UnixNumericGroupPrincipal;

/**
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of
 * any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 *
 * This is same as Painter's Partition
 * This is same as Book allocation which we have already done
 * we have to find the combination jisme max parttion sum is min, toh hum jo dhoondh rhe hai vahi mid hoga
 *
 * Toh hume ye check krna hai ki kya 'mid' is the lagest partition in the array, hum min nhi dekh rhe abhi , abhi bas
 * ye dekho ki min ko sabse bada partition bana skte hai kya grp ka, if yes toh mid is ans but ab peeche jaao check kro
 *
 * Toh ye check krne ke liye ki kya mid ans hai toh apan ko constraint diya hai ki k groups mai divide hona chaoue, toh
 * bas ye dekhlo ki agar mid is the largest partition toh usme jo number of partition ban rhe h voh less than k hone chaoiye
 * if yes toh mid is valid ans else no
 *
 *
 * */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {

        // low is max of arr, high is sum of all elements of arr
        int low=0;
        int high=0;


        for (int i: nums){
            low=Math.max(low,i);
            high=high+i;
        }

        int ans=Integer.MAX_VALUE;

        while (low<=high){

            int mid=(low+high)/2;

            if(predicate(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean predicate(int nums[],int k,int mid){
        int currentPartition=1;
        int currentPartitionSum=0;

        for (int i:nums){
            if(currentPartitionSum+i<=mid){
                currentPartitionSum=currentPartitionSum+i;
            }
            else{
                currentPartitionSum=i;
                currentPartition++;
            }
        }

        return currentPartition<=k;
    }

}
