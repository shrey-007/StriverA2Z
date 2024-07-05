package BitManipulation.easy;

public class SetIthBit {
    public static void main(String[] args) {
        int x=13;  // x = 1101
        int i=1; // we have to set 1st bit to 1

        int temp=1; // temp = 0001
        temp=temp<<i; // 0010
        x=x|temp;  // 1101
                   // 0010 in dono ka or krdo
                   // 1111 ho jaaega

        System.out.println(x);
    }
}
