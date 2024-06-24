package Strings.medium;

public class MaximumNestingDepthOfTheParentheses {

    /**
     * It is very easy question , even easier than the RemoveOutermostParentheses in easy package
     * Usi ka code ko copy paste kara hai
     *  */
    public int maxDepth(String s) {
        int ans=0;
        int count=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr=='('){count++;ans=Math.max(ans,count);}
            else if(curr==')'){count--;}
        }

        return ans;
    }
}
