package DP.Strings;

import java.util.Locale;

/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 * In one step, you can delete exactly one character in either string.
 * */
public class DeleteOperationForTwoStrings {
    /**
     *  Don't touch lcs of them
     *  Remaining characters of word1 ko delete krdo word1 se
     *  And remaining characters of word2 ko delete krdo word2 se
     *
     *  If the question was that you can insert/delete the string 1 only and you have to convert it to string 2
     *  Toh pehele lcs ki length nikaalo
     *  word1 ke remaining characters ko word1 se delete kro
     *  word2 ke remaining ko word1 mai insert kro
     *
     *  **/
    public int minDistance(String word1, String word2) {
        int lcsLength=tabulation(word1,word2);
        return word1.length()-lcsLength+word2.length()-lcsLength;

    }
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
