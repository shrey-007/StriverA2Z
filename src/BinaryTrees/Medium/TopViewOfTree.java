package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

import java.util.*;

public class TopViewOfTree {

    /** Do a level order traversal because
     * 1) Top view chaiye toh pehle uper ke level ki nodes traverse kro phir neeche ke level pr jaao toh sahi ans aaeega
     * 2) Agar recursive approach use kri toh voh either rightmost se start krega or leftmost or node itself toh ans nhi aaega
     * 3) Toh uper ke level pehle traverse krne ke liye level order hi use krege-:
     * 4) It is level order toh TC-N, SC-N/2(queue ke last level)*/
    public static ArrayList<Integer> topView(Node root) {

        HashMap<Integer,Integer> hashMap=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int entry: hashMap.values()){
            ans.add(entry);
        }
        return ans;
    }

    public static void func(Node root,HashMap<Integer,Integer> hashMap){

        Queue<Pair3> queue=new ArrayDeque<>();

        queue.offer(new Pair3(root,0));

        while (!queue.isEmpty()){
            Pair3 pair=queue.poll();
            Node node=pair.node;

            if(node.left!=null){queue.add(new Pair3(node.left,pair.horizontalLevel-1));}
            if(node.right!=null){queue.add(new Pair3(node.right,pair.horizontalLevel+1));}

            // agar us horizontal level pr koi node nhi hao toh ise daaldo, else us par already ek node hai and vo
            // is node se uper hai toh ye ans nhi hai jo pehle daali th vahi ans hai
            if(!hashMap.containsKey(pair.horizontalLevel)){
                hashMap.put(pair.horizontalLevel,node.val);
            }
        }
    }



}

class Pair3{
    Node node;
    int horizontalLevel; // .....,-3,-2,-1,0,1,2,.....

    public Pair3(Node node, int horizontalLevel) {
        this.node = node;
        this.horizontalLevel = horizontalLevel;
    }
}
