package Strings.easy;

import java.util.Stack;

/**It is a very easy question bas samajhaya bahut gandi tereeke se hai*/
public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s){

        String ans="";

        int count=0;
        int n=s.length();

        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr=='('){count++;}
            else{
                // means ki closing bracket hai
                count--;}
            if(count==1 && curr==')'){
                // count==1 and ( means ki start hai valid paranthesis ki and start ko answer mai nhi lena hai
                // count==1 and ) means ki second last end hai valid paranthesis ki and usko lena hai toh add kro ans mai
                ans=ans+curr;}
            if(count!=0 && count!=1){
                // count=0 means ki abhi new valid paranthesis start hogi, means ya toh it is start of the string or ye middle of the string mai koi previous valid paranthesis khatam hui hai
                // count na toh 0 hai na 1 means means it is inside of valid paranthesis toh add kro ans mai
                ans=ans+curr;}
        }

        return ans;

    }

}
