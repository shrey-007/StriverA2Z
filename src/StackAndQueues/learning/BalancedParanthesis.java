package StackAndQueues.learning;

public class BalancedParanthesis {
    public static void func(String s){
        // iterate over string and if any opening bracket comes then push it into the stack
        // if closing bracket comes then see if the peek of the stack is opposite of it or not. if yes then pop it and go ahead else return true
        // there may be a case where number of opening bracket > number of closing bracket toh us case mai string poori iterate krne ke baad bhi stack mai elements bach jaaege toh return false
        // there may be a case where number of opening bracket < number of closing bracket toh us case mai pop and peek krne mai problem aaegi toh vo krne se pehle size dekh lena stack ka ki 0 se bada h ki nhi if not then return false
    }
}
