package Recursion.allCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome
 * Return all possible palindrome partitioning of s.
 * */

/**
 * Concept-:
 * 1. parameter index means ki index ke pehle processing/perutations krli hai and currentAns mai hai, ab index to n-1 mai processing kro(It is for every question is string/array, not only this one)
 * 2. Toh if index is i toh 0 to jitne possible partition hona the voh ho gye hai, ab tum i to n-1 ka dekho.
 * 3. You are currently at index "index", Ab tumhare paas bahut options hai partition krne ke tum index to i (index<i<n) ka partition banao, and baaki ka remaining string i to n-1 recursion mai paas krdo as input
 * 4. Toh hoga kya ki next call mai 0 to i ke saare possible partition hoge and apan ko i to n-1 ke krne hoga
 * 5. Remember index to i tabhi partition kr skte hai index to i is palindrome. toh check krlo pehle
 * */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> currentAns = new ArrayList<>();

        func(s,0,ans,currentAns);

        return ans;
    }

    // String is already palindromic portioned from 0 to index, we have to start partition from index
    public void func(String s,int index,List<List<String>> ans, List<String> currentAns){

        // there is only one base case when index is equal to the length of substrign, means at the end we always have to put partition then only our work is completed
        // ex-:if shrhs is string, even if there is many palindromic sub-strings , but last ko hamesha partition krna hai shrhs|, s|hrh|s|
        if(index == s.length()){
            ans.add(new ArrayList<>(currentAns));
            return;
        }

        // we have to try all possible ways ki hum index to n-1 ki place par partition kre ki left string(index to i) palindrome bane
        for (int i = index; i <s.length() ; i++) {
            // if index to i is palindrome then we can partition
            if(isPalindrome(index,i,s)){
                // add the partitioned string to answer, left part ko save krna (index to i), coz vahi palindrome hai
                currentAns.add(s.substring(index,i+1));
                // call the function to partition the remaining string(i to n-1)
                func(s,i+1,ans,currentAns);
                // backtrack ho rha hai toh remove krdo answr ko, you can dry run this if u don;t understand
                currentAns.remove(currentAns.size()-1);
            }
        }
    }



    // It checks whether sub-string from start to end is palindrome or not
    public boolean isPalindrome(int start,int end,String s){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){return false;}
            start++;
            end--;
        }
        return true;
    }


}
