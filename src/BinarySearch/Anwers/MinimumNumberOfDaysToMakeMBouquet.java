package BinarySearch.Anwers;

public class MinimumNumberOfDaysToMakeMBouquet {
    public static int bruteForce(int[] bloomDay, int m, int k){
        // find the min and max of array
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i]>max){max=bloomDay[i];}
            if(bloomDay[i]<min){min=bloomDay[i];}
        }

        int day=min;

        while (day<=max){

            int bouquets=0;
            int adjacentCount=0;

            for (int i = 0; i < bloomDay.length; i++) {
                if(bloomDay[i]<=day){
                    // means it is bloomed
                    adjacentCount++;
                }
                else{
                    // it is not bloomed
                    adjacentCount=0;
                }
                if(adjacentCount==k){
                    adjacentCount=0;
                    bouquets++;
                }
            }

            if(bouquets>=m){return day;}
            else{day++;}
        }

        if(day>max){return -1;}

        return day;
    }

    public static int binarySearch(int[] bloomDay, int m, int k){

        // find the min and max of array
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i]>max){max=bloomDay[i];}
            if(bloomDay[i]<min){min=bloomDay[i];}
        }

        int low=min;
        int high=max;
        int ans=-1;

        while (low<=high){

            int mid=(low+high)/2;

            if(predicate(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return ans;

    }

    public static boolean predicate(int[] bloomDay, int m, int k,int days){
        int bouquets=0;
        int adjacentCount=0;

        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i]<=days){
                // means it is bloomed
                adjacentCount++;
            }
            else{
                // it is not bloomed
                adjacentCount=0;
            }
            if(adjacentCount==k){
                adjacentCount=0;
                bouquets++;
            }
        }

        return bouquets>=m;
    }

}
