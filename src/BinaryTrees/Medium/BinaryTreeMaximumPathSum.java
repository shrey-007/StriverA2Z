package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
 * connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass
 * through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path
 * */
public class BinaryTreeMaximumPathSum {

    /**
     * 1) Dekho ans mai apan ko max path sum chaiye hai jo ki leftSum+rightSum+node.val hoga but
     *    usko nikaalne ke liye apan leftSum, rightSum call kr rhe hai jo ye return krege ki left node se ek side ka sum
     *    kitna hai and right node se ek side ka sum kitna hai. Isliye return mai Math.max(leftSum,rightSum)+node.val kra hai
     * */

    // This is the modified version of height function

    public int height(Node node,int [] ans){

        if(node==null){return 0;}

        // find left path sum(Sum has to be positive otherwise usko lene ka koi sense nhi hai isliye 0 se compare kra)
        int leftSum=Math.max(0,height(node.left,ans));

        // find right path sum(Sum has to be positive otherwise usko lene ka koi sense nhi hai isliye 0 se compare kra)
        int rightSum=Math.max(0,height(node.right,ans));

        // calculate current path sum and update ans
        ans[0]=Math.max(ans[0],leftSum+rightSum+node.val);

        // we don't have to return the sum of current path, we have to return sum of left,right branch
        return Math.max(leftSum,rightSum)+node.val;
    }

    public int maxPathSum(Node root) {
        int ans[]=new int[1];
        ans[1]=Integer.MIN_VALUE;
        height(root,ans);
        return ans[0];
    }

    /**
     * It is post order traversal so TC, SC will be O(N), O(height)*/

}
