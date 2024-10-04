package BinarySearch.Anwers;

import java.util.Arrays;

public class AggressiveCows {
    /**
     * Link-: https://leetcode.com/problems/magnetic-force-between-two-balls/description/
     *
     * we have to find max of min distance , toh BS min distance par lagega
     * check kro ki mid min distance ho skta hai kya, if yes toh mid is possible and ans increase mid since we want max,
     * else decrease mid
     *
     * How to check ki x min distance ho skta hai-:
     * 1. sort the position array
     * 2. Now start putting first ball in first basket
     * 3. Now second ball ko second basket mai tabhi daal skte hai if (distance between 1st and 2nd basket is more than
     *    equal to x) else nhi daal skte, agar daal skte hai toh daall do , if nhi daal skte toh dekho 3rd basket mai daal skte hai kya and so on..
     * 4. Agar saari baskets iterate krli and fir bhi balls bachi hai jo kahi  bhi put nhi hui toh x can not be answer
     * */

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int max = Integer.MIN_VALUE;
        int n = position.length;

        for(int i=0;i<n;i++){
            if(position[i]>max){max = position[i];}
        }

        // Apply BS
        int low = 0;
        int high = max;
        int ans = Integer.MIN_VALUE;

        while(low<=high){
            int mid = (low+high)/2;

            if(predicate(mid,position,m)){
                // so this is possible answer so update ans
                ans = mid;
                // but we want maximim force(largest distance between balls) toh right side jaao
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }

    public boolean predicate(int minSpaceBetweenBalls,int[] positionOfBaskets,int numberOfBalls){
        // start putting first ball in 1st basket
        // second ball ko minSpaceBetweenBalls door rakhna 1st se and so on..
        // check kro ki last ball ki position kya hai

        numberOfBalls--; // first ball ko first basket mai daal diya
        int positionOfLastBall = positionOfBaskets[0];
        int n=positionOfBaskets.length;

        for(int i=1;i<n;i++){
            if(positionOfBaskets[i]-positionOfLastBall>=minSpaceBetweenBalls){
                // toh is position par ball rakh skte ho
                numberOfBalls--;
                if(numberOfBalls==0){
                    // means all balls are placed
                    return true;
                }
                positionOfLastBall = positionOfBaskets[i];
            }
        }

        // yaha tak aaye means all balls are not placed
        return false;
    }

}
