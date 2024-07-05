package BitManipulation.easy;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a=7;
        int b=13;

        a=a^b; // a=a^b
        b=a^b; // a=a^b and b=(a^b)^b=a  (b^b=0)
        a=a^b; // b=a and a=a^b so a=(a^b)^a=a
        System.out.println(a);
        System.out.println(b);
    }
}
