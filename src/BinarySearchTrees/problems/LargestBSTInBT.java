package BinarySearchTrees.problems;

/**
 * Brute force is , implement CheckIfGivenBT is BST or not which we have already solved
 * and pass nodes to it and return the largest BST
 * */
public class LargestBSTInBT {

    // Helper function to find the largest BST in a binary tree
    private Info largestBSTHelper(TreeNode root) {
        // Base case: if the node is null, return an Info object indicating an empty BST
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        // Recursively find the Info for the left and right subtrees
        Info leftInfo = largestBSTHelper(root.left);
        Info rightInfo = largestBSTHelper(root.right);

        // Check if the current subtree rooted at root is a BST
        if (leftInfo.isBST && rightInfo.isBST && leftInfo.max < root.val && root.val < rightInfo.min) {
            // The current subtree is a BST
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(leftInfo.min, root.val);
            int max = Math.max(rightInfo.max, root.val);
            return new Info(size, min, max, true);
        }

        // If the current subtree is not a BST, return the maximum size of the left or right subtree
        return new Info(Math.max(leftInfo.size, rightInfo.size), 0, 0, false);
    }

    // Function to return the size of the largest BST in a binary tree
    public int largestBST(TreeNode root) {
        return largestBSTHelper(root).size;
    }

    public static void main(String[] args) {
        // Example Usage
        LargestBSTInBT tree = new LargestBSTInBT();

        // Creating a Binary Tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        // Find the size of the largest BST
        System.out.println("Size of the largest BST: " + tree.largestBST(root)); // Output: 3
    }
}

class Info {
    int size;       // Size of the current subtree
    int min;        // Minimum value in the subtree
    int max;        // Maximum value in the subtree
    boolean isBST;  // Whether the subtree is a BST

    Info(int size, int min, int max, boolean isBST) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

