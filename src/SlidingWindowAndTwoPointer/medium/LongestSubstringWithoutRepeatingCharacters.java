package SlidingWindowAndTwoPointer.medium;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Brute force-:
     * 1) i se start hogi substring , j pr khatam hogi
     * 2) i to j calculate kro ki hashmap mai duplicate element toh nhi hai*/

    public static int lengthOfLongestSubstring(String s) {

        int ans=0;

        for (int i = 0; i < s.length(); i++) {

            HashSet<Character> hashSet=new HashSet<>();
            int count=0;

            for (int j = i; j < s.length(); j++) {

                char curr=s.charAt(j);

                if(hashSet.contains(curr)){
                    if(ans<count){ans=count;}
                    break;
                }
                else{
                    hashSet.add(curr);
                    count++;
                }
            }
        }

        return ans;

    }

    /** sliding window */

    public static int lengthOfLongestSubstring2(String s) {

        int ans=0;

        int start=0;
        int end=0;

        HashSet<Character> hashSet=new HashSet<>();

        while (end<s.length()){

            char curr=s.charAt(end);
//
//            if(hashSet.contains(curr)){
//                while (hashSet.contains(curr)){
//                    hashSet.remove(s.charAt(start));
//                    start++;
//                }
//                end++;
//            }

            /**Uper jo comment mai condition hai vo may be sahi lag rhi ho, but answer totally different aa rha hai
             * Isliye neeche vaali condition use kro
             * */
            if(hashSet.contains(curr)){
                while (curr!=s.charAt(start)){
                    hashSet.remove(s.charAt(start));
                    start++;
                }
                // means ki start and end pr same char aagye toh ab loop kahatam ho gyi pr abhi bhi duplicate entry hai
                // coz start=end toh start++ ek baar aur kro
                start++;
                end++;
            }

            else{
                hashSet.add(curr);
                ans=Math.max(ans,end-start+1);
                end++;
            }

        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
