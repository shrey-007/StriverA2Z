package Recursion.subsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

    public static List<String> func(int n,ArrayList<String> list,String s,int openingBracketsCount,int closingBracketsCount) {

        if(openingBracketsCount+closingBracketsCount==2*n){
            // it is a base case
            list.add(s);
            return list;
        }
        // we have two options either we put opening bracket or closing bracket

        // putting opening bracket
        // we can only put opening bracket if the count of opening bracket is less than or equal to n
        if (openingBracketsCount<n){
            String newString=s+'(';
            func(n,list,newString,openingBracketsCount+1,closingBracketsCount);
        }


        // putting closing bracket
        // we can only put closing bracket if the count of closing bracket is less than or equal to n,
        // also count of opening bracket should not be less than closing bracket else ye banega ()) jo ki galat hoga, cz jab tak bracket open nhi hua tab tak close ni ho skta
        if (closingBracketsCount<n && openingBracketsCount>closingBracketsCount){
            String newString=s+')';
            func(n,list,newString,openingBracketsCount,closingBracketsCount+1);
        }

        return list;
    }


    public static void main(String[] args) {

        ArrayList<String> list=new ArrayList<>();

        func(3,list,"",0,0);
        System.out.println(list);


    }

}
