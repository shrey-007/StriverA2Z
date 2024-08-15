package Strings.easy;

import java.util.HashMap;
import java.util.HashSet;


/**
 *
 Given two strings s and t, determine if they are isomorphic.

 Two strings s and t are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



 Example 1:

 Input: s = "egg", t = "add"
 Output: true
 Example 2:

 Input: s = "foo", t = "bar"
 Output: false*/
public class IsomorphicStrings {

    // We can use HashMap
    // Here we are iterating strings only once but in each iteration we are storing and retreiving from hashmap which on
    // an avg takes O(1) but in worst case it could lead to O(n) due to hash collision
    public boolean isIsomorphic1(String s, String t) {

        // This method is wrong, because ye bas ye check rha hai ki s ka character, t ke ek particular character ko hi map kr rha hai ki nhi
        // but ye check nhi kr rha ki t ka character, s ke multiple character se map toh nhi hai
        // agar e->f and r->f hai toh ye sahi bata dega but ye galat hai, toh ya toh ek aur hashmap banao t string ke liye, and usme bhi same cheej kro ki t ka ek character s ke ek hi character se map krna chaiye
        // Or use array vaala method jo ki neeche kra hai
        HashMap<Character,Character> hm=new HashMap<>();


        int n=s.length();

        for(int i=0;i<n;i++){

            char sc=s.charAt(i);
            char tc=t.charAt(i);

            // we have to map s.charAt(i)->t.charAt(i)
            if(hm.containsKey(sc)){
                // means it is already mapped toh check kro isi se map hai ki kisi aur se
                if(tc!=hm.get(sc)){return false;}
            }
            else{
                // means s.charAt(i) is not mapped, toh map kro but first check this
                if(hm.containsValue(tc)){
                    // means t.charAt(i) is already mapped toh apan map nhi kr skte
                    return false;}
                hm.put(sc,tc);
            }
        }

        return true;
    }


    // We can use Array
    // Here we are iterating strings only once but in each iteration we are storing and retreiving from array which always takes O(1)

    public boolean isIsomorphic2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // maps s ka character to t ka character
        int[] sMapping = new int[256];
        // maps t ka character to s ka character
        int[] tMapping = new int[256];
        // toh sMapping[i]==tMapping[i] hoga

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (sMapping[c1] != tMapping[c2]) {
                return false;
            }

            // Update the last seen positions
            sMapping[c1] = i + 1;
            tMapping[c2] = i + 1;
        }
        return true;
    }

}
