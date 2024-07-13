package BinaryTrees.Traversal.DFS;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;

public class Preorder {
    public static void func(Node node){
        if(node==null){return;}
        System.out.println(node.val);
        func(node.left);
        func(node.right);
    }
    public static void func(Node node, ArrayList<Integer> ans){
        if(node==null){return;}
        ans.add(node.val);
        func(node.left,ans);
        func(node.right,ans);
    }

}
