package BitManipulation.interview;

/**
 * Given a number n , find xor of all numbers from  to n */

public class XOROfAllNumbersInRange {
    /**method1 = for loop mai 1 to n tak ka xor krlo*/

    /**method2 = it is a pattern which you can recognize by writing some few terms*/
    public static int func(int n){
        if(n%4==1){return 1;}
        else if(n%4==2){return n+1;}
        else if(n%4==3){return 0;}
        else return n;
    }

    /** Now follow-up question is that you have to find xor form l to r */
    public static int func2(int l,int r){
        int xor1=func(l-1); // xor from 1 t0 l-1  (1^2^3^4^5^6^...^(l-1))
        int xor2=func(r);      // xor from 1 t0 r    (1^2^3^4^5^6^...^(l-1))

        int ans=xor1^xor2;     // (1^2^3^4^5^6^...^(l-1))^(1^2^3^4^5^6^...^(l-1))= (l^......^r)
        return ans;
    }

}
