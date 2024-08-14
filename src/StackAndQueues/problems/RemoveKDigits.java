package StackAndQueues.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer
 * after removing k digits from num.
 * */

// Concept-: Keep smaller digits at start, so start from 0th index and remove the bigger digit
// Stack will be used to track previous elements
/**
 * Three cases-:
 * 1. Suppose stack mai [1,4| hai , and ab 3 aaya hai k>0 hai means ki apan deletion kr skte hai
 *    Toh tumhare paas 2 options hai 3 ko bhi stack mai daal do leading to 143 or 4 ko delete krdo and 3 ko stack mai daalo leading to 13 so 2nd option is good
 * 2. Suppose stack mai [1,2| hai , and ab 2 aaya hai k>0 hai means ki apan deletion kr skte hai,
 *    Toh tumhare paas 2 options hai 2 ko bhi stack mai daal do leading to 122 or 2 ko delete krdo and 2 ko stack mai daalo leading to 12 , we will go with 1st option kiuki equal number ko hatane ka sense nhi hai hum chahte hai ki bade number delete ho,
 *    Agar baad mai saare 2 hi aaye toh ek bhi delte nhi hoga and stack 1,2,2,2,2 ban jaaega toh baad mai ek loop hai to remove k elements if k is still bigger than 0 toh usme remove ho jaaege
 * 3. Suppose stack mai [1,4| hai , and ab 5 aaya hai k>0 hai means ki apan deletion kr skte hai
 *    Toh tumhare paas 2 options hai 5 ko bhi stack mai daal do leading to 145 or 4 ko delete krdo and 5 ko stack mai daalo leading to 15 , but we choose 1st option
 *    Kiuki hum chahte hai ki chote numbers rahe pehele, abhi tumhe lag rha hai 145>15 usse sochoge toh lagega 4 ko hata do, but just think ki agar original number n length ka hai and usse k digits remove krni hai toh finl length toh n-k hi hogi, toh
 *    tumhare paas 2 options hai
 *    i) 145 and remaining n-k-3 digits. Example-: 145333
 *    ii) 15 and remainig n-k-2 digits. Example-:  153333
 *    Ab samajh aaya ki 1st option kiu choose kra, hum chahte hai starting mai chote numbers rahe, toh arr[i] mai agar stack ke peek se hote ya equal numbers aa rhe hai toh unhe daalte raho, what could be worst ki saare numbers daal diye , uska edge case baad mai handle kiya hai.
 *    And agar bade numbers aa rhe hai toh unhe delete kro
 *
 * */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        // Edge case: if k equals the length of num, return "0" as all digits will be removed.
        if (k == num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        // Iterate through each digit in the number
        for (char digit : num.toCharArray()) {
            // While the stack is not empty, and the top of the stack is greater than the current digit
            // and we still have digits to remove (k > 0), pop the stack
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            // Push the current digit onto the stack
            stack.push(digit);
        }

        // If k is still greater than 0, remove the remaining digits from the end
        // means koi esa number aaya 1234567, toh uper vaali loop mai is number se koi remove hoga hi nhi, stack will
        // still contain all numbers 1234567 toh means ki sorted oreder hai toh last ki k digits remove krdo
        while (k > 0) {
            stack.pop();
            k--;
        }

        /**
         * Handling Edge cases-: ye baad mai padhna jab uper ka logic samajh aajaye else mat padhna
         * **/

        // Construct the number from the stack and remove leading zeros
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse(); // since stack gives us the number in reverse order

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Return the final smallest number
        return sb.toString();

    }

}

