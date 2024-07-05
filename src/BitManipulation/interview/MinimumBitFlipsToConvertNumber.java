package BitManipulation.interview;

public class MinimumBitFlipsToConvertNumber {

    /**
     *  Which operator is used to find different bits? - answer is xor
     *  start = 10(1010), goal = 7(0111)
     *  In dono ka xor kro 1101 aaega means un jagah pr 1 hoga jaha different bits thi toh bas ab CountNumberOfSetBits ka question ho gya
     * */

    public int countNumberOfSetBits(int num){
        // num =  1101
        int count=0;
        while (num!=0){
            if((num&1)==1){count++;}
            num=num>>1;
        }
        return count;
    }

    public int minBitFlips(int start, int goal) {
        return countNumberOfSetBits(start^goal);
    }
    public static void main(String[] args) {

    }
}
