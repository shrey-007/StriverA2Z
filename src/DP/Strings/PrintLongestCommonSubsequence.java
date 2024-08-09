package DP.Strings;

public class PrintLongestCommonSubsequence {

    public String tabulation(String s1, String s2){
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

        // Now dp table is full, and dp[n][m] contains the length of lcs, this is same code as lcs we have already done
        // But here we have to print the lcs string not the lenght of it.


        // start from the end of dp table
        int index1=n1;
        int index2=n2;
        String ans="";

        while (index1>0 && index2>0){
            // If current matches, means ki tabulation mai dp[index1][index2]=1+dp[index1-1][index2-1]; run hua hoga means ki ye character aaega answer mai
            // Toh answer update kro and dono indexes ko 1 se ghata do
            if(s1.charAt(index1-1)==s2.charAt(index2-1)){
                ans=s1.charAt(index1-1)+ans;
                index1--;
                index2--;
            }
            else{
                // If current character dont matches means dp table mai value faith1,faith2 ke max se aayi hai, jaha se bhi aayi hai vaha jaaoe
                if(dp[index1-1][index2]>dp[index1][index2-1]){
                    index1--;
                }
                else{
                    index2--;
                }
            }
        }

        return ans;
    }


}
