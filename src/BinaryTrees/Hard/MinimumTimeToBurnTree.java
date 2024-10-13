package BinaryTrees.Hard;

/**
 * Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree
 * if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned.
 * That is its left child, right child, and parent.
 * */

import BinaryTrees.Implementation.Node;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * It is same as rotten oranges question in graph.
 * Bas isme aur graph mai farak itna hai ki graph mai saare nodes connected hoge, but yaha parent to child jaa skte hai but child to parent nhi
 * So use the same approach we used ki AllNodesDistanceKInBinaryTree
 * */
public class MinimumTimeToBurnTree {

    public static int minTime(Node root, int target){

        // First find the target node
        Node targetNode = getTargetNode(root,target);

        // get the parent pointers
        HashMap<Node,Node> parents = new HashMap<>();
        getParents(root,parents,null);

        // do bfs traversal and initially target ko daalo with time 0
        Queue<Pair2> queue = new ArrayDeque<>();
        Pair2 initialPair = new Pair2(targetNode,0);
        queue.offer(initialPair);
        int ans = 0;
        int burned[] = new int[parents.size()+1];

        while (!queue.isEmpty()){
            Pair2 pair2 = queue.poll();
            burned[pair2.node.val]=1;
            ans = Math.max(ans,pair2.time);

            // put its left, rigth , parent only if they are not already burned to burn
            // to check whether they are burned or not use burned array same as visited array

            if(pair2.node.left!=null && burned[pair2.node.left.val]==0){
                queue.offer(new Pair2(pair2.node.left,pair2.time+1));
            }
            if(pair2.node.right!=null && burned[pair2.node.right.val]==0){
                queue.offer(new Pair2(pair2.node.right,pair2.time+1));
            }
            if(parents.get(pair2.node)!=null && burned[parents.get(pair2.node).val]==0){
                queue.offer(new Pair2(parents.get(pair2.node),pair2.time+1));
            }
        }

        return ans;
    }

    public static void getParents(Node node, HashMap<Node,Node> parentPointers, Node parent){
        if(node==null){return;}
        parentPointers.put(node,parent);
        getParents(node.left,parentPointers,node);
        getParents(node.right,parentPointers,node);
    }
    public static Node getTargetNode(Node node,int target){
        if(node==null){return node;}
        if(node.val==target){return node;}
        Node faith1 = getTargetNode(node.left,target);
        Node faith2 = getTargetNode(node.right,target);
        if(faith1!=null){return faith1;}
        else{return faith2;}
    }

}
class Pair2{
    Node node;
    int time;

    public Pair2(Node node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Pair2{" +
                "node=" + node +
                ", time=" + time +
                '}';
    }
}
