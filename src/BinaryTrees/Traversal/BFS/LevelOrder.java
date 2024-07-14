package BinaryTrees.Traversal.BFS;

import BinaryTrees.Implementation.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
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
