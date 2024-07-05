package BitManipulation.easy;

public class RemoveLastSetBit {
    /**
     * 1100 isme last set bit(rightmost bit which is 1) 2nd hai toh use 0 krna hai
     * We just need to find last set bit after thatClearIthBit vaala question ban jaaega
     * */
    public static void main(String[] args) {
        int num=40;  // num= 101000
        int temp=1;  // num-1=39=100111
        // point is ki num aur num-1 mai similarity hoti hai
        // num-1 = num ki last set bit(rightmost bit which is 1) 0 ho jaati hai and uske right ke saare 1 ho jaate hai
        // like 40 mai 3rd bit last set bit thi toh 39 mai 3rd bit 0 hai and uske right ki saari bit 1 hai
        // toh agar num and num-1 k and krege toh
        // 101000
        // 100111
        //----------
        // 100000 banega jo ki ans hai
        int ans=num&(num-1);



    }
}
