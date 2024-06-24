package Arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixInSpiralManner {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rs=0;
        int re=matrix[0].length-1;
        int cs=0;
        int ce=matrix.length-1;

        int n=matrix.length;
        int m=matrix[0].length;
        int all=n*m;
        int count=0;
        List<Integer> ans=new ArrayList<>();


        while(count<all){
            for(int i=rs;i<=re && count<all;i++){
                ans.add(matrix[cs][i]);
                count++;
            }
            for(int i=cs+1;i<=ce && count<all;i++){
                ans.add(matrix[i][re]);
                count++;
            }
            for(int i=re-1;i>=rs && count<all;i--){
                ans.add(matrix[ce][i]);
                count++;
            }
            for(int i=ce-1;i>cs && count<all;i--){
                ans.add(matrix[i][rs]);
                count++;
            }
            rs++;
            re--;
            cs++;
            ce--;
        }

        return ans;

    }
}
