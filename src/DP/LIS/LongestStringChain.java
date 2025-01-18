package DP.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    /**
     * You are given an array of words where each word consists of lowercase English letters.
     *
     * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without
     * changing the order of the other characters to make it equal to wordB.
     *
     * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
     * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of
     * word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
     *
     * Return the length of the longest possible word chain with words chosen from the given list of words.
     * */

    // It is same as previous questions, we have 2 options take and not take
    // if current String is successor of previous string then only take current string else no

    public int longestStrChain(String[] words) {
        // is quesiton mai likha nhi hai but examples ko dekh ke pata pada ki subsequence nhi subset nikalna hai
        // toh sort krdo array on basis of length of string
        // kiuki apan ko chaiye ki 5 leeter ki string ke baad 6 vaali aaye esa na ho ki 6 letter vali a se start ho and 5 vaali x se toh 6 letter vali string pehle aajaye
        Arrays.sort(words, Comparator.comparingInt(String::length));
        return func(words,"",0);
    }
    public int func(String[] words,String lastString,int index){
        if(index==words.length) return 0;

        // take, we can only take if the lastString is predecessor of current or this is the first time we are choosing
        // a string means last string is ""
        int faith1 = Integer.MIN_VALUE;
        String currentString = words[index];
        if(isPredecessor(lastString,currentString) || lastString.equals("")){
            faith1 = func(words,currentString,index+1)+1;
        }

        // not take
        int faith2 = func(words,lastString,index+1);

        return Math.max(faith1,faith2);
    }

    public boolean isPredecessor(String a,String b){
        int n = a.length();
        int m = b.length();
        if(m-n!=1) return false;

        int i = 0; // iterate on a
        int j = 0; // iterate on b
        int count = 0;
        while (i<n && j<m){
            if(a.charAt(i)==b.charAt(j)){i++; j++; count++;}
            else{
                // this is the character where matching doesn't occur
                j++;
            }
        }

        return count==n;
    }
}

