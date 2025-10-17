package DP.MCM_Partition;

public class PalindromePartitioningII {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * */

    /**
     * Intuition-:
     * - bababcbadcede
     * - now check whether we can partition at 0th index? we will be left with b , ababcbadcede. Left part is "b", which is a palindrome so yes we can partition, now you have to further partition the right spart, so pass it to function
     * - another option is can be partiton at 1st index? "ba" and "babcbadcede", since left part is not a palindrome so no
     * - can we partition at 2nd index? "bab" and "abcbadcede", yes we can, and pass the right part to further partition
     * - so you have to take min of all these
     *
     * - in all these above cases, we assumed string starts with 0th index. suppose you parttion at 2nd index. so right part
     * becomes "abcbadcede", now we have to perform partition on this string but it does not start with 0 index, its first character
     * is 3rd index. so maintain a pointer index.
     *
     * */
    public int minCut(String s) {
        return func(s,0,s.length());
    }

    public int func(String s,int index,int n){
        if(index==n) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = index; i <n ; i++) {
            String substring = s.substring(index,i+1);
            if(isPalindrome(substring)){
                // we can apply cut here
                int faith = func(s,i+1,n)+1;
                ans = Math.min(ans,faith);
            }
        }

        return ans;
    }
    public boolean isPalindrome(String s){
        int i=0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioningII p = new PalindromePartitioningII();
        System.out.println(p.minCut(s));
    }
}
