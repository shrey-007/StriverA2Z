package Strings.hard;

public class RepeatedStringMatch {
        public int repeatedStringMatch(String a, String b) {
            StringBuilder repeatedA = new StringBuilder();
            int count = 0;

            // Keep appending 'a' to itself until it's longer than 'b'
            while (repeatedA.length() < b.length()) {
                repeatedA.append(a);
                count++;
            }

            // Check if 'b' is a substring after enough repetitions
            if (repeatedA.toString().contains(b)) {
                return count;
            }

            // Check one more repetition in case 'b' overlaps between repetitions
            repeatedA.append(a);
            count++;

            if (repeatedA.toString().contains(b)) {
                return count;
            }

            // If 'b' is still not found, return -1
            return -1;
        }

        /**
         * Steps Breakdown:
         * 1. Initial Repetitions:
         * The first step is to ensure that the repeated string a is at least as long as b. This is necessary because if a isn't long enough, b cannot possibly be a substring of it.
         * By appending a repeatedly until the length of the repeated string is equal to or exceeds the length of b, we ensure that we have a base case where b could be a substring.
         *
         * 2. First Check for Substring:
         * After the initial repetitions, we check if b is a substring of the repeated string.
         * If b is found, we return the number of times a has been repeated.
         *
         * 3. One Additional Repetition:
         * If b isn't found as a substring in the first check, we append a one more time and check again.
         * This extra repetition is crucial because b could potentially overlap between the end of one repetition of a and the start of the next.
         * For example, if a = "abc" and b = "cabc", after repeating a once to get "abcabc", b ("cabc") overlaps between the first and second repetition. This overlap wouldn't be detected without the extra repetition.
         *
         * 4. Return -1 if Not Found:
         * If after this additional repetition, b still isn't a substring, it's impossible for b to be a substring of any further repeated version of a, so we return -1.

         */


}
