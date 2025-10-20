package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the
 * list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * */

/**
 *
 * first create a list of preorder traversal of nodes
 * then us list ki har(let i) node pr jaao and uska left ko null kro and right ko (i+1)th index vaali node se point karao**/
public class FlattenBinaryTreeToLinkedList {
    public void flatten(Node root) {
        // first find preorder traversal of tree
        List<Node> preorder = new ArrayList<>();
        func(root,preorder);
        // create Linked list
        createLL(root,preorder);
    }

    // function to get the preorder traversal of tree
    public void func(Node root,List<Node> preorder){
        if(root==null){return;}
        preorder.add(root);
        func(root.left,preorder);
        func(root.right,preorder);
    }

    // function to convert tree to LL
    public void createLL(Node root,List<Node> preorder){
        int n = preorder.size();
        for(int i=0;i<n-1;i++){
            Node curr = preorder.get(i);
            Node nextNode = preorder.get(i+1);
            curr.left=null;
            curr.right=nextNode;
        }
    }


    // now if you are asked to not use extra space i.e you can't use the arraylist for preorder list
    // I was asked this in gameskraft

    /* Steps-:
    / for every node u -: a) find its rightmost node in left subtree, left r
    /                     b) connect r's right to current node(u)'s right i.e r.right = u.right
                          c) make current's right , point to current's left i.e u.right = u.left
                          d) make current's left null
                          e) done for u, now go to another node, which node to go? well imagine it as a straight line if you have completed for u, you have to do for u.right
    */

    public void flatten2(Node root){

        Node curr = root; // this is u

        while(curr!=null){
            // if its left subtree exists , find rightmost node in left subtree
            if(curr.left!=null){
                Node rightMostNodeInLeftTree = curr.left;
                while (rightMostNodeInLeftTree.right!=null) rightMostNodeInLeftTree = rightMostNodeInLeftTree.right;
                rightMostNodeInLeftTree.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    /*
    *
    * - If a node has a left subtree, find the rightmost node in that left subtree.

      - Connect that rightmost node’s .right to the current node’s .right.

      - Move the left subtree to the right (curr.right = curr.left).

      - Nullify the left pointer (curr.left = null).

      - Move to curr.right.
* */
}
