package SlidingWindowAndTwoPointer.medium;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other
 * uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations
 * */
public class LongestRepeatingCharacterReplacement {

    /**1) So the logic here is, ki agar string abaababac hai means ki usme a ,5 times aa rha hai and b , 3 times aa rha hai,and c->1 time
     * 2) Toh hum a ko b mai convert krege na ki b ko a mai. Toh basically mostFrequent character(a) mai convert krne ki
     *    koshish krege remaining character(b,c) ko
     * 3) */

    public static int characterReplacement(String s, int k) {

        int start=0;
        int end=0;
        int ans=0;
        int maxFrequency=0;

        int hashArray[]=new int[256];  // stores frequency of all 256 characters

        while (end<s.length()){
            char charAtEnd=s.charAt(end);

            // update the frequency in hashmap, jisse pata pade ki current window mai maxFrequency vaala character konsa hai
            hashArray[charAtEnd-'A']++;

            // update the max frequency
            maxFrequency=Math.max(maxFrequency,hashArray[charAtEnd-'A']);

            // no of flips we did till yet is length of current substring-maxFrequency i.e (end-start+1)-maxFrequency
            // kiuki suppose window="abaababac" toh maxFrequency=5 and windowSize=9 since a ki sabse jyaada frequency
            // hai toh hum a mai convert krege remaining characters ko and remaining characters=windowSize-maxFrequency hoge toh utni hi flips hogi
            int noOfFlips=end-start+1-maxFrequency;

            // check if noOfFlips is lesser than k or not
            if(noOfFlips<=k){
                // update the ans
                ans=Math.max(ans,end-start+1);
            }
            else{
                while (end-start+1-maxFrequency>k){
                    char charAtStart=s.charAt(start);

                    // reduce frequency of starting element
                    hashArray[charAtStart-'A']--;

                    // update the maxFrequency, by traversing the whole array
                    maxFrequency=0;
                    for (int i = 0; i < hashArray.length; i++) {
                        maxFrequency=Math.max(maxFrequency,hashArray[i]);
                    }
                    start++;
                }
            }

            end++;
        }


        return ans;
    }

    }


