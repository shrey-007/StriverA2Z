package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalOrderTraversalOfBinaryTree {
    /**
     * Approach-:
     * Create a class Pair which tells about Node, its horizontalLevel and verticalLevel
     * Now Traverse the tree through any algorithm , here i have used inorder traversal, and during traversal put the nodes into the priorityQueue.
     * Now since PriorityQueue prioritize objects based on some condition, so the conditions are, sort the nodes based on their horizontalLevel, if the horizontalLevel is same then sort them on basis of their verticalLevel, if the verticalLevel is also same then sort them based on their node.val
     * After this the PriorityQueue holds the answer, but we have to return the list so traverse PriorityQueue and store the integer value in list.
     *
     *
     * Time complexity:
     * To traverse all nodes, it took O(N)
     * For Each traversal it store the node in PriorityQueue, which took logN
     * So overall complexity is nlogn
     *
     * Space complexity:
     * Every Node is stored in PriorityQueue , so space is O(N) also recursion stack space for the func() which is doing
     * inorder traversal usme O(height) lagegi toh overall fir bhi O(N) hi lagegi.
     * */
    public List<List<Integer>> verticalTraversal(Node root) {

        List<List<Integer>> ans=new ArrayList<>();

        PriorityQueue<Pair> priorityQueue=new PriorityQueue<>();

        // traverse the whole tree and put all nodes in priorityQueue
        func(root,0,0,priorityQueue);

        int currentHorizontalLevel=priorityQueue.peek().horizontalLevel;

        List<Integer> currentList = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            // If we have reached to another horizontal level then we have to create another arraylist for it
            if (pair.horizontalLevel != currentHorizontalLevel) {
                ans.add(currentList);
                currentList = new ArrayList<>();
                currentHorizontalLevel = pair.horizontalLevel;
            }
            currentList.add(pair.node.val);
        }
        ans.add(currentList);

        return ans;

    }

    public static void func(Node node,int horizontalLevel,int verticalLevel ,PriorityQueue<Pair> priorityQueue){
        if(node==null){return;}
        func(node.left,horizontalLevel-1,verticalLevel+1,priorityQueue);
        priorityQueue.offer(new Pair(node,horizontalLevel,verticalLevel));
        func(node.right,horizontalLevel+1,verticalLevel+1,priorityQueue);
    }

}


class Pair implements Comparable<Pair>{
    Node node;
    int horizontalLevel;  // ...,-2,-1,0,1,...

    int verticalLevel;   // 0,1,2,...

    public Pair(Node node, int horizontalLevel, int verticalLevel) {
        this.node = node;
        this.horizontalLevel = horizontalLevel;
        this.verticalLevel = verticalLevel;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.horizontalLevel!=o.horizontalLevel){return this.horizontalLevel-o.horizontalLevel;}
        else if(this.verticalLevel!=o.verticalLevel){return this.verticalLevel-o.verticalLevel;}
        else{return this.node.val-o.node.val;}
    }
}
