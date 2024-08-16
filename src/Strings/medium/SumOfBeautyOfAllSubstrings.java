package Strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
 *x
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 *
 **/
public class SumOfBeautyOfAllSubstrings {
    /**
     * The brute force way is ki har substring pr jaao and usme uska min,max frequency calculate kro and uska difference
     * ans mai add kro
     * */
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;


        for (int start = 0; start <n ; start++) {
            HashMap<Character,Integer> hashMap=new HashMap<>();
            for (int end = start; end < n; end++) {
                // jab-jab code is line mai aaega tab-tab new substring milegi
                // update frequency for current substring
                char curr=s.charAt(end);
                hashMap.put(curr,hashMap.getOrDefault(curr,0)+1);

                // now find the min and max frequency of this substring
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                for (int value:hashMap.values()){
                    if(value<min){min=value;}
                    if(value>max){max=value;}
                }
                ans=ans+max-min;
            }
        }

        return ans;
    }

    /**
     * Above method find all substring in n^2 and then finds the min,max from values of hashmap which will take n, so overall becomes n^3
     * Better way is ki find all substring, and instead of storing mapping in hashmap, create an array of 26 size. Ab frequency array ko traverse kre ke liye O(26) time lagega jo ki constant hai
     * so tc-26*n^2
     *
     * */
    public int beautySum2(String s) {
        int n=s.length();
        int ans=0;


        for (int start = 0; start <n ; start++) {
            int freq[]=new int[26];
            for (int end = start; end < n; end++) {
                // update frequency for current substring
                char curr=s.charAt(end);
                freq[curr-'a']++;

                // now find the min and max frequency of this substring
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;

                // pehle ye loop hashmp pr chalti thi, jiska size n ho skta tha, but frequncy array ka size 26 hi rahega
                for (int i = 0; i < 26; i++) {
                    if(freq[i]!=0){
                        min=Math.min(min,freq[i]);
                        max=Math.max(max,freq[i]);
                    }
                }
                ans=ans+max-min;
            }
        }

        return ans;
    }
}
