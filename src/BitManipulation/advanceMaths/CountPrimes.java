package BitManipulation.advanceMaths;

import java.util.ArrayList;
import java.util.List;

/** Given a number n , find number of primes strictly lesser than n */
public class CountPrimes {
    /***/
    public static void func(int n){

        List<Integer> list=new ArrayList<>();

        int prime[]=new int[n+1];

        for (int i = 2; i <= n; i++) {
            if(prime[i]==0){
                // means it is prime number
                list.add(i);
                // but all its multiples will not be prime
                for (int j = 2; i*j<=n ; j++) {
                    // mark its multiples as non prime
                    prime[i*j]=1;
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        func(10);
    }
}
