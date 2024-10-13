package BinaryTrees.Hard;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values
 * of all nodes that have a distance k from the target node.
 * You can return the answer in any order.*/

import BinaryTrees.Implementation.Node;

import javax.print.attribute.HashDocAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
  * Approach-: Jaruri nhi hai ki Target node root ho. Esa bhi ho skta hai ki target node kahi beech mai lie kr rhi ho.
 *  Toh agar apan target node par and usse k distance door jaana hai toh ya toh left jaao left pointer ke through, ya right
 *  jaao rigth pointer ke through , ya fir uper ki taraf jaao. But uper jaane ka koi pointer nhi hai tree mai. Toh voh
 *  pointer khud se bana lo. Do a traversal on whole tree and store parent of each node
 *  */
public class AllNodesDistanceKInBinaryTree {

     public List<Integer> distanceK(Node root, Node target, int k) {

         // get the parent pointers of nodes
         HashMap<Node,Node> parents = new HashMap<>();
         getParents(root,parents,null);

         List<Integer> ans = new ArrayList<>();
         func(target,0,parents,new int[parents.size()+1],k,ans);

         return ans;
     }

     public void getParents(Node node, HashMap<Node,Node> parentPointers,Node parent){
         if(node==null){return;}
         parentPointers.put(node,parent);
         getParents(node.left,parentPointers,node);
         getParents(node.right,parentPointers,node);
     }

     public void func(Node node,int count,HashMap<Node,Node> parentPointers,int visited[],int k,List<Integer> ans){
         if(node==null){return;}
         // if the node is already visited then don't explore it
         if(visited[node.val]==1){return;}
         // if the count is equal to k, then we have store current node in ans, ans this is k distance far from target
         if(count==k){ans.add(node.val);}
         // mark current node as visited
         visited[node.val]=1;
         // so we are at a node and apne paas 3 options hai, ya toh left jaao or right or uper jaao
         func(node.left,count+1,parentPointers,visited,k,ans);
         func(node.right,count+1,parentPointers,visited,k,ans);
         func(parentPointers.get(node),count+1,parentPointers,visited,k,ans);
     }

}
