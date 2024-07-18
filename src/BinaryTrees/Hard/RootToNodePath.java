package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;

public class RootToNodePath {
    /**
     * 1) Apan ko traverse krna padega tree ko toh ko bhi traversal use krlo, i used preorder here
     * 2) Agar tum root se us node tak pahuch bhi gye toh tumhe pata kese padega, ki tum pahuch gaye aur aage ki calls nhi kro,
     *    Toh isliye function boolean return krega ye batane ke liye ki vo us node tak pahuch gya hai ab aage traverse mt kro */
    public static boolean func(Node root, Node target, ArrayList<Integer> list){
        if (root==null){
            // means ye voh path nhi hai
            return false;
        }

        // do work(abhi pata nhi hai ki ye current node us path mai hoga ki nhi toh add krlo bhi, agar nhi hoga toh vaapis aate time hata denge)
        list.add(root.val);

        if(root==target){
            // if we found our target toh return true, means no need to check further , we already found our ans
            return true;
        }

        // go right and left
        boolean leftPath=func(root.left,target,list);
        boolean rightPath=func(root.right,target,list);

        if(leftPath==true || rightPath==true){
            // if any one of it is true toh return true, means no need to check further , we already found our ans in one of our subtree
            return true;
        }

        // means is node ke children mai target nhi hai, toh ise path se remove kro
        // ye backtrack krte time remove hoga
        list.remove(list.size()-1);

        return false;
    }
}
