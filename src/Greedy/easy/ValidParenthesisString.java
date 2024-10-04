package Greedy.easy;

import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();

        for (int i = 0; i <n ; i++) {
            char curr=s.charAt(i);
            if(curr=='('){
                stack.push(curr);
            }
            else if(curr==')'){
                if(stack.isEmpty() || stack.peek()==')'){return false;}
                stack.pop();
            }
        }

        // case when openening brackets are still remaining
        if(!stack.isEmpty()){return false;}

        return true;
    }
}
