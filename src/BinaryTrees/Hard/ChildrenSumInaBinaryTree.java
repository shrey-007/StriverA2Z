package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;

/**
 * Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child
 * nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.
 *
 * For every node, data value must be equal to the sum of data values in left and right children. Consider data value
 * as 0 for NULL child.  Also, leaves are considered to follow the property.
 * */
public class ChildrenSumInaBinaryTree {
    public static int isSumProperty(Node root) {

        if(root==null){return 1;}
        // since leaf nodes ke liye check nhi krna vo already us property ko follow krti hai toh return 1
        if(root.right==null && root.left==null){return 1;}

        // do work
        int sumOfChildren=0;
        if(root.right!=null){sumOfChildren=sumOfChildren+root.right.val;}
        if(root.left!=null){sumOfChildren=sumOfChildren+root.left.val;}

        if(root.val!=sumOfChildren){
            // agar equal nhi hai toh abhi hi 0 return krdo no further calls
            return 0;
        }

        // now call recursively

        else{
            // means current node toh satisfy kr rhi hai ab baaki nodes ka check kro
            if(isSumProperty(root.left)==1 && isSumProperty(root.right)==1){return 1;}
            else{return 0;}
        }

    }
}
