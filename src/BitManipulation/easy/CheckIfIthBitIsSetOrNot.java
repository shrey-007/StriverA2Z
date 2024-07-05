package BitManipulation.easy;

public class CheckIfIthBitIsSetOrNot {

    /** we have to tell ki ith bit 1 hai ki nhi*/

    public static boolean func(int n,int i){
        int x=13;  // x=1101, rightmost ko 0 maano and left side jaao toh 2nd bit is 1
        x=x>>i;    // x=11, now we have to check whether last bit is 1 or not
        return (x & 1)==1;
    }
    public static void main(String[] args) {

        System.out.println(func(13,2));

    }
}
