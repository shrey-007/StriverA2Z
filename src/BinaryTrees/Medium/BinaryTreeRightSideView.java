package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;


import java.util.*;

public class BinaryTreeRightSideView {
    /**
     * 1) Since Right view chaiye toh dfs kro Node,Right,Left is order mai
     * 2) */
    public List<Integer> rightSideView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        func(root,0,ans);
        return ans;
    }

    public static void func(Node root,int verticalLevel,ArrayList<Integer> ans){

        if(root==null){return;}

        // har verticalLevel ki rightmost node is list mai hogi , and sabse pehle ye line rightmost node hi execute krega
        // suppose 0th level ki rightmost node mili but list size 0 hai means ki use abhi store nhi kra toh use store krlo
        // ab suppose 0th level ki leftmost node mili tumhe kiuki iteration us pr bhi jaaegi, bhale hi baad mai jaaye lekin
        // jaaegi toh pakka hai, toh list usko store na krle isliye ye condition lagai hai agar verticalLevel>ans.size() means
        // ki us verticalLevel ki rightmost node already store krli hai toh use store mt kro
        if(verticalLevel==ans.size()){ans.add(root.val);}

        // pehle right jaao
        func(root. right,verticalLevel+1,ans);
        // phir left jaao
        func(root.left,verticalLevel+1,ans);
    }



    /**This code is giving wrong answer for the test case - [1,2,3,null,5,6]
     * Output should be-: [1,3,6]
     * but ye output aa rha hai-: [1,3,5]
     * kiuki isme 5,6 same horizontal,vertical level pr hai toh us vertical level pr 5 store hua pehle fir jab iteration 6 pr gaya toh same vertical level dikha and same horizontalLevel
     * dikha toh voh (pairInTreeMap.horizontalLevel<horizontalLevel) condition false hui toh voh update nhi hua toh condition mai equal to bhi lagado
     * But since */

    /**
     * Can we do it using rightBoundaryTraversal?
     * Can we do bottom view through leaves traversal which we have already done, lets try
     * No you can't , this is the only way.
     * Suppose Left view ki baat kr rhe hai
     * See the picture, usme agar leftBoundaryTraversal lagaoge toh 1 2 4 5 print hoga bas
     * But ye method use kroge toh 1 2 4 5 10 11 print hoga, reason is ki ye vaala method dono nodes pr jaata hai right,left
     * bas pehle right pr jaata hai and dekhta hai ki y vertical level ki righmost node hai toh save krlo else agar left
     * node hai toh jaaega tab bhi but ans mai save nhi karega
     *
     * */


}


