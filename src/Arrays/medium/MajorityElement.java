package Arrays.medium;



// Q=Given an array nums of size n, return the majority element.The majority element is the element that appears more
// than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class MajorityElement {
    //method1= index 0 se start kro and end tak iterate kro ki index 0 vaala element kitne baar aaya if >n/2 then it is ans
    //index 0 se start kro and end tak iterate kro ki index 1 vaala element kitne baar aaya if >n/2 then it is ans
    //and so on

    //method2=crate a hashmap storing (element,count).then traverse in hashmap if it contains the key which is >n/2

    //method3=moore voting algorithm
    public int func(int arr[]){
        //maan lo ki index 0 is ans hai.
        int winner=arr[0];
        //abhi index 0 ka count 1 hai coz ek hi baar aaya hai ab tak
        int equivalent_votes_of_winner=0;

        /*
        algorithm kuch esi hai ki  total arr.length voters hai.
        since jeetne vaala voh hai jiske paas more than half of votes hai, toh remaining sabke votes mila bhi do tab bhi jeetne vale ke equal nhi hoge
        means jeetne vale ke number of votes mai se baaki sabhi ke votes subtract krdo still it will be a positive number.

        equivalent_votes_of_winner=total votes of winner-total remaining votes > 0
         */

        for (int i = 1; i <arr.length ; i++) {
            if(equivalent_votes_of_winner==0){
                //means ki ye winner nhi hai coz winner ke equivalent_votes_of_winner>0 hota hai
                //change winner, assume current vala winner h
                winner=arr[i];
                equivalent_votes_of_winner=1;
            }
            if(arr[i]==winner){
                //since winner ko ek aur vote aaya toh uske vote badao
                equivalent_votes_of_winner++;
            }
            else{
                //since winner ko vote nhi aaya, toh kisi aur ko gaya toh use vote subtract kro
                equivalent_votes_of_winner--;
            }
        }
        return winner;
    }



    public static void main(String[] args) {
        int arr[]={2,2,1,1,1,2,2};
    }

}
