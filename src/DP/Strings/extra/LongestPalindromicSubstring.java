package DP.Strings.extra;

import java.util.Arrays;


public class LongestPalindromicSubstring {

    /**
     * Most brute force way is to generate all possible substring and check whether they are palindrome or not
     * **/
    public static String longestPalindrome(String s) {

        int n=s.length();
        int ans=0;
        String ansString="";

        // starting index of substring
        for (int start = 0; start <n ; start++) {
            // end index of substring
            for (int end = start; end < n; end++) {
                // check whether the substring from start to end index is palindrome or not, if yes toh kya uski lenght
                // max se badi hai, if yes toh max, ansString ko update krdo
                if(isPalindrome(s,start,end) && ans<end-start+1){
                    ans=Math.max(ans,end-start+1);
                    ansString=s.substring(start,end+1);
                }
            }
        }

        return ansString;

    }

    public static boolean isPalindrome(String s,int start,int end){

        while (start<=end){
            if(s.charAt(start)!=s.charAt(end)){return false;}
            start++;
            end--;
        }

        return true;
    }

    /**
     * 1. This will take O(n3) , because of start,end loop and har substring mai isPalindrome chalane ka (n)
     * 2. Hume saari possible substring toh check krna hi hai, toh uska kuch nhi kr skte toh simply isPalindrome() ko improve kro
     * 3. Usko recursive way mai likho, toh pata padega ki kaafi repeated calls hogi toh memoization use kro then, tabulation mai convert kro isPalindrome() ko
     * */
    // recursive
    public static String longestPalindrome2(String s) {

        int n=s.length();
        int ans=0;
        String ansString="";

        // starting index of substring
        for (int start = 0; start <n ; start++) {
            // end index of substring
            for (int end = start; end < n; end++) {
                // check whether the substring from start to end index is palindrome or not, if yes toh kya uski lenght
                // max se badi hai, if yes toh max, ansString ko update krdo
                if(isPalindromeRecursive(s,start,end) && ans<end-start+1){
                    ans=Math.max(ans,end-start+1);
                    ansString=s.substring(start,end+1);
                }
            }
        }

        return ansString;

    }

    public static boolean isPalindromeRecursive(String s,int start,int end){
        if(end<start){
            return true;
        }

        if(s.charAt(start)!=s.charAt(end)){return false;}

        return isPalindrome(s,start+1,end-1);
    }

    // memoization
    public static String longestPalindrome3(String s) {

        int n=s.length();
        int ans=0;
        String ansString="";

        int dp[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],-1);
        }

        // starting index of substring
        for (int start = 0; start <n ; start++) {
            // end index of substring
            for (int end = start; end < n; end++) {
                // check whether the substring from start to end index is palindrome or not, if yes toh kya uski lenght
                // max se badi hai, if yes toh max, ansString ko update krdo
                if(isPalindromeMemoization(s,start,end,dp) && ans<end-start+1){
                    ans=Math.max(ans,end-start+1);
                    ansString=s.substring(start,end+1);
                }
            }
        }

        return ansString;

    }

    public static boolean isPalindromeMemoization(String s,int start,int end,int dp[][]){
        if(end<start){
            return true;
        }

        if(dp[start][end]!=-1){
            return dp[start][end]==1;
        }

        if(s.charAt(start)!=s.charAt(end)){
            dp[start][end]=0;
            return false;
        }

        boolean ans=isPalindromeMemoization(s,start+1,end-1,dp);

        if(ans){
            dp[start][end]=1;
        }
        else{
            dp[start][end]=0;
        }

        return ans;
    }

    // Tabulation
    public static String longestPalindrome4(String s) {

        int n=s.length();
        int ans=0;
        String ansString="";


        // starting index of substring
        for (int start = 0; start <n ; start++) {
            // end index of substring
            for (int end = start; end < n; end++) {
                // check whether the substring from start to end index is palindrome or not, if yes toh kya uski lenght
                // max se badi hai, if yes toh max, ansString ko update krdo
                if(isPalindromeTabulation(s) && ans<end-start+1){
                    ans=Math.max(ans,end-start+1);
                    ansString=s.substring(start,end+1);
                }
            }
        }

        return ansString;

    }

    public static boolean isPalindromeTabulation(String s){
        int n=s.length();

        // changing parameters were start and end
        int dp[][]=new int[n][n];


        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }

        for (int start = n-1; start <n ; start++) {
            for (int end = 0; end < n; end++) {
                if(s.charAt(start)!=s.charAt(end)){dp[start][end]=0;}
                else{
                    
                }
            }

        }

        return true;
    }





    public static void main(String[] args) {
        System.out.println(longestPalindrome3("sjwjdcaabaawudu"));
    }
}


