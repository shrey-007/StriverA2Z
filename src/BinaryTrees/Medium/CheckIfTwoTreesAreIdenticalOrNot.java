package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

public class CheckIfTwoTreesAreIdenticalOrNot {
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
}
