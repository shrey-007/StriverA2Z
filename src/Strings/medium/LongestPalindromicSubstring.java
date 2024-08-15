package Strings.medium;

/**
 * Given a string s, return the longest palindromic substring in s
 * */
public class LongestPalindromicSubstring {

    /**
     * Method 1-: The obvious brute force solution is to pick all possible starting and ending positions for a substring,
     * and verify if it is a palindrome. There are a total of n^2 such substrings (excluding the trivial solution where
     * a character itself is a palindrome). Since verifying each substring takes O(n) time, the run time complexity is
     * O(n^3).
     * */

    /** Another method is axis, orbit method
     * https://www.youtube.com/watch?v=vTlVtLvPQo4
     * */
    public static String func(String s){
        int n=s.length();
        String longestPalindromicSubstring="";

        // odd length substrings
        for (int axis = 0; axis <n ; axis++) {
            int orbit=0;

            while (axis-orbit>=0 && axis+orbit<n && s.charAt(axis-orbit)==s.charAt(axis+orbit)){
                if(longestPalindromicSubstring.length()<2*orbit+1) longestPalindromicSubstring=s.substring(axis-orbit,axis+orbit+1);
                orbit++;
            }
        }

        // even length substrings
        for (double axis = 0.5; axis < n; axis++) {
            double orbit=0.5;
            int leftMost=(int) (axis-orbit);
            int rightMost=(int) (axis+orbit);

            while (leftMost>=0 && rightMost<n && s.charAt(leftMost)==s.charAt(rightMost)){
                if(longestPalindromicSubstring.length()<rightMost-leftMost+1) longestPalindromicSubstring=s.substring(leftMost,rightMost+1);
                orbit++;
                leftMost=(int) (axis-orbit);
                rightMost=(int) (axis+orbit);
            }
        }

        return longestPalindromicSubstring;

    }

    public static void main(String[] args) {
        System.out.println(func("babad"));
    }




}
