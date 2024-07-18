package BinaryTrees.Traversal.BFS;

import BinaryTrees.Implementation.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Time-: O(n) (har node ek baar visit hogi)
 * Space-:O(N/2) The space complexity is determined by the maximum number of nodes that can be held in the queue at any one time.
 * This maximum number of nodes typically occurs at the level with the most nodes, which is at most half of the total
 * number of nodes in a complete binary tree.
 * Worst case mai  space complexity O(N/2) hogi jab pefect BT hoga toh saari leaf nodes same level pr hogi toh n/2 leaf nodes hogi
 * and queue mai poore ek level ke nodes store hoge toh n/2 store hoge
 * */
public class LevelOrder {
    public static void func(Node node){

        Queue<Node> queue=new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            Node node1=queue.poll();
            System.out.println(node1.val);
            if(node1.left!=null){queue.add(node1.left);}
            if(node1.right!=null){queue.add(node1.right);}
        }
    }

    public static ArrayList<ArrayList<Integer>> func2(Node node){

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<Node> queue=new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            // get the size of current level
            int size=queue.size();
            ArrayList<Integer> currentLevel=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node1=queue.poll();
                currentLevel.add(node1.val);
                if(node1.left!=null){queue.add(node1.left);}
                if(node1.right!=null){queue.add(node1.right);}
            }
            // current level is finished so add it in ans
            ans.add(currentLevel);
        }
        return ans;
    }

}
