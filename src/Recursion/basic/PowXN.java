package Recursion.basic;

public class PowXN {

    /**
     * This solution is not wrong at all , but the problem is stack overflow, recursion stack space overflow ho jaaegi coz
     * apan ek baar mai ek computation kr rhe hai like
     * 2^10 = 2*2^9 likh rhe hai and
     * 2^(-10) = 1/2*2^(-9) likh rhe hai toh
     * */
    public static double myPow(double x, int n) {
        if(n==0){return 1;}
        if (n<0){
            return (1/x)*myPow(x,n+1);
        }
        else{
            return x*myPow(x,n-1);
        }
    }

    /**
     *  First assume n is positive
     *  Instead of this we can do this if we are given
     *  2^5 = 2*2^4    (if power is odd toh single computation)
     *  2^4 = (2*2)^2  (if power is even toh 2 computation)
     *  Toh is case mai power divide by 2 hogi toh jyaada function call nhi hoga
     *
     *  If n is negative toh use positive bana lo and nn naam ke variable mai store krlo and x^nn nikaalo lo fir jab ans dena ho toh x^nn ki jagah 1/x^nn dedo
     *  But range of int is -2147483648 to 2147483647 toh agar n=-2147483648 hua toh nn=2147483648 hoga jo ki integer overflow aaega toh
     *  nn ko long banana int nhi
     * */

    public static double myPow2(double x, int n) {

        long nn=n;
        if(n<0){nn=nn*-1;}

        // declare ans as 1
        double ans=1.0;

        // find ans
        while (nn>0){
            if(nn%2==1){
                nn=nn-1;
                ans=ans*x;
            }
            else{
                nn=nn/2;
                x=x*x;
            }
        }

        // return answer accordingly

        if(n<0){
            return 1.0/ans;
        }
        else {
            return ans;
        }
    }

    /**
     * If you want to write recursion version of this then assume ki n is positive
     *
     *     public static double func(double x, double n) {
     *         if(n==0){return 1;}
     *         if (n%2==1){
     *             return x*func(x,n-1);
     *         }
     *         else{
     *             return func(x*x,n/2);
     *         }
     *     }
     *
     *  ab jo n ko positive banane and accordingly answer return krne ka kaam main function mai kro
     *
     *
     *     public static double myPow(double x, int n) {
     *
     *         long nn=n;
     *         if(n<0){nn=nn*-1;}
     *
     *         double ans=func(x,nn);
     *
     *         if(n<0){
     *             return 1.0/ans;
     *         }
     *         else {
     *             return ans;
     *         }
     *         }
     *
     * */


    public static void main(String[] args) {
        System.out.println(myPow(3,3));
        System.out.println(myPow(2,-2));

    }
}
