package BinarySearchTrees.problems;

import BinaryTrees.Implementation.Node;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped
 * by mistake. Recover the tree without changing its structure.
 * */
public class RecoverBST {
    /**
     * 1) Find the inorder traversal of BST, it will be distorted sorted array
     * 2) Sort the inorder list
     * 3) Ab ek pointer rakho i joki list ke ith node par point krega and recursively vaapis se traverse kro tree ko inorder and
     *    check if the value at node==value at list at index i or not. If yes then i++ krdo and recursion apne aap next
     *    node pr le jaaega and. If they are not equal to node.val=list.get(i); i++; krdo. Esa sirf 2 baar hi hoga
     * 4) So basically you don't need to change the nodes. You just need to change the value inside the node
     * */

    // Another way of doing this is-:

    public void recoverTree(Node root) {

        fixBST(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    Node prev = null, first = null, second = null;

    void fixBST(Node root) {

        if (root == null) return;

        fixBST(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null)
                first = prev;

            second = root;
        }

        prev = root;
        fixBST(root.right);
    }
}
