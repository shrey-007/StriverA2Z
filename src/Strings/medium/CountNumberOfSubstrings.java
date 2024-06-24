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

    // two pointer approach

    public static long substrCount2(String s,int k){
        long ans=0;
        int n=s.length();

        int start=0;
        int end=0;

        HashMap<Character,Integer> hashMap=new HashMap<>();

        while (end<n){
            char curr=s.charAt(end);

            if(hashMap.containsKey(curr)){hashMap.put(curr,hashMap.get(curr)+1);}
            else{hashMap.put(curr,1);}

            if(hashMap.size()==k){
                // means this is the answer so increase the count
                ans++;
                end++;
            }
            else if(hashMap.size()<k){
                // means ki abhi aur distinct characters chaiye hai toh aage jaao
                end++;
            }
            else{
                // means ki ab jyaada distinct characters ho gye
                // toh start se character hatao jab tak kam ni ho jaate
                while (hashMap.size()>k){
                    char sc=s.charAt(start);
                    hashMap.put(sc,hashMap.get(sc)-1);
                    if(hashMap.get(sc)==0){hashMap.remove(sc);}
                    start++;
                }
            }
        }

        if(hashMap.size()==k){ans++;}

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(substrCount2("aacaebceaac",4));
//        System.out.println(substrCount2("aba",2));
        System.out.println(substrCount2("ecbaddce",3));
        System.out.println(substrCount2("abaaca",1));
        System.out.println(substrCount2("aacaebceaac",4));
    }
}
