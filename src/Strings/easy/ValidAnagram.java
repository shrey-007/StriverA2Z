package Strings.easy;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m){return false;}

        HashMap<Character,Integer> hm= new HashMap<>();

        // for s
        // Map Number of characters of s with how many times they r appearing
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }
            else{
                hm.put(curr,1);
            }
        }

        // for t
        for(int i=0;i<m;i++){
            char curr=t.charAt(i);
            if(hm.containsKey(curr)){
                // if character map mai hai toh uska count decrease krdo and if count==0 toh delete krdo use
                hm.put(curr,hm.get(curr)-1);
                if(hm.get(curr)==0){hm.remove(curr);}
            }
            else{
                // Ab agar koi esa character aata hai jo hashmap m nhi h means vo s mai nhi hai, toh return false
                return false;
            }
        }

        // end mai hashmap ka 0 hona chaiye
        return hm.size()==0;

    }

    // same thing you can achieve through array also which will decrease the TC
    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[256];

        // s se count badvaao
        // t se count kam karvaao
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }

        // End mai array ka har element 0 hona chaiye

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }


}
