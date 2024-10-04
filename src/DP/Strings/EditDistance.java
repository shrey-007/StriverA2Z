package DP.Strings;

/**
 * <p>Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.</p>
 *
 * <p>You have the following three operations permitted on a word:</p>
 *<ul>
 *  <li>Insert a character</li>
 *  <li>Delete a character</li>
 *  <li>Replace a character</li>
 *</ul>

 * */

import java.util.Arrays;

/**
 * If this question was just about deletion and insertion, then we have already done it. But here we can replace also.
 * Which is the problem
 * */
public class EditDistance {
    /**
     * We will start matching each character from string(String Matching Algo)
     * If current character don't matches then we can 3 possible ways-: Insert,delete,replace or hume nhi pata kisse minimum operations hoge,
     * toh we will try all possible ways through recursion
     * */
    public int minDistance(String word1, String word2) {
        return func(word1,word2,word1.length()-1,word2.length()-1);
    }

//    f(i,j) means min operation to convert s1[0...i] to s2[0...j]
    public int func(String s1,String s2,int index1,int index2){
        if(index1==-1 || index2==-1){
            // Agar s1 khatam ho gyi toh s2 remaining charaters add krne padega
            // Agar s2 kahatam ho gyi toh s1 ke remaining characters delete krne padega
            // Agar dono khatam ho gyi toh kuch nhi krna
            return Math.abs(index1-index2);
        }

        char c1=s1.charAt(index1);
        char c2=s2.charAt(index2);

        // if current character matches then we don't need to perform any operation, just go forward
        if(c2==c1){ return func(s1,s2,index1-1,index2-1);}

        // current character don't match so try all possible ways
        int insert= func(s1,s2,index1,index2-1)+1;
        int replace=func(s1,s2,index1-1,index2-1)+1;
        int delete=func(s1,s2,index1-1,index2)+1;

        return Math.min(insert,Math.min(delete,replace));

    }

    // memoization
    public int minDistance2(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();

        int dp[][]=new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            Arrays.fill(dp[i],-1);
        }
        return func(word1,word2,n1-1,n2-1,dp);
    }
    public int func(String s1,String s2,int index1,int index2,int dp[][]){
        if(index1==-1 || index2==-1){
            // Agar s1 khatam ho gyi toh s2 remaining charaters add krne padega
            // Agar s2 kahatam ho gyi toh s1 ke remaining characters delete krne padega
            // Agar dono khatam ho gyi toh kuch nhi krna
            return Math.abs(index1-index2);
        }
        if(dp[index1][index2]!=-1){return dp[index1][index2];}

        char c1=s1.charAt(index1);
        char c2=s2.charAt(index2);

        // if current character matches then we don't need to perform any operation, just go forward
        if(c2==c1){ return func(s1,s2,index1-1,index2-1,dp);}

        // current character don't match so try all possible ways
        int insert= func(s1,s2,index1,index2-1,dp)+1;
        int replace=func(s1,s2,index1-1,index2-1,dp)+1;
        int delete=func(s1,s2,index1-1,index2,dp)+1;

        dp[index1][index2]= Math.min(insert,Math.min(delete,replace));

        return dp[index1][index2];
    }
}
