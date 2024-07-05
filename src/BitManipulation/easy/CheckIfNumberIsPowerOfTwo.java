package BitManipulation.easy;

public class CheckIfNumberIsPowerOfTwo {
    /**A given number is a power of two if it has only one set bit*/
    // let a number num is power of 2, and it is = 100000
    // then num-1 will be                       = 011111
    // when we do and of this                   = 000000
    // it will give zero
    public static boolean func(int num) {
        return (num&(num-1))==0;
    }
}
