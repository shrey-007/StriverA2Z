package arrays.medium;

//sort an array containing only 0,1,2
//it is a 3 pointer problem
//dutch national flag algorithm

/*
 It has to be divided in 4 sections= jaha 0 ho, jaha 1 ho , jaha 2 ho, jaha vo numbers ho jo teeno mai se kis section
 mai jaana hai ye decide krna hai means vo abhi apne section mai gye nhi hai but jaaege toh initially yahi section
 poora array hoga and dheeme dheeme ye kam hota jaaege and at the end ye khatam ho jaaege coz saare elements apne
 section mai chale jaaege, is section mai iteration hoga.
 So two divide the array into 4 sections we need 3 pointers.
 */

/*
 0 -> low-1==0
 low -> mid-1==1
 mid -> high= traverse
 high+1 ->end=2

 now traverse through pointer mid only.

 IMPORTANT =: IT IS NOT NECESSARY KI JO UPER LIKHA HAI VAHI KRNA HAI MAINE NEECHE LOW KO LAST INDEX OF 0, MID-1 LAST
 INDEX OF 1,MID KO TRAVERSE, HIGH KO FIRST INDEX OF 2 MAANA HAI TOH ESE CHANGE KR SKTE HO, BAS THODA COMMON SENSE LAGA LENA

*/

public class Sort_0_1_2 {


        public static void sortColors(int[] nums) {
            int low=-1;
            int mid=0;
            int high=nums.length;
            while(mid<high){ // since mid to high vaala region chota hota rahega toh mid++ hoga and high-- ek time aaega jab mid==high hoga tab saare elements apni sahi section pr pahuch gye hoge toh yahi base condition hai
                if(nums[mid]==0){
                    // swap mid and (low+1), mid mai 0 hai and low+1 pta nhi kya hai
                    int temp=nums[mid];
                    nums[mid]=nums[low+1];
                    nums[low+1]=temp;
                    // ab low+1 mai 0 hai and mid mai pta nhi kya hai, toh mid ko aage nhi bada skte
                    low++;
                    mid++;
                }
                else if(nums[mid]==2){
                    // swap (high-1) and mid, mid mai 2 hai and (high-1) mai pta nhi
                    int temp=nums[mid];
                    nums[mid]=nums[high-1];
                    nums[high-1]=temp;
                    high--;
                }
                else{
                    mid++;
                }
            }
        }


    public static void main(String[] args) {
        int arr[]={2,0,2,1,1,0};
        sortColors(arr);

    }
}
