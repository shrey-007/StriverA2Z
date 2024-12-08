package Recursion.allCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string num that contains only digits and an integer target, return all possibilities to insert the binary
 * operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
 *
 * Note that operands in the returned expressions should not contain leading zeros.
 * */
public class ExpressionAddOperators {
    /**
     * concept is ki, ek function call mai hi decide kro ki kitne digits leni hai , like 1234334 number hai and
       index=2, hai toh decide kro ki 3 lena hai ki 34 lena hai ki 343 lena hai and so on, but the catch is ek hi call
       f(index) mai hi ye decide kro and uski integer value nikalo and currentSum mai bhi usi call mai add kro

     </br>

     * At f(index) we already have expression till (index-1) let expression/currentAns is "1+2", and index is 3 and currentSum = 3
     * and lastvalue is 2.
     * Now ab apan ne is call mai decide kra ki 343 ko ek saath lena hai toh sab cheeje update isi call mai kro, let operator humne + decide kra
     * expression = "1+2" + "+" + "343", and currentSum = 3+343 and lastvalue = 343
     *
     * only catch is agar tum current operator - select krte ho and 343 ko ek saath lete ho toh lastvalue=-343 hogi, 343 nhi
     * another catch is agar tum current operator * select krte ho and 343 ko ek saath lete ho toh lastvalue= lastvalue*343 hogi, 343 nhi
     * another catch is agar tumne multiply choose kra, toh currentSum is not currentSum*currentValue, instead it is
     * currentSum = currentSum-lastValue+lastValue*currentValue
     *
     * The concept is ki tumhe lastvalue, last operation dono store krne padege kiuki jab multiplication aaega toh usme
     * previous calculation hata kr new daalni padegi according to BODMAS rule. But hum sirf lastvalue hi store krege,
     * but ese krege ki usme last operation ki bhi info hogi, like agar last operation is - toh lastvalue ki jagah -lastvalue store kra.
     *

     */

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return ans;
        }
        func(num, 0, target, "", ans, 0, 0);
        return ans;
    }

    public void func(String s, int index, int target, String currentAns, List<String> ans, long currentSum, long lastValue) {
        // Base case: if we've processed the entire string
        if (index == s.length()) {
            if (currentSum == target) {
                ans.add(currentAns);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // Extract current number as substring
            String numStr = s.substring(index, i + 1);
            long currentValue = Long.parseLong(numStr);

            // Skip numbers with leading zeros
            if (s.charAt(index) == '0' && i > index) {
                break;
            }

            if (index == 0) {
                // First number, no operator needed
                func(s, i + 1, target, numStr, ans, currentValue, currentValue);
            } else {
                // Add '+'
                func(s, i + 1, target, currentAns + "+" + numStr, ans, currentSum + currentValue, currentValue);

                // Add '-'
                func(s, i + 1, target, currentAns + "-" + numStr, ans, currentSum - currentValue, -currentValue);

                // Add '*'
                func(s, i + 1, target, currentAns + "*" + numStr, ans,
                        currentSum - lastValue + lastValue * currentValue,
                        lastValue * currentValue);
            }
        }
    }


}
