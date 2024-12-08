package Recursion.allCombinations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * */
public class WordBreak {

    // there are 2 ways to solve this question, one is my way
    // another is same method as that of palindromic partition. use that only

    public static boolean wordBreak(String s, List<String> wordDict) {

        // add the dictionary to hashmap
        HashSet<String> hashSet = new HashSet<>();
        int n=wordDict.size();
        for(int i=0;i<n;i++){
            hashSet.add(wordDict.get(i));
        }

        // now do recursion
        return func(s,0,new String(""),hashSet);
    }

    public static boolean func(String s,int index,String currentWord,HashSet<String> hashSet){
        if(index==s.length()){
            if(currentWord.equals("")){return true;}
            if(hashSet.contains(currentWord)){return true;}
            else{return false;}
        }
        // it is like kadane algorithm, we have two options , either hum currentCharacter ko currentWord mai add krde
        // ya fir new word create kre currentCharacter se
        // ex-: currentWord - cat
        //      currentCharacter - s
        // Ab option 1 - "cats"
        // option 2 - "cat","s"
        // But option 2 tabhi kr skte jab jo word bana vo dixtionary mai ho like isme cat bana toh voh dixtionary mai hona chaiye

        // include it in this word itself
        boolean faith1 = func(s,index+1,new String(currentWord+s.charAt(index)),hashSet);
        // include in another word
        // but for that we have to check ki since yaha word khatam hua toh jo word bana vo hashset mai hai ya nhi
        boolean faith2 = false;
        if(hashSet.contains(currentWord)){
            faith2 = func(s,index,new String(""),hashSet);
        }

        return faith1 || faith2;
    }

    /**
     * above solution is totally correct but giving TLE, so use memoization
     * */


    public static boolean wordBreakDP(String s, List<String> wordDict) {
        // Create a HashSet for quick lookup of words
        HashSet<String> wordSet = new HashSet<>(wordDict);

        // Initialize memoization array, where null means "uncomputed"
        Boolean[] memo = new Boolean[s.length()];

        // Start recursion from index 0
        return canBreak(s, 0, wordSet, memo);
    }

    public static boolean canBreak(String s, int start, HashSet<String> wordSet, Boolean[] memo) {
        // If we reach the end of the string, return true (valid segmentation)
        if (start == s.length()) {
            return true;
        }

        // If the result for this index is already computed, return it
        if (memo[start] != null) {
            return memo[start];
        }

        // Try to break the string starting from index `start`
        for (int end = start + 1; end <= s.length(); end++) {
            // Check if the substring from start to end is a valid word(means whether it is present in dictionary or not)
            if (wordSet.contains(s.substring(start, end))) {
                // If valid, recursively check if the remaining part can be broken
                if (canBreak(s, end, wordSet, memo)) {
                    memo[start] = true;
                    return true;
                }
            }
        }

        // If no valid segmentation is found, store false and return
        memo[start] = false;
        return false;
    }



    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode",List.of("leet","code")));
    }

}
class Pair{
    int index;
    String str;

    public Pair(int index, String str) {
        this.index = index;
        this.str = str;
    }
}
