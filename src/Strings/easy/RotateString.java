package Strings.easy;

public class RotateString {

    // 1) simply just sort the string and compare whether they r equal r not

    // 2) s mai s ko concatenate krdo toh all possbile rotations usme aajaege toh ab check kro ki goal uska substring hai ki nhi
    public static boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();
        if(n!=m){return false;}

        // concatenate s to itself
        s=s+s;

        // this contains() function uses KMP algorithm so its complexity is O((n+m)*m)
        return s.contains(goal);
    }

    /**
     *
     * THE IMPORTANT THING IS JAB BHI ROTATION KA QUESTION AAYE TOH USME LENGTH ADD HONA, MODULO HONA ,90% USSE ANS AAEGA
     *
     * EveryOne is giving this solution only
     * But I have one more solution of mine
     *  s=a b c d e   goal= c d e a b
     *    0 1 2 3 4         0 1 2 3 4
     *  create an array jo ki ye store krega ki s ka konsa character konse index pr hoga
     *  arr= [0 1 2 3 4]
     *        a b c d e
     * create another array jo ki ye store krega ki goal ka konsa character konse index pr hoga
     * arr2= [3 4 0 1 2]
     *        a b c d e
     * Now notice something-:
     * arr[e]-arr2[e]=2
     * arr[d]-arr2[d]=2
     * arr[c]-arr2[c]=2
     * arr[b]-arr2[b]=-3 but since ye negative aa rha h toh s.length dd krdo = -3+5 = 2
     * arr[a]-arr2[a]=-3+5=2
     * So if you can create some algorithm then go for it but isme problem ye hai ki if c 2 baar aata hai 0 and 5 pr toh doosre occurence ko kaha store kroge, u can use array list btw
     */
}
