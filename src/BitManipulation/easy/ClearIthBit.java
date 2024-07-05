package BitManipulation.easy;

public class ClearIthBit {
    public static void main(String[] args) {

        int x=13;  // x = 1101
        int i=2; // we have to set 2nd bit to 0

        int temp=1; // temp = 0001
        temp=temp<<i; // temp = 0100
        temp=~temp;   // temp = 1011
        x=x&temp;     // x= 1101
        //             temp=1011 in dono ka and krdo
        //                  1001 ho jaaega

        System.out.println(x);
    }
}
