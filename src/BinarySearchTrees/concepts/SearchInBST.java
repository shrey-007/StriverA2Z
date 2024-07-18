package BinarySearchTrees.concepts;

import BinaryTrees.Implementation.Node;

public class SearchInBST {
    public Node searchBST(Node root, int val) {

        if(root==null){return null;}
        if(root.val==val){return root;}

        else if(root.val>val){
            return searchBST(root.left,val);
        }

        else {
            return searchBST(root.right,val);
        }
    }
}
