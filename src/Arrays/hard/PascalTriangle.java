package Arrays.hard;

public class PascalTriangle {
    // There are 3 variations in this problem

    // 1)  If only (r,c) th element is asked to find
    /**
     The value of (r,c) cell of pascal triangle is (r-1)C(c-1) where C is PnC vaala C.
     Toh agar simply ek element print krne ko bola toh yahi formula laga do
     TC = O(r-1)+O(c-1)+O(r-c) (TC to find factorial of n is O(n))
     */

    // 2) If the whole rth row we have to print
    /**
     Toh us poori row mai uper vaala formula laga do but it will lead to increase in TC coz dekho agar rth row print
     hai toh vo ye hogi
     rC0 rC1 rC2 rC3 rC4 rC5 rC6 ...........rCr
     So TC = r*(TC to find (r,c)) = r*r

     Since we already know the value of rCi so in order to find rC(i+1) we don't have to calculate it from start
     rC(i+1)=(rCi)*(r-1)/(i+1)
     So this time TC to find value of a cell is reduced to 1
     So TC = r*(TC to find (r,c)) = r*1=r
     */

    // 3) We have to print full pascal triangle
    /**
     Create a temporary list containing the rth row(find rth row through 2nd variation)
     Add that row in the ans and repeat this process..
     TC = r*(TC for generating rth row) = r*r
     */

}
