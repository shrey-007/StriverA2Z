package DP.Strings;

/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are
 * multiple valid strings, return any of them.
 *
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 * */

/**
 * If we are just asked for the length, then ans would be lcs + remaining charcaters in str1 + remaining charcaters in str2
 * which is equal to len(str1)+len(str2)-lcs
 *
 * But they are asking for the string in question, so we will use the concept of PrintLCS which creates a dp table of lcs and then
 * traverse the dp table to find string
 * */
public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        String ans= tabulation(str1,str2);
        String reversedString="";
        int n=ans.length();
        for (int i = 0; i < n; i++) {
            reversedString=reversedString+ans.charAt(i);
        }
        return reversedString;
    }

    public String tabulation(String s1, String s2){

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

        // Now dp table is full, and dp[n][m] contains the length of lcs, this is same code as lcs we have already done
        // But here we have to print the lcs string not the lenght of it.


        // start from the end of dp table
        int index1=n1;
        int index2=n2;
        String superSequence="";


        while (index1>0 && index2>0){
            // If current matches, means ki tabulation mai dp[index1][index2]=1+dp[index1-1][index2-1]; run hua hoga means ki ye character aaega answer mai
            // Toh answer update kro and dono indexes ko 1 se ghata do
            if(s1.charAt(index1-1)==s2.charAt(index2-1)){
                superSequence=superSequence+s1.charAt(index1-1);
                index1--;
                index2--;
            }
            else{
                // If current character dont matches means dp table mai value faith1,faith2 ke max se aayi hai, jaha se bhi aayi hai vaha jaaoe
                if(dp[index1-1][index2]>dp[index1][index2-1]){
                    superSequence=superSequence+s1.charAt(index1-1);
                    index1--;
                }
                else{
                    superSequence=superSequence+s2.charAt(index2-1);
                    index2--;
                }
            }
        }

        while (index1>0){
            superSequence=superSequence+s1.charAt(index1-1);
            index1--;
        }
        while (index2>0){
            superSequence=superSequence+s2.charAt(index2-1);
            index2--;
        }


        return superSequence;
    }

}
