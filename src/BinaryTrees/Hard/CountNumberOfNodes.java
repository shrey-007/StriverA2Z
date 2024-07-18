package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;
import com.sun.source.tree.BreakTree;

public class CountNumberOfNodes {
    /**
     * This solution will take O(N) time complexity
     * */
    public int countNodes(Node root) {
        if(root==null){return 0;}
        return countNodes(root.right)+countNodes(root.left)+1;
    }

    /**
     * This solution will take O((logn)^2)
     * */
    public int countNodes2(Node root) {
        if (root==null){return 0;}

        int leftHeight=getLeftHeight(root);
        int rightHeight=getRightHeight(root);

        if(leftHeight==rightHeight){
            // means this subtree is perfect binary tree, toh answer calculate krne ki need nhi hai
            return (int)Math.pow(2,leftHeight)-1;
        }

        // means it is not perfect, so recursively calculate number of nodes on left and right just like method 1 approach

        return countNodes2(root.left)+countNodes2(root.right)+1;
    }

    public int getLeftHeight(Node root){
        int height=0;
        while (root.left!=null){
            height++;
            root=root.left;
        }
        return height;
    }

    public int getRightHeight(Node root) {
        int height = 0;
        while (root.right != null) {
            height++;
            root = root.right;
        }
        return height;
    }

}
