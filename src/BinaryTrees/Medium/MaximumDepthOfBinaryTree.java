package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

public class MaximumDepthOfBinaryTree {


    public int maxDepth(Node root) {
        if(root==null){return 0;}

        // find height of left subtree
        int leftHeight=maxDepth(root.left);
        // find height of right subtree
        int rightHeight=maxDepth(root.right);

        // return current height
        return Math.max(leftHeight,rightHeight)+1;

    }
    // tc=0(n) since we have to travel all nodes (It is postorder traversal)
    // sc= Yaha pr hum log postorder traversal kr rhe hai toh space complexity bhi usi ki aaegi i.e O(height) which will become
    // 0(n) in worst case if it is skew tree and O(logn) in best case

}
