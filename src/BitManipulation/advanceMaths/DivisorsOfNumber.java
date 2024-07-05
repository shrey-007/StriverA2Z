package BitManipulation.advanceMaths;

import java.util.ArrayList;
import java.util.List;

public class DivisorsOfNumber {

    /** Mehtod 1 = check all numbers from 1 to n */
    public static void func(int num){

        List<Integer> list=new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            if(num%i==0){
                list.add(i);
            }
        }

        System.out.println(list);
    }

    /** Mehtod 2 = If i is a divisor of n then n/i is also divisor of n.
     *  Toh 1 to n tak iterate mat kro 1 to root(n) tak kro , vaha tak jitne divisors mile unhe add kro and unke n/i ko bhi */

    public static void func2(int num){

        List<Integer> list=new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if(num%i==0){
                list.add(i);
                list.add(num/i);
            }
        }

        System.out.println(list);
    }


    public static void main(String[] args) {
        func(44);
        func2(44);
    }
}
