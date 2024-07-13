package Strings.easy;

public class ReverseWordsInAString {

    /**
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     * */



    /**
     * This solution involves splitting the string into words, reversing the order of the words,
     * and then joining them back together.
     */
    public static String reverseWords2(String s) {
            String[] words = s.split(" ");
            StringBuilder reversed = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                if (!words[i].isEmpty()) {
                    reversed.append(words[i]).append(" ");
                }
            }

            // Remove the trailing space
            return reversed.toString().trim();
    }

    /** String = the sky is blue
     * Method 1 is-: first reverse the whole string so it will become "eulb si yks eht"
     * then reverse the individual words so it will become "bulb is sky the"
     */
    public static String reverseWords(String s) {

        int n=s.length();

        // remove starting spaces
        int count=0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)==' '){count++;}
            else{break;}
        }
        s=s.substring(count);
        n=s.length();

        // remove ending spaces
        count=0;
        for (int i = n-1; i >=0; i--) {
            if(s.charAt(i)==' '){count++;}
            else{break;}
        }
        s=s.substring(0,n-count);

        n=s.length();

        // reverse the whole string
        String newString="";
        for (int i = n-1; i >= 0; i--) {
            newString=newString+s.charAt(i);
        }
        s=newString;

        // reverse the letters in words
        int start=0;
        int i=0;
        while (i<s.length()){
            if(s.charAt(i)==' '){
                s=reverse(s,start,i-1);
                i++;
                while (i<s.length() && s.charAt(i)==' '){i++;}
                start=i;
            }
            i++;
        }
        s=reverse(s,start,s.length()-1);

        // remove middle spaces

        String ans="";
        for (int j = 0; j < s.length(); j++) {
            if(j!=s.length()-1 && s.charAt(j)==' ' && s.charAt(j+1)==' '){

            }
            else{
                ans=ans+s.charAt(j);
            }
        }

        return ans;
    }

    public static String reverse(String s,int startIndex,int endIndex){
        while (startIndex<=endIndex){
            char temp=s.charAt(startIndex);
            s=s.substring(0,startIndex)+s.charAt(endIndex)+s.substring(startIndex+1);
            s=s.substring(0,endIndex)+temp+s.substring(endIndex+1);
            startIndex++;
            endIndex--;
        }
        return s;
    }



    public static void main(String[] args) {
        System.out.println(reverseWords("   shrey is the best   "));
    }
}
