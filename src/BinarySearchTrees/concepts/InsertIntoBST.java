package BinarySearchTrees.concepts;

import BinaryTrees.Implementation.Node;

public class InsertIntoBST {
    /**
     * There can be multiple ways to insert node in BST, but the best is ki tum use leaf node par insert kro
     * */
    public Node insertIntoBST(Node root, int val) {

        if(root==null){
            Node node=new Node(val);
            return node;
        }

        if(root.val>val){
            // means jo node apan ko banani hai voh left subtree mai insert hogi toh isliye insertIntoBST(root.left,val)
            // call kara, since usse call krne se left subtree change hoega isliye root.left= ke return mai likha
            root.left=insertIntoBST(root.left,val);
        }
        else if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }

        return root;

    }

}
