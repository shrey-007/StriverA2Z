package arrays.medium;

public class SetMatrixZero {

    // function to set the whole column zero
    public void setColumnZero(int matrix[][],int column){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column]=0;
        }
    }

    // function to set the whole row zero
    public void setRowZero(int matrix[][],int row){
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i]=0;
        }
    }

    // TC = N2
    // SC= N(FOR rowWithZero AND columnWithZero)
    public void setMatrixZero1(int matrix[][]){

        // an array denoting ki konsi row mai 0 hai
        int rowWithZero[]=new int[matrix.length];
        // an array denoting ki konsi column mai 0 hai
        int columnWithZero[]=new int[matrix[0].length];

        // iterate over whole matrix and jis bhi cell pe 0 dikhe uska respective rowWithZero,colWithZero ko 1 krdo
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    rowWithZero[i]=1;
                    columnWithZero[j]=1;
                }
            }
        }

        // jo rowWithZero mai 1 hai unko poori row ko 0 krdo

        for (int i = 0; i < rowWithZero.length; i++) {
            if(rowWithZero[i]==1){setRowZero(matrix,i);}
        }

        // jo colWithZero mai 1 hai unko poori col ko 0 krdo

        for (int i = 0; i < columnWithZero.length; i++) {
            if(columnWithZero[i]==1){setColumnZero(matrix,i);}
        }

    }


    // tc= n3
    // sc=1
    public void setMatrixZero2(int matrix [][]){
        // iterate over whole matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    setRowMinusOne(matrix,i);
                    setColumnMinusOne(matrix,j);
                }
            }
        }

        // now jo -1 hai unko 0 set kro

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }

    }

    public void setRowMinusOne(int matrix[][],int row){
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[row][i]!=0){matrix[row][i]=-1;}
        }
    }

    public void setColumnMinusOne(int matrix[][],int column){
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][column]!=0){matrix[i][column]=-1;}
        }
    }

    // TC = N2
    // SC = 1
    public void setMatrixZero3(int matrix[][]){
        int col0 = 1;
        int n=matrix.length;
        int m=matrix[0].length;

        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // mark i-th row:
                    matrix[i][0]=0;

                    // mark j-th column:
                    if (j != 0)
                        matrix[0][j]=0;
                    else
                        col0 = 0;
                }
            }
        }



        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j]!=0) {
                    // check for col & row:
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j]=0;
                    }
                }
            }
        }


        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j]=0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0]=0;
            }
        }
    }

}
