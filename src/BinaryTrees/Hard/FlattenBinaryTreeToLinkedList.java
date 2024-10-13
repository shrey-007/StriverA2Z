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
}
