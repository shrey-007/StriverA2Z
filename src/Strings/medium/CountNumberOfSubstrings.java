package Strings.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k
 * distinct characters.
 */

public class CountNumberOfSubstrings {

    /**
     * This is same as finding all substrings of a string using a brute force O(n2) complexity.
     * Bas isme ek condition extra krdo ki substring tabhi count krege jab usme k distinct characters hoge
     * */
    static long substrCount (String s, int k) {

        long ans=0;  // It is the count of all substring jinme k district character hai
        int n=s.length();

        for (int i = 0; i <n ; i++) {

            // substring starting from i
            char ci=s.charAt(i);

            HashSet<Character> hashSet=new HashSet<>();  // to find how many distinct characters are there between i and j
            hashSet.add(ci);

            if (k== hashSet.size()){ans++;}

            for (int j = i+1; j < n; j++) {
                // substring ending at j, aur iterate bhi j se hi kr rhe hai
                char cj=s.charAt(j);
                hashSet.add(cj);
                if (k== hashSet.size()){ans++;}
                else if(k> hashSet.size()){
                    // toh is case mai sirf j ko badao coz aage aur distinct character aa jaege, and j apne aap badh jaaega
                }
                else{
                    break;
                    // means ab aage jaane ka koi sense nhi hai coz distinct characters badte jaaege
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(substrCount("aacaebceaac",4));
        System.out.println(substrCount("aba",2));

    }
}
