package DP.Strings;

public class LongestPalindromicSubsequence {

    /***
     * 1. Brute force way is ,generate all possible subsequence and base case jab aaye {index==s.length()}  tab check kro ki
     *    jo subsequence bana hai vo palindrome hai ki nhi. It can be done using parameterised recursion usme curentSubsequence ko paramaeter mai paas krna
     *
     * 2. Another way is functional recursion, saare subsequences generate krke arraylist return kro and us list mai traverse kro ki vo palindrom hai ki nhi
     * */



    public int longestPalindromeSubseq(String s) {
        // Dekho , agar koi subsequence palindrome hai toh simply vo aage se and peeche se same read krega, means s ka
        // reverse mai bhi vo subsequence vaisa hi rahega, toh hume simply s and s ke reverse ka lcs nikaalna hai

        String reversedString="";
        int n=s.length();

        for (int i = 0; i < n; i++) {
            reversedString=s.charAt(i)+reversedString;
        }

        return tabulation(s,reversedString);

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
