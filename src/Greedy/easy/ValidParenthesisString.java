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

    // Right now forget about *, just think how can we find whether parenthesis are balanced or not, when we only have ( and )
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

    // so now coming to question
    // take 2 pointers maxCount and minCount
    // maxCount = consider all * as (
    // minCount = consider all * as )
    // now when a ( and ) comes, you need to treat maxCount and minCount as count only as you do above
    // uper vale question mai count ek fixed value hai , but yaha it is not fixed, yaha range hogi count ki

    public boolean checkValidString(String s) {
        int minCount = 0;
        int maxCount = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            // since it is opening bracket, consider both min and maxCount as count jaise uper vale question mai kra hai
            // toh ( aane pr count badate hai toh dono ko bada do
            if(curr=='('){minCount++;maxCount++;}
            // since it is closing bracket, consider both min and maxCount as count jaise uper vale question mai kra hai
            // toh ) aane pr count kam krte hai toh dono ko kam kr do
            else if(curr==')'){minCount--;maxCount--;}
            // now comes *
            // consider * as (, toh ( aane par count badate hai toh maxCount++
            // consider * as ), toh ) aane par count ghatate hai toh minCount--
            else{
                minCount--;
                maxCount++;
            }
            // if maxCount<0 means ki agar maine saare * ko ( maan liya tab bhi string balanced nhi hai, there are many
            // ), so return false
            if(maxCount<0){return false;}
            // Ab yaha tak aaye means maxCount>=0. Toh abhi maxCount>=0 and minCount<0, means ki itne * hai ki ki ( balanced
            // hai, but ) abhi balanced nhi hai, toh maybe voh baad mai balanced ho jaaye.
            // Just remember ye bas ek range hai count ki count minCount to maxCount jaa skta hai, but count ko negative
            // nhi hona chaiye , count ki range negative jaa hi nhi nahi skti, agar gayi toh voh valid nahi hai, toh 0 krdo
            // lets take example "(**)", 3rd index par jab aaoge toh minCount<0 ho jaaega, but this string is balanced toh minCount<0 is not a problem
            if(minCount<0){minCount=0;}
        }


        // count lies in range [minCount,maxCount]. Now to make a string balanced we check at the end ki count=0 or not
        // yaha bhi vahi karo count, so 0 must lie in range [minCount,maxCount], since minCount is never negative
        // toh minCoun itself starts from either 0 or some positive number. so just check if minCount=0 or not
        // if minCount is not 0, means it is >0 toh count kabhi 0 ho hi nahi paaega toh it is not a valid one
        return minCount==0;
        // in simple words maxCount negative nhi hona chaiye and minCount 0 hona chaiye at the end. Jyaada vala kam nhi
        // hona chaiye and kam vala jyaada nhi hona chaiye
    }

}
