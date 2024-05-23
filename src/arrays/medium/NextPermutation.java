package arrays.medium;

import java.io.File;
import java.util.Arrays;

public class NextPermutation {
    public void func(int nums[]){

        boolean flag=false;

        for(int i=nums.length-2;i>=0;i--){
            //check kro ki koi bada element hai kya right side
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    //agar koi bada mila toh flag true krdo
                    flag=true;
                }
            }
            //agar koi bada element hai toh swap kro else left jaao.toh else ki jarurat nhi h apne aap i-- ho jaaega
            if(flag==true){
                //means ki bade element hai right side mai toh,dekho ki bado mai sabse chota kon hai.
                int min_of_max=Integer.MAX_VALUE;
                int i_min_of_max=-1;  //this is index of min_of_max
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]>nums[i] && nums[j]<min_of_max){min_of_max=nums[j];i_min_of_max=j;}
                }
                //toh i_min_of_max par hai vo element
                //swap i and i_min_of_max
                int temp=nums[i];
                nums[i]=nums[i_min_of_max];
                nums[i_min_of_max]=temp;
                //ab i+1 se end tak sort krdo
                Arrays.sort(nums,i+1,nums.length);
                break;
            }
        }

        if(flag==false){
            //means ki array decsending order mai h
            Arrays.sort(nums);
        }
    }

    public static void func2(int nums[]){

        //for explaination of this, see the image in this folder itself
        File file=new File("images/NextPermutation.jpg");

         int dip=-1;


         //find the dip
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]>nums[i-1]){
                //we have found the dip index
                dip=i-1;
                break;
            }
        }

        //find the number just greater than nums[dip] on right
        int justGreaterElement=-1;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (nums[i] > nums[dip]) {
                //since right side of dip is like this=\ toh right se start kro jo pehla number num[dip] se bada hai vahi justGreater hai
                justGreaterElement=i;
                break;
            }
        }

        //swap dip and justGraeterElement
        int temp=nums[dip];
        nums[dip]=nums[justGreaterElement];
        nums[justGreaterElement]=temp;

        //reverse the right side of dip
        int start=dip+1;
        int end= nums.length-1;
        while(start<end){
            //swap start and end
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
        }
    }


    public static void main(String[] args) {

    }
}
