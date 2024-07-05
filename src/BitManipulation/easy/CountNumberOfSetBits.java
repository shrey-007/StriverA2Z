package BitManipulation.easy;

public class CountNumberOfSetBits {
    /**
     * Convert the number into binary and jab bhi conversion mai remainder 1 aaye toh count bada do
     * */
    public static int func(int num){
        // num =  1101
        int count=0;
        while (num!=0 && num!=1){
            if(num%2==1){count++;}
            num=num/2;
        }
        if(num==1){count++;}
        return count;
    }
    /**
     * You can simply find whether rightmost bit is one or not using num&1==1
     * Now after that you have to remove the rightmost bit and make the second rigth bit the rightmost one
     * 1101 toh count=1
     * 0110 toh count=0
     * 0011 toh count=2
     * 0001 toh count=3
     * 0000 while loop ends
     * */
    public static int func2(int num){
        // num =  1101
        int count=0;
        while (num!=0){
            if((num&1)==1){count++;}
            num=num>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(func(13));
        System.out.println(func2(13));

    }
}
