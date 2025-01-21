package DP.MCM_Partition;

public class PalindromePartitioningII {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return the minimum cuts needed for a palindrome partitioning of s.
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
