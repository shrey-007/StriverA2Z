package BinarySearch.TwoDimensionalArrays;

public class PeakElementInTwoDimensionalArray {

    public static int[] findPeakGrid(int[][] mat) {
        int row=0;
        int col=0;
        int n=mat.length;
        int m=mat[0].length;

        while(row<n && col<m){
            int count=0;
            // left
            if((col-1>=0 && mat[row][col-1]<mat[row][col]) || col-1<0){count++;}
            else if(col-1>=0 && mat[row][col-1]>mat[row][col]){col--;}
            // right
            if((col+1<m && mat[row][col+1]<mat[row][col]) || col+1>=m){count++;}
            else if(col+1<m && mat[row][col+1]>mat[row][col]){col++;}
            // up
            if((row-1>=0 && mat[row-1][col]<mat[row][col]) || row-1<0){count++;}
            else if(row-1>=0 && mat[row-1][col]>mat[row][col]){row--;}
            // down
            if((row+1<n && mat[row+1][col]<mat[row][col]) || row+1>=n){count++;}
            else if(row+1<n && mat[row+1][col]>mat[row][col]){row++;}

            if(count==4){return new int[]{row,col};}
        }

        return new int[2];




    }
}
