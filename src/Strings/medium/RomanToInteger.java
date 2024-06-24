package Strings.medium;

import java.util.HashMap;

/**
 * The concept is-:
 *  1) current character's value is >= next character value then current character's value is going to add in answer
 *     ex- XX toh 10+10 hoga
 *  2) current character's value is < next character value then current character's value is going to subtract in answer
 *     ex- XL toh -10+50 hoga
 *  3) last character ko ke baad koi character hi nhi hai toh vo hamesha add hoga
 * */


public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int n=s.length();
        int ans=0;

        for (int i = 0; i <n-1 ; i++) {
            char curr=s.charAt(i);
            char next=s.charAt(i+1);

            if(hashMap.get(curr)<hashMap.get(next)){
                ans=ans-hashMap.get(curr);
            }
            else{
                ans=ans+hashMap.get(curr);
            }
        }

        return ans+hashMap.get(s.charAt(n-1));

    }
}
