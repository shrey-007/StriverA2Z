package BinarySearchTrees.problems;

import BinaryTrees.Implementation.Node;

public class KthSmallestElementInBST {
    /** Inorder(LEFT NODE RIGHT) of a BST is always in a sorted order */
    public int kthSmallest(Node root, int k) {
        int[] count = new int[1];  // To keep track of the count during traversal
        int[] ans = new int[1];    // To store the k-th smallest element
        func(root, k, ans, count);
        return ans[0];  // Return the k-th smallest element
    }

    public void func(Node root, int k, int[] ans, int[] count) {
        if (root == null) {
            return;  // Base case: if the node is null, return
        }
        func(root.left, k, ans, count);  // Traverse the left subtree
        count[0]++;  // Increment the count
        if (count[0] == k) {  // If the count matches k
            ans[0] = root.val;  // Store the k-th smallest element
            return;  // Stop further traversal
        }
        func(root.right, k, ans, count);  // Traverse the right subtree
    }
}
