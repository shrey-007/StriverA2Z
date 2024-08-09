package BinaryTrees.Medium;


import BinaryTrees.Implementation.Node;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.

 The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 This path may or may not pass through the root.

 The length of a path between two nodes is represented by the number of edges between them.*/
public class DiameterOfBinaryTree {

    /**Method 1-: Har node pr jaao and dekho uska left and right path ko combine krke answer aaega agar vo max se bada hoga toh use max bana do*/

    public int dia(Node node){

        // right height
        int leftHeight=height(node.left);
        // left height
        int rightHeight=height(node.right);

        // calculate current diameter
        int currentDiameter=leftHeight+rightHeight;

        // we have to return max of currentDiameter, diameter of left node, diameter of right node
        return Math.max(currentDiameter,Math.max(dia(node.left),dia(node.right)));
    }

    public int height(Node root) {
        if(root==null){return 0;}

        // find height of left subtree
        int leftHeight=height(root.left);
        // find height of right subtree
        int rightHeight=height(root.right);

        // return current height
        return Math.max(leftHeight,rightHeight)+1;
    }

    /**
     * TC-: height function takes 0(N) and func har node ke liye chalta hai and har node par height function call krta hai
     * toh O(N^2)
     * */

    /**
     * Method2-: height function mai hi changes krlo, vo abhi bhi height hi return krega but ans update kr dega,
     * agar ans as a variable bhejte toh update nhi hota isliye as a object bheja and ans return isliye ni krskte
     * coz return toh vo height hi krega*/
    /**
     * Create same height function, bas usme answer(diameter) update krne ki ek line add krdo and parameter mai answer bhej do*/
    public int height2(Node root,int ans[]) {

        if(root==null){return 0;}

        // find height of left subtree
        int leftHeight=height2(root.left,ans);
        // find height of right subtree
        int rightHeight=height2(root.right,ans);

        // find diameter of current node, and update answer
        ans[0]=Math.max(ans[0],leftHeight+rightHeight);

        // return current height
        return 1+Math.max(leftHeight,rightHeight);
    }

    public int diameterOfBinaryTree(Node root) {
        int ans[]=new int[1];
        height2(root,ans);
        return ans[0];
    }


}
