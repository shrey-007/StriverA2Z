package Arrays.medium;

import java.util.Arrays;

public class RotateMatrixBy90Degree {
    public static void rotate(int matrix[][]){

        // first take the transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(j>i){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }

        // then reverse the columns
        int i=0;
        int j=matrix[0].length-1;
        while (i<j){
            for (int k = 0; k < matrix.length; k++) {
                int temp=matrix[k][i];
                matrix[k][i]=matrix[k][j];
                matrix[k][j]=temp;
            }
            i++;
            j--;
        }

        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public static void main(String[] args) {
        int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

}
