package Greedy.easy;

import java.util.Stack;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 * */
public class ValidParenthesisString {

    // Right now forget about *, just think how can we find whether parenthesis are balanced or not
    // earlier we used to check using stack, but we can do this using this way also-:

    public boolean func(String s){
        int n=s.length();
        int count=0;

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr=='('){count++;}
            else{
                count--;
                // count negative hona means ki opening bracket se pehle closing bracket aa gaya
                if(count<0){return false;}
            }
        }

        return count==0;
    }

    // Now come to question
    // Brute force could be ,generate all possible combinations through recursion where * can take any values.
    // Then check each combination
    // Let's first do it using recursion

    public boolean main(String s) {
        return recursive(s,0,0);
    }
    public boolean recursive(String s,int index,int count){
        if(count<0){return false;}
        if(index==s.length()){
            if(count==0){return true;}
            else{return false;}
        }

        char curr = s.charAt(index);
        // opening bracket mai count badega
        if(curr=='('){return recursive(s,index+1,count+1);}

        // closing bracket mai count ghatega
        else if(curr==')'){return recursive(s,index+1,count-1);}

        else{
            // means it is * toh 3 option hai ya toh ise opening maano jisme count badega ya ise closing maano jisme
            // count ghatega ya empty maano jisme count same rahega
            boolean faith1 = recursive(s,index+1,count+1);
            boolean faith2 = recursive(s,index+1,count-1);
            boolean faith3 = recursive(s,index+1,count);
            return faith3 || faith2 || faith1;
        }
    }

    // Here time and space complexity will be high so apply memoization, tabulation etc
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr=='('){min++;max++;}
            else if(curr==')'){min--;max--;}
            else{
                min--;
                max++;
            }
            if(min<0){min=0;}
            if(max<0){return false;}
        }

        return min==0;
    }

}
