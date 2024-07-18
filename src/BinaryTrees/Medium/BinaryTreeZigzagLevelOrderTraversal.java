package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * It is same as level order traversal bas ek baar ans arraylist ke start mai add kro , ek baar end mai
     * Toh iski space and time complexity bhi level order vaali hogi n,n/2
     * */
    public List<List<Integer>> zigzagLevelOrder(Node root) {

        if(root==null){
            List<List<Integer>> ans=new ArrayList<>();
            return ans;
        }

        Queue<Node> queue=new ArrayDeque<>();
        List<List<Integer>> ans=new ArrayList<>();

        queue.offer(root);
        boolean flag=true;  // left to right

        while (!queue.isEmpty()){
            // get size of current level
            int size=queue.size();
            ArrayList<Integer> tempAns=new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if(flag){
                    // left to right
                    Node curr=queue.poll();
                    // add at end
                    tempAns.add(curr.val);
                    if(curr.left!=null){queue.offer(curr.left);}
                    if(curr.right!=null){queue.offer(curr.right);}
                }
                else{
                    // right to left
                    Node curr=queue.poll();
                    // add at start
                    tempAns.add(0,curr.val);
                    if(curr.left!=null){queue.offer(curr.left);}
                    if(curr.right!=null){queue.offer(curr.right);}
                }
            }

            ans.add(tempAns);
            // reverse krdo jiise agli baar reverse order mai insert ho elements
            flag=!flag;

        }

        return ans;
    }
}
