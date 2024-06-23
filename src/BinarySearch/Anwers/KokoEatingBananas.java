package BinarySearch.Anwers;

public class KokoEatingBananas {


    /**
     Ok so first comes the brute force approach
     1) Apan ko minimum speed chaiye jisme koko apne bananas khaale toh simply 1 se start kro and speed badate jaao jis
        jis speed pr vo finish krle banana vahi answer hai
     2) Since apan i=1 to infinite jaa rhe hai hai and check kr rhe hai ki konsi speed ans hogi toh jo apne answer ki range
        hai vo sorted hai agar x speed pr nhi khaa paayi toh x-1 pr bhi nhi khaa paaegi toh BS lagaya
     */

    // method 1
    public static int bruteForce(int [] piles,int h){
        int speed=0;

        while (speed<100000000){
            // check whether ki is speed pr kahatam kr legi vo banana ki nhi
            int timeTaken=0;
            for (int i = 0; i <piles.length; i++) {
                if(piles[i]%speed==0){timeTaken=timeTaken+piles[i]/speed;}
                else{timeTaken=timeTaken+piles[i]/speed+1;}
            }

            // toh speed(speed) se agar vo khaaegi toh use timeTake time lagega but use h mai khatam krna hai toh dekho h bada h ki timeTaken
            if(timeTaken>h){
                // means jyaada time laga toh speed badao
                speed++;
            }
            else{
                break;
            }
        }

        return speed;
    }
    public static boolean predicate(int[] piles, int speed,int h){
        int timeInHours=0;

        for (int i = 0; i < piles.length; i++) {
            if(piles[i]%speed==0){timeInHours=timeInHours+piles[i]/speed;}
            else{timeInHours=timeInHours+piles[i]/speed+1;}
        }

        return timeInHours<=h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int start=piles.length;
        int end=1000000000;
        int ans=-1;

        while (end>=start){

            int mid=(start+end)/2;

            if(predicate(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}
