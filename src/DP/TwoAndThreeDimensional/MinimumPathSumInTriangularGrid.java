package DP.TwoAndThreeDimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumPathSumInTriangularGrid {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
        }
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp.get(i).add(-1);
            }
        }
        return memoization(0,0,triangle,dp);
    }

    // recursion

    public int func(int index,int row,List<List<Integer>> triangle){
        // positive base case
        if(row==triangle.size()){return 0;}

        // negative base case
        if(index==triangle.get(row).size()){return Integer.MAX_VALUE;}

        int faith1=func(index,row+1,triangle);
        int faith2=func(index+1,row+1,triangle);

        return Math.min(faith2,faith1)+triangle.get(row).get(index);
    }


    // memoization
    public int memoization(int index, int row, List<List<Integer>> triangle, ArrayList<ArrayList<Integer>> dp){
        // positive base case
        if(row==triangle.size()){return 0;}

        // negative base case
        if(index==triangle.get(row).size()){return Integer.MAX_VALUE;}

        if(dp.get(row).get(index)!=-1){return dp.get(row).get(index);}

        int faith1=memoization(index,row+1,triangle,dp);
        int faith2=memoization(index+1,row+1,triangle,dp);

        int result= Math.min(faith2,faith1)+triangle.get(row).get(index);;

        dp.get(row).set(index,result);

        return result;
    }

    public int tabulation(List<List<Integer>> triangle){

    }



}
