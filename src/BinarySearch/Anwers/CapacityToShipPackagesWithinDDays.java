package BinarySearch.Anwers;

public class CapacityToShipPackagesWithinDDays {
    public static int binarySearch(int[] weights, int days){
        // sum of the array elements is the maxCapacity
        int low=Integer.MAX_VALUE;
        int high=0;

        for (int i = 0; i < weights.length; i++) {
            if(weights[i]>low){low=weights[i];}
            high=high+weights[i];
        }
        int ans=-1;

        while (low<=high){
            int mid=(high+low)/2;

            if(predicate(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static boolean predicate(int[] weights, int days,int capacity){

        int currentCapacity=0;
        int currentDays=1;

        for (int i = 0; i < weights.length; i++) {
            if(capacity>=currentCapacity+weights[i]){
                currentCapacity=currentCapacity+weights[i];
            }
            else{
                currentCapacity=weights[i];
                currentDays++;
            }
        }

        return currentDays<=days;
    }
    
}
