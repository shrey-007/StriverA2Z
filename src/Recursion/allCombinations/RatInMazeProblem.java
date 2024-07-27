package Recursion.allCombinations;

import java.util.ArrayList;

public class RatInMazeProblem {
    /**
     * If matrix is of size NxM, toh usme R m baar aaega and D n baar bas order change hoga. TAKE, NOT TAKE nhi hai
     * TAKE toh sabko hi krna hai , bas order ka farak hai.*/
    public void func(int row,int col,int [][] matrix,int visited[][],String currentAns,ArrayList<String> ans){
        if(row== matrix.length-1 && col==matrix[0].length-1){
            ans.add(currentAns);
        }
        // go to all possible paths
        int r[]={0,0,1,-1};
        int c[]={1,-1,0,0};
        char p[]={'R','L','D','U'};
        for (int i = 0; i < 4; i++) {
            int nextRow=row+r[i];
            int nextCol=col+c[i];
            char nextPath=p[i];
            if(nextRow>=0 && nextRow< matrix.length && nextCol>=0 && nextCol<matrix[0].length && visited[nextRow][nextCol]==0 && matrix[nextRow][nextCol]==1){
                visited[nextRow][nextCol]=1;
                func(nextRow,nextCol,matrix,visited,currentAns+nextPath,ans);
                visited[nextRow][nextCol]=0;
            }
        }
    }
    public ArrayList<String> findPath(int[][] mat) {
        if(mat[0][0]==0){return new ArrayList<>();}
        ArrayList<String> ans=new ArrayList<>();
        int visited[][]=new int[mat.length][mat[0].length];
        // Don't forget to mark the starting point as visited
        visited[0][0]=1;
        func(0,0,mat,visited,"",ans);
        return ans;
    }
}
