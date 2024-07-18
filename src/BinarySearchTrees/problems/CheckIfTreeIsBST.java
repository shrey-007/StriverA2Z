package BinarySearchTrees.problems;

import BinaryTrees.Implementation.Node;

public class CheckIfTreeIsBST {
    public boolean isValidBST(Node root) {
        if(root==null){return true;}
        if((root.left!=null && root.val<root.left.val) || (root.right!=null && root.val>root.right.val)){return false;}
        return isValidBST(root.right) && isValidBST(root.left);
    }
    /**This solution is totally wrong, Take a test case
     * root=5
     * 5.left=4;    5.right=6      (means yaha se true return hoga)
     *              6.left=3;   6.right=7;   (means yaha se true return hoga)
     * 5 left se bada(4) hai and right(6) se chota
     * 6 bhi left(3) se bada hai and right(7) se chota, But 6 ka jo left hai 3 voh itna chota  hai ki 5 se bhi chota hai
     * */

    /** Below is the correct version */


    public boolean isValidBST2(Node root) {
        return func(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean func(Node root,long startRange,long endRange){
        if(root==null){return true;}
        if(root.val<=startRange || endRange<=root.val){return false;}
        return func(root.right,root.val,endRange) && func(root.left,startRange,root.val);
    }

}
