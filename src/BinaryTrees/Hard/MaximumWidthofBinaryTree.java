package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;

import java.util.*;

public class MaximumWidthofBinaryTree {
    /**
     * We can not use concept of horizontalLevel(..,-2,-1,0,1,2,...) here. The reason is given in the video.
     * We will use index of a node here.
     *
    /**
     * The answer is the number of nodes between extreme nodes in a particular level
     * Toh har level par jaao and vaha extreme nodes ke beech kitni nodes aa rhai calculate kro, max will be ans.
     * So we will do level order traversal
     * */

    public int widthOfBinaryTree(Node root) {
        // If the root is null,
        // the width is zero
        if (root == null) {
            return 0;
        }

        // Initialize a variable 'ans'
        // to store the maximum width
        int ans = 0;

        // Create a queue to perform level-order
        // traversal, where each element is a pair
        // of TreeNode and its position in the level
        Queue<Pair> q = new LinkedList<>();
        // Push the root node and its
        // position (0) into the queue
        q.add(new Pair(root, 0));

        // Perform level-order traversal
        while (!q.isEmpty()) {
            // Get the number of
            // nodes at the current level
            int size = q.size();
            // Get the position of the front
            // node in the current level
            int mmin = q.peek().node.val;

            // Store the first and last positions
            // of nodes in the current level
            int minIndex=0;
            int maxIndex=0;

            // Process each node
            // in the current level
            for (int i = 0; i < size; i++) {
                // Calculate current position relative
                // to the minimum position in the level
                int currentIndex = q.peek().node.val - mmin;
                // Get the current node
                Node node = q.peek().node;
                // Poll the front node from the queue
                q.poll();

                // If this is the first node in the level,
                // update the 'minIndex' variable
                if (i == 0) {
                    minIndex = currentIndex;
                }

                // If this is the last node in the level,
                // update the 'maxIndex' variable
                if (i == size - 1) {
                    maxIndex = currentIndex;
                }

                // Enqueue the left child of the
                // current node with its position
                if (node.left != null) {
                    q.add(new Pair(node.left, currentIndex * 2 + 1));
                }

                // Enqueue the right child of the
                // current node with its position
                if (node.right != null) {
                    q.add(new Pair(node.right, currentIndex * 2 + 2));
                }
            }

            // Update the maximum width by calculating
            // the difference between the first and last
            // positions, and adding 1
            ans = Math.max(ans, maxIndex - minIndex + 1);
        }

        // Return the maximum
        // width of the binary tree
        return ans;
    }

}

class Pair{
    Node node;
    int index;

    public Pair(Node node, int index) {
        this.node = node;
        this.index = index;
    }
}