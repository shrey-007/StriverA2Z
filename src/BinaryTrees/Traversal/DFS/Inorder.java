package BinaryTrees.Traversal.DFS;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;

public class Inorder {
    public static void func(Node node){
        if(node==null){return;}
        func(node.left);
        System.out.println(node.val);
        func(node.right);
    }
    public static void func(Node node, ArrayList<Integer> ans){
        if(node==null){return;}
        func(node.left,ans);
        ans.add(node.val);
        func(node.right,ans);
    }
}
