package Recursion.subsequences;

/**
 * Given an integer, K. Generate all binary strings of size k without consecutive 1’s.
 */
public class GenerateAllBinaryStringsWithoutConsecutiveOnes {
    public static void func(int k,String s,int index){

        // if length of string is k means we have got an answer so print it, so this is base case
        if(s.length()==k){
            System.out.println(s);
            return;
        }

        // index -0 pr dono choices hogi 0 bhi laga skte hai and 1 bhi
        if(index==0){
            String newString=s+'0';
            String newString2=s+'1';
            func(k,newString,index+1);
            func(k,newString2,index+1);
        }
        // index 0 ke alawa koi aur ho toh check krna padega ki last character kya tha agar 1 tha toh 0 hi laga skte hai
        else if(s.charAt(index-1)=='1'){
            String newString=s+'0';
            func(k,newString,index+1);
        }
        else{
            // index 0 ke alawa koi aur ho toh check krna padega ki last character kya tha agar 0 tha toh 1 and 0  dono hi laga skte hai
            String newString=s+'0';
            String newString2=s+'1';
            func(k,newString,index+1);
            func(k,newString2,index+1);
        }

    }

    public static void main(String[] args) {
        func(4,"",0);
    }
}
