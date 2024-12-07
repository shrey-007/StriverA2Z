package Recursion.subsequences;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

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
