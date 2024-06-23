package Strings.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==1){return strs[0];}

        //get the first string
        String firstString=strs[0];
        int sfl=firstString.length();

        int min=Integer.MAX_VALUE;


        // iterate over array
        for (int i = 1; i < strs.length; i++) {

            // common prefix length
            int length=0;

            String currString=strs[i];
            int n=currString.length();

            // now check what is the common prefix length
            for (int j = 0; j <n && j<sfl; j++) {
                if(firstString.charAt(j)!=currString.charAt(j)){
                    break;
                }
                length++;
            }

            // if previous string ke liye common length 5 aayi but is string ke liye common length 3 aayi toh ans 3 hoga coz esa prefix chaiye jo sabme common ho agar 5 length vaala liya toh isme vo common nhi hoga
            min=Math.min(min,length);
        }

        if(min==Integer.MAX_VALUE){return "";}
        return firstString.substring(0,min);
    }

    public static String longestCommonPrefix2(String[] strs){

        // sort the string lexicographically
        Arrays.sort(strs);

        // Now match longestCommonPrefix between first and last string

        String firstString=strs[0];
        String lastString=strs[strs.length-1];
        int n=firstString.length();
        int ans=0;

        for (int i = 0; i <n ; i++) {
            if(firstString.charAt(i)!=lastString.charAt(i)){
                break;
            }
            ans++;
        }

        return firstString.substring(0,ans);
    }

    // chatgpt is giving binary search on answers and divide and conquer as the most optimal one

    public static void main(String[] args) {
        String arr[]={"flower","flow","flight"};
        String arr2[]={"","b"};
        System.out.println(longestCommonPrefix(arr2));
    }
}
