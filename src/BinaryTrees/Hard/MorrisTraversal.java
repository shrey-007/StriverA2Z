package BinaryTrees.Hard;

// normal bfs/dfs traversal is done using recursion which take O(N) time , and O(N) auxillary stack space or queue space for BFS
// even if you do iterative bfs/dfs still it will take same time and space, as for iterative you yourself have to create your own stack, instead of recursion stack

// morris does not take extra space

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MorrisTraversal {

    // Function to perform Morris Inorder Traversal
    public void morrisInorder(TreeNode root) {
        TreeNode current = root;

        while (current != null) {

            // Case 1: If there is no left child, print this node and move to right
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                // Case 2: Find inorder predecessor (rightmost node in left subtree)
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Case 2a: If the predecessor's right is null, make current as right child of predecessor
                // This creates a temporary link to come back to current after left subtree is done
                if (predecessor.right == null) {
                    predecessor.right = current;  // Create the thread
                    current = current.left;       // Move to left subtree
                }
                // Case 2b: If the thread already exists, break it and visit current node
                else {
                    predecessor.right = null;     // Remove the thread
                    System.out.print(current.val + " ");
                    current = current.right;      // Move to right subtree
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MorrisTraversal mt = new MorrisTraversal();
        System.out.println("Morris Inorder Traversal:");
        mt.morrisInorder(root);
    }
}

