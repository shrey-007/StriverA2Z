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

    public int height(Node node,int [] ans){

        if(node==null){return 0;}

        // find left sum
        int leftSum=height(node.left,ans);

        // find right sum
        int rightSum=height(node.right,ans);

        // calculate current path sum and update ans
        ans[0]=Math.max(leftSum+rightSum+node.val,ans[0]);
        // node khud bhi answer ho skta hai[2,-1] isme 2 khud hi answer hai
        ans[0]=Math.max(node.val,ans[0]);
        ans[1]=Math.max(leftSum+rightSum+node.val,ans[1]);
        ans[1]=Math.max(node.val,ans[1]);

        return leftSum+rightSum+node.val;
    }

    public int maxPathSum(Node root) {
        int ans[]=new int[2];
        ans[1]=Integer.MIN_VALUE;
        height(root,ans);

        if(ans[0]==0){
            if(ans[1]!=Integer.MIN_VALUE){
                return ans[1]-Integer.MIN_VALUE;
            }
        }
        return ans[0];
    }

}
