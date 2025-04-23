import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public int getMaxLen(int[] nums) {
        int numberOfNegatives = 0;
        int indexOfFirstNegtive = -1;
        int ans = 0;

        int n = nums.length;
        int start = 0;
        int end = 0;

        while(end<n){
            if(nums[end]==0){
                start = end+1;
                end++;
                numberOfNegatives = 0;
                indexOfFirstNegtive = -1;
                continue;
            }
            if(nums[end]<0){
                numberOfNegatives++;
                if(indexOfFirstNegtive==-1) indexOfFirstNegtive = end;
            }
            if(numberOfNegatives%2==0){
                ans = Math.max(end-start+1,ans);
            }
            else{
                if(indexOfFirstNegtive!=end){
                    int length = end-indexOfFirstNegtive;
                    ans = Math.max(length,ans);
                }
            }
            end++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int arr[] = {-1,-2,-3,0,1};
        System.out.println(main.getMaxLen(arr));
    }
}
