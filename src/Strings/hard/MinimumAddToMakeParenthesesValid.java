package Strings.hard;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    /**
     * Ye below code kaa nhi karega , if the test case is "()))((" toh openingBrackets==closingBrackets hai but unka order different hai
     * So you have to use stack only*/

    public int minAddToMakeValid(String s) {
        int openingBrackets=0;
        int closingBrackets=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){openingBrackets++;}
            else{closingBrackets++;}
        }

        return Math.abs(openingBrackets-closingBrackets);
    }

    public int minAddToMakeValid2(String s) {
        // there can three cases-:
        // more opening brackets-: toh poori string traversal ke baad bhi stack mai elements hoge toh utne hi closing brackets laga do.
        // more closing brakets-: if closing bracket aaya and stack either empty hai or peek pr closing bracket hai means current closing ka opening missing hai toh count++
        int count=0;
        int n=s.length();
        Stack<Character> stack=new Stack<>();


        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='('){stack.push(s.charAt(i));}
            else{
                if(stack.isEmpty() || stack.peek()!='('){count++;}
                else{stack.pop();}
            }
        }

        if(!stack.isEmpty()){count=count+stack.size();}
        return count;
    }

}
