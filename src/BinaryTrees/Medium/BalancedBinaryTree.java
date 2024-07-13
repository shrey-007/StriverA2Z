package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

public class BalancedBinaryTree {
    /**
     * Given a binary tree, determine if it is height-balanced
     * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs
     * by more than one.
     .*/

    /**
     * Method1-: Har node ke liye check kro ki uski left subtree ki height and right subtree ki height ka difference
     * 1 se jyaada toh nhi hai
     * */

    public boolean isBalanced(Node root) {

        if(root==null){return true;}

        // find whether it is balanced at this node or not
        // so first find the height of its left and right subtree
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        // if difference of height exceeds then return false
        if(Math.abs(leftHeight-rightHeight)>1){return false;}

        // if it does not exceed then we have to check the same for its left and right children
        else{
            return isBalanced(root.left) && isBalanced(root.right);
        }

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
     * tc= har node ko traverse kara ye find krne ke liye ki vo balanced hai ki nhi-> O(n),
     * and har node ke liye left and right height nikaali -> O(N)+O(N)
     * Toh total 2n^2 ho gyi
     * */


    /**Better way is to use the height function itself , whenever node is balanced then it will return height,
     * but if the node is not balanced then it will return -1. If -1 is returned by any of the call means tree
     * is unbalanced toh -1 hi return krvaao*/

    public static boolean isBalanced2(Node node){
        return height2(node)!=-1;
    }

    public static int height2(Node node){

        // calculate left and right height
        int leftHeight=height2(node.left);
        int rightHeight=height2(node.right);

        // check kro  left or right subtree agar already non balanced hai toh directly -1 return kro
        if (leftHeight==-1 || rightHeight==-1){return -1;}

        // means ki left and right subtree balanced hai , but apni current node check kro ki voh balanced hai ki nhi
        if (Math.abs(leftHeight-rightHeight)>1){return -1;}

        // means ki left , right subtree, current node sab balanced hai toh height return krdo
        return Math.max(leftHeight,rightHeight)+1;
    }

}
