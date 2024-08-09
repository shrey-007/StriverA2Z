package DP.Strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    /**
     * The naive way is generate all possible subsequence of text1 and text2 into two different list and then iterate
     * over that list and return the largest.
     * */
    /**
     * 1. We can not represent two strings with a single index because they have different length, so we will use 2 indexes
     * 2. f(2,2) finds out the longestCommonSubsequence of text1 indexed from 0...2 and text2 indexed from 0...2
     * 3. f(2,5) means ki s1[0..2] and s2[0..5] ka lcs nikaalo
     * */
    public int longestCommonSubsequence(String text1, String text2) {
        return func(text1, text2,text1.length()-1,text2.length()-1);
    }

    public int func(String s1, String s2,int index1,int index2){
//        if(index1==0 && index2==0){
//            if(s1.charAt(index1)==s2.charAt(index2)){return 1;}
//            return 0;
//        }
//        if(index1==0){
//            char c1=s1.charAt(index1);
//
//            if(s2.indexOf(c1)!=-1){return 1;}
//            return 0;
//        }
//        if(index2==0){
//            char c2=s2.charAt(index2);
//
//            if(s1.indexOf(c2)!=-1){return 1;}
//            return 0;
//        }

        if(index1<0 || index2<0){return 0;}

        char c1=s1.charAt(index1);
        char c2=s2.charAt(index2);

        // If current character matches
        if(c1==c2){
            // means i have found a subsequence of length 1, ab aage jaao.
            return 1+func(s1,s2,index1-1,index2-1);
        }

        // Not matches
        // means s1(index1) match ni kra s2(index2) se , but s1(index1) s2(index2-1,index2-2,index2-3...0) se match kr
        // skta hai, like agar esa kuch hai "fwffr" "dert" toh abhi toh r and t match nhi kr rhe but r s2 mai aaega index2-1 mai

        // s1(index1) match ni kra s2(index2) se , but s2(index2) s1(index1-1,index1-2,index1-3...0) se match kr
        // skta hai, like agar esa kuch hai "teddr" "dert" toh abhi toh r and t match nhi kr rhe but s1 mai t aaega 0th index par

        int faith1=func(s1,s2,index1-1,index2);
        int faith2=func(s1,s2,index1,index2-1);

        return Math.max(faith1,faith2);
    }

    // memoization
    public int longestCommonSubsequence2(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return memoization(text1, text2,text1.length()-1,text2.length()-1,dp);
    }

    public int memoization(String s1, String s2,int index1,int index2,int dp[][]){

        if(index1<0 || index2<0){return 0;}

        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }

        char c1=s1.charAt(index1);
        char c2=s2.charAt(index2);

        // If current character matches
        if(c1==c2){
            // means i have found a subsequence of length 1, ab aage jaao.
            return 1+memoization(s1,s2,index1-1,index2-1,dp);
        }

        // Not matches
        // means s1(index1) match ni kra s2(index2) se , but s1(index1) s2(index2-1,index2-2,index2-3...0) se match kr
        // skta hai, like agar esa kuch hai "fwffr" "dert" toh abhi toh r and t match nhi kr rhe but r s2 mai aaega index2-1 mai

        // s1(index1) match ni kra s2(index2) se , but s2(index2) s1(index1-1,index1-2,index1-3...0) se match kr
        // skta hai, like agar esa kuch hai "teddr" "dert" toh abhi toh r and t match nhi kr rhe but s1 mai t aaega 0th index par

        int faith1=memoization(s1,s2,index1-1,index2,dp);
        int faith2=memoization(s1,s2,index1,index2-1,dp);

        dp[index1][index2]=Math.max(faith1,faith2);

        return dp[index1][index2];
    }

    // Tabulation
    public int tabulation(String s1, String s2){
        // Since recursion ka base case index==-1 ke liye hai, and dp[-1] error dega toh 2 option hai ya toh index==0 ka
        // base case soch kr likho ya fir dp table mai ek row jyaada banao and index shifting kro index -1 dp table mai 0 hoga
        // index i dp table mai i+1 hoga and so on..

        int n1=s1.length();
        int n2=s2.length();

        int dp[][]=new int[n1+1][n2+1];

        for (int index1 = 1; index1 <= n1; index1++) {
            for (int index2 = 1; index2 <=n2 ; index2++) {
                char curr1=s1.charAt(index1-1);
                char curr2=s2.charAt(index2-1);
                if(curr1==curr2){dp[index1][index2]=1+dp[index1-1][index2-1];}
                else{
                    int faith1=dp[index1][index2-1];
                    int faith2=dp[index1-1][index2];
                    dp[index1][index2]=Math.max(faith1,faith2);
                }
            }
        }

        return dp[n1][n2];
    }
}
