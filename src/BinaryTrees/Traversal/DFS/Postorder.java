package BinaryTrees.Traversal.DFS;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;

public class Postorder {
    public static void func(Node node){
        if(node==null){return;}
        func(node.left);
        func(node.right);
        System.out.println(node.val);
    }
    public static void func(Node node, ArrayList<Integer> ans){
        if(node==null){return;}
        func(node.left,ans);
        func(node.right,ans);
        ans.add(node.val);
    }

}
