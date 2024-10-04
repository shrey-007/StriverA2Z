package DP.TwoAndThreeDimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumPathSumInTriangularGrid {
    /**
     * same question as MinimumPathSum
     */

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

        int result= Math.min(faith2,faith1)+triangle.get(row).get(index);

        dp.get(row).set(index,result);

        return result;
    }

    public int tabulation(List<List<Integer>> triangle){

        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
        }
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp.get(i).add(0);
            }
        }

        // base case is ki last row ke kisi bhi index i par ho and last row jaana hai toh tumhe toh usme cost
        // dp.get(lastRow).get(i) lagegi
        int indexOfLastRow=triangle.size()-1;
        int sizeOfLastRow=triangle.get(indexOfLastRow).size();
        for (int index = 0; index < sizeOfLastRow; index++) {
            int value=triangle.get(indexOfLastRow).get(index);
            dp.get(indexOfLastRow).set(index,value);
        }

        for (int row = indexOfLastRow-1; row >=0 ; row--) {
            int lastIndex=triangle.get(row).size()-1;
            for (int index = lastIndex; index >=0 ; index--) {
                int faith1=Integer.MAX_VALUE;
                int faith2=Integer.MAX_VALUE;

                if(row+1<=indexOfLastRow && triangle.get(row+1).size()>index) faith1=dp.get(row+1).get(index);
                if(row+1<=indexOfLastRow && triangle.get(row+1).size()>index+1) faith2=dp.get(row+1).get(index+1);

                int result=Math.min(faith2,faith1)+triangle.get(row).get(index);

                dp.get(row).set(index,result);
            }
        }

        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(0).size(); i++) {
            ans=Math.min(ans,dp.get(0).get(i));
        }

        return ans;
    }



}
