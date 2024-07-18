package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public Node buildTree(int[] postorder, int[] inorder) {

        List<Integer> pos=new ArrayList<>();
        List<Integer> in=new ArrayList<>();

        for (int i = 0; i < postorder.length; i++) {
            pos.add(postorder[i]);
        }

        for (int i = 0; i < inorder.length; i++) {
            in.add(inorder[i]);
        }

        return func(pos,in);

    }

    public Node func(List<Integer> postorder, List<Integer> inorder){
        if(postorder.isEmpty() || inorder.isEmpty()){return null;}

        Node curr=new Node(postorder.get(postorder.size()-1));

        // find index in inorder
        int currIndex=-1;
        for (int i = 0; i < inorder.size(); i++) {
            if (inorder.get(i)==curr.val){currIndex=i;break;}
        }

        // sabse important yahi 4 lines hai, poore question mai
        List<Integer> inorderLeft=inorder.subList(0,currIndex);
        List<Integer> inorderRight=inorder.subList(currIndex+1,inorder.size());

        List<Integer> postorderLeft=postorder.subList(0,inorderLeft.size());
        List<Integer> postorderRight=postorder.subList(inorderLeft.size(),postorder.size()-1);

        curr.left=func(postorderLeft,inorderLeft);
        curr.right=func(postorderRight,inorderRight);

        return curr;
    }
}
