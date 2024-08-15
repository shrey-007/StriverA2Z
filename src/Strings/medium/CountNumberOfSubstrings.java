package Strings.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k
 * distinct characters.
 */

public class CountNumberOfSubstrings {

    /**
     * Brute force is ki find all possible substring and check whether they have k distinct character or not
     * TC - N^2
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

    /** Another way you might think is ,variable sliding window */
    public int func(String s,int k){
        int start=0;
        int end=0;
        int ans=0;

        HashMap<Character,Integer> hashMap=new HashMap<>(); // to store ki kosa character kitne baar aa rha hai

        while (end<s.length()){

            // find current character
            char curr=s.charAt(end);

            // update the hashmap
            if(hashMap.containsKey(curr)){hashMap.put(curr,hashMap.get(curr)+1);}
            else{hashMap.put(curr,1);}

            // now check whether this current window can be answer or not
            if(hashMap.size()==k){
                // means ki ye ek ans hai
                ans++;
                // ab aage jaao to find more ans
                end++;
            }
            else if(hashMap.size()<k){
                // means ki abhi aur distinct character chaiye toh aage jaao
                end++;
            }
            else{
                // means ki jyaada distinct character ho gye toh peeche se hata te jaao
                while (hashMap.size()>k){
                    char charAtStart=s.charAt(start);

                    // remove the starting char from hashmap
                    hashMap.put(charAtStart,hashMap.get(charAtStart)-1);
                    if(hashMap.get(charAtStart)==0){hashMap.remove(charAtStart);}
                    start++;
                }

                // agar ab esa hua ki hashmap ka size k hai toh bhi answer hoga
                while (hashMap.size()==k){
                    ans++;
                    char charAtStart=s.charAt(start);

                    // remove the starting char from hashmap
                    hashMap.put(charAtStart,hashMap.get(charAtStart)-1);
                    if(hashMap.get(charAtStart)==0){hashMap.remove(charAtStart);}
                    start++;
                }
                end++;
            }
        }

        return ans;

    }
    /**
     * But unfortunately, sliding window won't give correct answers.
     * suppose ki tum ek particular window par ho jaha hashmap.size()==k hai, means ki us window mai k distinct characters hai.
     * Toh tumne ans++ kra uske baad kya karoge?
     * 1. Agar tumne end++ kra toh tum vo substring ko count nhi kroge jo ki khatam toh end pointer pr hi thi but shuru
     *    start ke baad se thi like ssghr isme agar k=4 and start=0(s), end=4(r) toh toh ye ans++ krke end=5 kr dega but
     *    ek answer aur aana chaye jisme start=1(s) end=4(r) hoga.
     * 2. Agar start ko badaya toh vo substring miss kr doge jo ki shuru start se honi thi and khatam end ke baad kisi index pr
     * 3. Problem ye hai ki answer milne ke baad start ko badaye ya end ko vo nhi pata, coz dono se hi answer aa rhe hai,
     *    ek ko badaoge toh doosre ke badne ke answer ko miss kr doge
     * 4. If the question was LONGEST SUBSTRING WITH K DISTINCT CHARACTER, tab sliding window se sahi answer aata coz usme, count
     *    nhi krna, usme sabse badi string chaiye toh answer milne ke baad end++ hi karege, but yaha longest nhi chaiye
     *    yaha count chaiye toh yaha ye fail ho jaaega
     * */

    /**
     *  watch pepcoding = <a href="https://www.youtube.com/watch?v=CBSeilNvZHs">Pepcoding link</a>
     *  */
    public int countSubstringsWithKDistinctChars(String s, int k) {
        int totalSubstrings = 0;

        HashMap<Character, Integer> kDistinctMap = new HashMap<>();
        HashMap<Character, Integer> kMinusOneDistinctMap = new HashMap<>();

        int bigWindowStart = -1;
        int smallWindowStart = -1;
        int commonWindowEnd = -1;

        while (true) {
            boolean expandedBigWindow = false;
            boolean expandedSmallWindow = false;
            boolean contractedCommonWindow = false;

            // Expand the big window until it has k distinct characters
            while (bigWindowStart < s.length() - 1) {
                expandedBigWindow = true;
                bigWindowStart++;
                char currChar = s.charAt(bigWindowStart);
                kDistinctMap.put(currChar, kDistinctMap.getOrDefault(currChar, 0) + 1);

                if (kDistinctMap.size() > k) {
                    removeCharacterFromMap(kDistinctMap, currChar);
                    bigWindowStart--;
                    break;
                }
            }

            // Expand the small window until it has k-1 distinct characters
            while (smallWindowStart < bigWindowStart) {
                expandedSmallWindow = true;
                smallWindowStart++;
                char currChar = s.charAt(smallWindowStart);
                kMinusOneDistinctMap.put(currChar, kMinusOneDistinctMap.getOrDefault(currChar, 0) + 1);

                if (kMinusOneDistinctMap.size() > k - 1) {
                    removeCharacterFromMap(kMinusOneDistinctMap, currChar);
                    smallWindowStart--;
                    break;
                }
            }

            // Contract the common window and count valid substrings
            while (commonWindowEnd < smallWindowStart) {
                contractedCommonWindow = true;
                if (kDistinctMap.size() == k && kMinusOneDistinctMap.size() == k - 1) {
                    totalSubstrings += bigWindowStart - smallWindowStart;
                }

                commonWindowEnd++;
                char currChar = s.charAt(commonWindowEnd);
                removeCharacterFromMap(kDistinctMap, currChar);
                removeCharacterFromMap(kMinusOneDistinctMap, currChar);

                if (kDistinctMap.size() < k - 1 || kMinusOneDistinctMap.size() < k - 1) {
                    break;
                }
            }

            if (!expandedBigWindow && !expandedSmallWindow && !contractedCommonWindow) {
                break;
            }
        }

        return totalSubstrings;
    }

    public void removeCharacterFromMap(HashMap<Character,Integer> hashMap,char curr){
        hashMap.put(curr,hashMap.get(curr)-1);
        if(hashMap.get(curr)==0){hashMap.remove(curr);}
    }

    public static void main(String[] args) {
        System.out.println(substrCount("aacaebceaac",4));
        System.out.println(substrCount("aba",2));

    }
}
