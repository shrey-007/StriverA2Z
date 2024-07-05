package BitManipulation.advanceMaths;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Print Prime numbers which are dividing a giving number */
public class PrimeFactorsOfNumber {

      /**method 1 - check whether they are factor or not then check whether they are prime or not */

      public static boolean isPrime(int num){

          boolean flag=true;

          for (int i = 2; i <= Math.sqrt(num); i++) {
              if(num%i==0){flag=false;break;}
          }

          return flag;
      }
      public static void func(int num){

          List<Integer> list=new ArrayList<>();

          for (int i = 2; i <=num; i++) {
              //find whether it is divisor or not
              if(num%i==0){
                  // find whether it is prime or not
                  if(isPrime(i)){
                      // means it is prime factor so add it in list
                      list.add(i);
                  }
              }
          }

          // print the answer list

          System.out.println(list);
      }

      /** Method 2 - long division method*/
      public static void func2(int num){

          List<Integer> list=new ArrayList<>();

          for (int i = 2; i <=num; i++) {
              //find whether it is divisor or not
              if(num%i==0){
                  // since the number is divisible by this number toh pehle toh add krlo list mai
                  list.add(i);
                  // ab jab tak num i se divide ho rha hai tab tak divide kro
                  while (num%i==0){
                      num=num/i;
                  }
              }
          }

          // print the answer list

          System.out.println(list);
      }

      /** Method 3 - */


    public static void main(String[] args) {
        func(37);
        func2(37);

    }

}
