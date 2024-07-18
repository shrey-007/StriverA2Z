package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public Node buildTree(int[] preorder, int[] inorder) {

        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();

        for (int i = 0; i < preorder.length; i++) {
            pre.add(preorder[i]);
        }

        for (int i = 0; i < inorder.length; i++) {
            in.add(inorder[i]);
        }

        return func(pre,in);

    }

    public Node func(List<Integer> preorder, List<Integer> inorder){
        if(preorder.isEmpty() || inorder.isEmpty()){return null;}

        Node curr=new Node(preorder.get(0));

        // find index in inorder
        int currIndex=-1;
        for (int i = 0; i < inorder.size(); i++) {
            if (inorder.get(i)==curr.val){currIndex=i;break;}
        }

        // sabse important yahi 4 lines hai, poore question mai
        List<Integer> inorderLeft=inorder.subList(0,currIndex);
        List<Integer> inorderRight=inorder.subList(currIndex+1,inorder.size());

        List<Integer> preorderLeft=preorder.subList(1,preorder.size());
        List<Integer> preorderRight=preorder.subList(2,preorder.size());

        curr.left=func(preorderLeft,inorderLeft);
        curr.right=func(preorderRight,inorderRight);

        return curr;
    }
}
