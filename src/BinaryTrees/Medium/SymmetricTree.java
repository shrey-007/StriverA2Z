package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

public class SymmetricTree {

    /** This question is same as CheckIfTwoTreesAreIdenticalOrNot , only difference is-:
     * 1) vaha 2 alag trees hote the yaha same tree ke 2 subtrees hai, means root ka jo left, right subtree hai unme identical ka check lagana hai
     * 2) Also suppose root ke left subtree ka inorder ye hai [1,2,3] and root ke right subtree ka inorder ye hai [3,2,1], toh ye symmetric hai,
     *    toh isse ye pata padta hai ki p.right,q.right ka comparison and p.left,q.left ka comparison nhi krna vo identical trees mai krte the
     *    apan ko isme p.right,q.left ka comparison and p.left,q.right ka comparison krna hai toh isSameTree() ke last line mai slight change hai.
     * 3) isSameTree() is preorder traversal so you know the TC, SC */
    public boolean isSymmetric(Node root) {

        if(root==null){return true;}

        if(root.right==null && root.left==null){return true;}

        // means ki dono mai se koi ek null hai doosra nhi hai
        if(root.right==null || root.left==null){return false;}

        return isSameTree(root.left,root.right);

    }
    public boolean isSameTree(Node p, Node q) {

        // if both r null toh return true
        if(p==null && q==null){return true;}
        // agar koi ek null hai and doosre mai value hai toh false return kro
        if(p==null || q==null){return false;}

        // self work
        if(p.val!=q.val){return false;}

        // faith
        return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
    }

    public static void main(String[] args) {


    }

}
