package Arrays.easy;

public class FindTheNumberThatAppearsOnce_OtherNumbersAppearTwiceInArray {
    //Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    public static int singleNumber(int[] nums) {
        // A number xored with itself will give 0
        // A number xored with 0 gives the number itself
        // suppose array is
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {

    }
}
