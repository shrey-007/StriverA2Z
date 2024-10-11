package Greedy.medium;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        return func(nums,0);
    }

    public static boolean func(int[] nums,int index){
        if(index==nums.length-1){return true;}
        if(index>=nums.length){return false;}

        int maxJumps = nums[index];
        if(maxJumps==0){
            // yaha se kahi nhi jaa skte
            return false;
        }

        boolean flag = false;

        for(int i=1;i<=maxJumps;i++){
            flag = flag || func(nums,index+i);
        }

        return flag;
    }

    public static void main(String[] args) {
        int nums[]={2,0};
        System.out.println(canJump(nums));
    }
}
