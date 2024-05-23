package arrays.medium;

public class BinarySearchInMatrix {
    //type 1=matrix is row wise and column wise sorted.means koi bhi row/column utha lo it is always sorted
    //try to reduce search space

    public static int[] func(int [][] matrix,int target){
        //start from top right
        int row=0; //first row
        int col=matrix[0].length-1; //last column

        while (row<matrix.length && col>=0){
            if(matrix[row][col]==target){return new int[]{row,col};}
            else if(matrix[row][col]>target){
                //since vo khud bada hai toh uske neeche vaale toh pakka bade hoge
                col--;
            }
            else{
                row++;
            }
        }
        return new int []{-1,-1};

    }

    //if we are given a sorted matrix.means ki ith row ka last element , (i+1)th row ke first element se chota hai.


    public static int[] func2(int [][] matrix,int target){

        //convert it into 1D array(not physically  but logically)
        int start=0;
        int end=(matrix.length)*(matrix[0].length);

        while(start<=end){
            int mid=(start+end)/2;
            //convert it into index of 2 d array(most important part)
            int row=mid/matrix[0].length;
            int col=mid%matrix[0].length;
            if(matrix[row][col]==target){return new int[]{row,col};}
            else if(matrix[row][col]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {


    }
}
