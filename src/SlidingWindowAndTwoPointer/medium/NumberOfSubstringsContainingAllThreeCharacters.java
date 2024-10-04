package SlidingWindowAndTwoPointer.medium;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.*/
public class NumberOfSubstringsContainingAllThreeCharacters {

    /**
     * Brute force is ki saare substring nikaalo and dekho ki unme a,b,c hai ki nhi*/
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int count=0;


        for (int start = 0; start <n; start++) {
            int doesContains[]=new int[3];       // doesContains[0] means ki a kitne baar aaya, since only a,b,c hai isliye 3 size ka array banaya
            for (int end = start; end < n; end++) {

                // jab bhi is loop ke under aaya means new substring mila
                char curr=s.charAt(end);
                if(curr=='a'){doesContains[0]++;}
                else if(curr=='b'){doesContains[1]++;}
                else{doesContains[2]++;}

                if (doesContains[0] != 0 && doesContains[1] != 0 && doesContains[2]!=0) {
                    count++;
                }
            }
        }

        return count;
    }

    public int numberOfSubstrings2(String s) {
        int n=s.length();
        int count=0;


        for (int start = 0; start <n; start++) {
            int doesContains[]=new int[3];       // doesContains[0] means ki a kitne baar aaya, since only a,b,c hai isliye 3 size ka array banaya
            for (int end = start; end < n; end++) {

                // jab bhi is loop ke under aaya means new substring mila
                char curr=s.charAt(end);
                if(curr=='a'){doesContains[0]++;}
                else if(curr=='b'){doesContains[1]++;}
                else{doesContains[2]++;}

                if (doesContains[0] != 0 && doesContains[1] != 0 && doesContains[2]!=0) {
                    // if start to end mai a,b,c hai toh all substring with starting index start and ending index
                    // k(end<=k<=n-1) mai a,b,c hoga toh sabko ek baar mai add krdo
                    // and loop break krdo, jisse doosra start index ke liye calculate kre
                    count=count+n-end;
                    break;
                }
            }
        }

        return count;
    }

    // But the time complexity is still n^2
    // so here is O(N) solution
    public int numberOfSubstrings3(String s) {
        int n=s.length();
        int count=0;

        int lastIndexOfCharacter[]=new int[3];
        for (int i = 0; i < 3; i++) {
            lastIndexOfCharacter[i]=-1;
        }


        for (int indexAtWhichSubstringEnds = 0; indexAtWhichSubstringEnds < n; indexAtWhichSubstringEnds++) {
            char curr=s.charAt(indexAtWhichSubstringEnds);
            lastIndexOfCharacter[curr-'a']=indexAtWhichSubstringEnds;

            if(lastIndexOfCharacter[0]!=-1 && lastIndexOfCharacter[1]!=-1 && lastIndexOfCharacter[2]!=-1){
                int lastIndexAtWhichWeHadAllCharacters=Math.min(lastIndexOfCharacter[0],Math.min(lastIndexOfCharacter[1],lastIndexOfCharacter[2]));
                count=count+lastIndexAtWhichWeHadAllCharacters+1;
            }

        }
        return count;
    }

    /***/
}
