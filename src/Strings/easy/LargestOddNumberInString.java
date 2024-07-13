package Strings.easy;

public class LargestOddNumberInString {
    /**
     * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string)
     * that is a non-empty substring of num, or an empty string "" if no odd integer exists.
     * A substring is a contiguous sequence of characters within a string.
     *
     *
     *
     * Example 1:
     *
     * Input: num = "52"
     * Output: "5"
     * Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.*/
    public String largestOddNumber(String num) {
        int n=num.length();
        for(int i=n-1;i>=0;i--){
            char curr=num.charAt(i);
            int currNumber=curr-'0';
            if(currNumber%2==1){return num.substring(0,i+1);}
        }
        return "";
    }
}
