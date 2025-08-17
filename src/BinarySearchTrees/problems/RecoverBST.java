package BinarySearchTrees.problems;

import BinaryTrees.Implementation.Node;

/**
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped
 * by mistake. Recover the tree without changing its structure.
 * */
public class RecoverBST {
    /**
     * 1) Find the inorder traversal of BST, it will be distorted sorted array
     * 2) Sort the inorder list
     * 3) Ab ek pointer rakho i joki list ke ith node par point krega and recursively vaapis se traverse kro tree ko inorder and
     *    check if the value at node==value at list at index i or not. If yes then i++ krdo and recursion apne aap next
     *    node pr le jaaega and. If they are not equal to node.val=list.get(i); i++; krdo. Esa sirf 2 baar hi hoga
     * 4) So basically you don't need to change the nodes. You just need to change the value inside the node
     * */

    // Another way of doing this is-:
    /* Below is striver's method and it is good */
    /**
     * 1. An inorder traversal of a BST gives you elements in sorted (increasing) order.
     * 2. If two nodes are swapped, the inorder sequence will have violations
     *    (i.e., a previous element greater than the current element).
     * 3. Toh sabse pehle toh ek previous pointer lelo, ki inorder mai iterate krte time prev element kon tha, yaha hum
     *    inorder generate nhi kr rhe direct traverse kr rhe hai, do baar same kaam na krna pade jisse
     * 4. Ab concept ye hai ki agar adjacent nodes swap hui toh ek baar violation aaega, but ek doosre se door vali
     *    nodes swap hui toh 2 violations aaege
     * 5. ex-: [1, 3, 4, 6, 8, 10, 12] but 2 nodes 3,10 got swapped [1, 10, 4, 6, 8, 3, 12]
     * 6. 1 < 10 → fine
     * 7. 10 > 4 → ❌ violation → set first = 10, second = 4
     * 8. 4 < 6, 6 < 8 → fine
     * 9. 8 > 3 → ❌ violation again → second = 3 (update second)
     * 10. Finally, first = 10, second = 3.
     *
     * Concept-:
     * - If two nodes are swapped far apart → you get two violations.
     *    - first stores the bigger value from the first violation.
     *    - second stores the smaller value from the last violation.
     *
     * - If two nodes are swapped next to each other → you get only one violation.
     *    - first is the bigger one, second is the smaller one from that same violation.
     *    - So in both cases, swapping first and second restores the BST.
     *
     *
     * if (prev != null && prev.val > root.val) {
     *     if (first == null)
     *         first = prev;   // first violation
     *     second = root;      // last violation
     * }
     *
     * Now again see example for better clearity
     * */

    public void recoverTree(Node root) {

        fixBST(root);
        // swap first and second violation
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    Node prev = null, first = null, second = null;
    // prev to store prev element of inorder
    // first to store first violation
    // second to store second violation

    void fixBST(Node root) {

        if (root == null) return;

        fixBST(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null)
                // first violation mai bade vale number ko store kro
                first = prev;

            // second violation mai chote number ko store kro
            second = root;
        }

        prev = root;
        fixBST(root.right);
    }
}
