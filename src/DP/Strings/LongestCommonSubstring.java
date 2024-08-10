package DP.Strings;

public class LongestCommonSubstring {
    /**
     * This is same as LongestCommonSubsequence but-:
     * 1. Jab character match krege tab theek hai 1+dp[i-1][j-1] krdo
     * 2. But suppose agar character match nhi kre, maanlo ki dp[i-1][j]=3 and dp[i][j-1]=0 toh subsequence vaala max le leta tha
     *    but yaha max nhi lenge, kiuki streak toot gyi toh 0 se start krna padega.
     *    */
    public int tabulation(String s1, String s2){
        int n1=s1.length();
        int n2=s2.length();

        int dp[][]=new int[n1+1][n2+1];
        int ans=0;

        for (int index1 = 1; index1 <= n1; index1++) {
            for (int index2 = 1; index2 <=n2 ; index2++) {
                char curr1=s1.charAt(index1-1);
                char curr2=s2.charAt(index2-1);
                if(curr1==curr2){
                    dp[index1][index2]=1+dp[index1-1][index2-1];
                    ans=Math.max(ans,dp[index1][index2]);
                }
                else{
                    dp[index1][index2]=0;
                }
            }
        }

        return ans;
    }
}
