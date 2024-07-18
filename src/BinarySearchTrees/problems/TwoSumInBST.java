package BinarySearchTrees.problems;

import BinaryTrees.Implementation.Node;

public class TwoSumInBST {
    /**
     * Method1-:
     * 1) BST ka inorder ka list bana lo joki sorted hogi coz inorder BST IS SORTED. so it is reduced to 2 sum
     * 2) Us list mai 2 pointer rakho start=0; end=list.size()-1;
     * 3) If list[start]+list[end]>target{end--;}
     * 4) If list[start]+list[end]<target{start++;}
     * 5) else if list[start]+list[end]==target{// ans mil gaya}
     * */

    /**
     * Method2-: BST Iterator
     * */

}
