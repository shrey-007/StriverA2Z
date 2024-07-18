package BinarySearchTrees.concepts;

import BinaryTrees.Implementation.Node;

import java.util.Arrays;

public class ConstructBSTFromPreorderTraversal {
    public Node bstFromPreorder(int[] preorder) {

        if(preorder.length==0){return null;}

        Node node=new Node(preorder[0]);

        int index=preorder.length;

        for (int i = 0; i <preorder.length; i++) {
            if(preorder[i]>node.val){index=i;break;}
        }

        int[] leftPreorder= Arrays.copyOfRange(preorder,1,index);
        int [] rightPreorder=Arrays.copyOfRange(preorder,index,preorder.length);

        node.left=bstFromPreorder(leftPreorder);
        node.right=bstFromPreorder(rightPreorder);

        return node;
    }

}
