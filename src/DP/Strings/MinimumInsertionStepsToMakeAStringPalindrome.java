package DP.Strings;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    /**
     * Suppose String is "abcaa" , toh isme kya jode ki ye palindrome ban jaaye?
     * Ans is iska reverse(aacba) isme jod toh toh ye banega "abcaaaacba" jo ki palindrome hoga
     * But we need minimum insertions
     *
     * 1. Since poori string ko palindrome banana hai, toh Find the longest Palindromic SUBSEQUENCE
     * 2. Like for example-: "mbadm" mai longest Palindromic SUBSEQUENCE "mam" hoga jo ki already palindrome hai toh unhe kuch mat kro
     * 3. Bache hue characters b,d hai jinke karan palindrome nhi bani string, toh simply b,d ko hi insert krdo to make it palindrome, Ab b,d ko kaha insert krna hai voh nhi batana apan ko.
     * 4. Apan ko bas ye batana hai ki kya insert krna hai , toh insert vahi characters krne hai jo longest Palindromic SUBSEQUENCE mai nhi hai
     * 5. So I have used longestPalindromeSubseq() function which we already discussed, and that itself uses lcs which also we have discussed.
     *
     *  */
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }

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
