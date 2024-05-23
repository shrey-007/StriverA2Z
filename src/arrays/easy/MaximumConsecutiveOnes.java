package arrays.easy;

//similar questions
/*
https://leetcode.com/problems/consecutive-characters/description/
https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/description/

https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/
https://leetcode.com/problems/max-consecutive-ones-iii/
https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
*/


public class MaximumConsecutiveOnes {
//    Q=Given a binary array nums, return the maximum number of consecutive 1's in the array.

    public static int func(int arr[]){
        int ans=0;//ye final ans hai
        int count=0;//ye temporary ans hai har stage ka
        //poore array pr traverse kro
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==1){
                //agar 1 mila toh count bada do
                count++;
            }
            else{
                //means ya toh 1 nhi mila ya fir 1 milne ki streak tut gyi toh count mai hoga kitne consecutive 1 aaye
                ans=Math.max(count,ans);
                //since streak toot gyi hai toh count=0 krdo
                count=0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
