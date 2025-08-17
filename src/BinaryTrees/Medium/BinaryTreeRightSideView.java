package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;


import java.util.*;

public class BinaryTreeRightSideView {
    /**
     * 1) Since Right view chaiye toh dfs kro Node,Right,Left is order mai
     * 2) We will explore all nodes and see it that node is the rightmost node of that level
     * 3) How to find that the node is the rightmost node of its level?. Dekho ith level par pehli baar jaaoge toh jo
     * first node, milegi vahi rightmost node hogi coz call pehle right ko kra hai. Toh use store krlo. But point is ki
     * vaapis agar ith level pr gye and koi aur node milli jo ki rightmost ni hogi obv. toh usko store krne se kese roke.
     * */
    ArrayList<Integer> rightView(Node root) {
         HashMap<Integer,Integer> hm = new HashMap<>();
         bfs(root,hm);
         ArrayList<Integer> horizontalLevels = new ArrayList<>(hm.keySet());
         ArrayList<Integer> ans = new ArrayList<>();
         Collections.sort(horizontalLevels);
         for(int key: horizontalLevels){
             ans.add(hm.get(key));
         }
         return ans;
    }

     void bfs(Node root,HashMap<Integer,Integer> hm){
        // first insert right child then left child, so at each yth level you will encounter the rightmost node first
        Queue<Pair2> queue = new ArrayDeque<>();
        queue.offer(new Pair2(0,0,root));

        while(!queue.isEmpty()){
            Pair2 pair = queue.poll();
            int x = pair.x;
            int y = pair.y;
            Node node = pair.node;
            if(!hm.containsKey(y)){
                // if hm does not contains key, means this is the first time we are in this y level and this is the
                // rightmost node of this level
                hm.put(y,node.val);
            }
            // go right
            if(node.right!=null){
                queue.offer(new Pair2(x+1,y+1,node.right));
            }
            // go left
            if(node.left!=null){
                queue.offer(new Pair2(x-1,y+1,node.left));
            }
        }
    }
}

/**
 * Also note that right,left,top,bottom view is done using hashmap, where we store key as level and value as rightmost/
 * topmost/bottommost node etc.
 *
 * But right boundary is different. It goes right if right is availabale, it will not go to left. And if right is not
 * available then it will go to left
 *
 * Lets take an example -:
 *        1
 *      /   \
 *     2     3
 *    / \
 *   6   7
 *  /    \
 * 8      9
 *   here if you use rightboundary concept toh your result will be 1,3.
 *   But actual result should be 1,3,7,9
 *   Even if you do rightboundary()+addLeaves() still it will give 1,3,8,9. which is totally wrong.
 *   The thing is going left only when right is not available does not work for right side view. Simple
 * */

class Pair2{
    int x;
    int y;
    Node node;
    Pair2(int x,int y,Node node){
        this.x=x;
        this.y=y;
        this.node=node;
    }
}


