package BinaryTrees.Medium;

import BinaryTrees.Implementation.Node;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryLevelTraversal {
    /**
     * 1) Pehle left boundary daalo without leaves
     * 2) Phir leaves daalo
     * 3) Phir right boundary daalo without leaves*/



    public ArrayList<Integer> boundaryLevelTraversal(Node node){

        ArrayList<Integer> ans=new ArrayList<>();

        ArrayList<Integer> rightBoudary=addRightBoundaryWithoutLeaves(node);
        ArrayList<Integer> leaves=addLeafNodes(node);
        ArrayList<Integer> leftBoudary=addLeftBoundaryWithoutLeaves(node);

        ans.addAll(rightBoudary);
        ans.addAll(leaves);
        ans.addAll(leftBoudary);

        return ans;
    }
    public static ArrayList<Integer> addLeafNodes(Node node){

        ArrayList<Integer> ans=new ArrayList<>();

        // just iterate over whole tree using any traversal and find if the node is leaf or not, if yes then add it to answer

        Stack<Node> stack=new Stack<>();

        stack.add(node);

        while (!stack.isEmpty()){
            Node curr =stack.pop();

            if(isLeafNode(curr)){ans.add(curr.val);}

            if(node.right!=null){stack.add(node.right);}
            if(node.left!=null){stack.add(node.left);}
        }
        return ans;
    }

    // You can do addRightBoundaryWithoutLeaves using right , left , node way


    public static ArrayList<Integer> addRightBoundaryWithoutLeaves(Node node){

        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Node> stack=new Stack<>();

        stack.add(node);

        while (!stack.isEmpty()){

            // get the current element
            Node curr=stack.pop();

            // if curr is not a leaf node , then add it to ans
            if(!isLeafNode(node)){ans.add(node.val);}

            // if curr ka right exists krta hai tabhi right ko daalo else left daalo
            if(curr.right!=null){stack.add(curr.right);}
            else{
                stack.add(curr.left);
            }
        }

        return ans;
    }

    // You can do addRightBoundaryWithoutLeaves using left ,right, node way

    public static ArrayList<Integer> addLeftBoundaryWithoutLeaves(Node node){

        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Node> stack=new Stack<>();

        stack.add(node);

        while (!stack.isEmpty()){

            // get the current element
            Node curr=stack.pop();

            // if curr is not a leaf node , then add it to ans
            if(!isLeafNode(node)){ans.add(node.val);}

            // if curr ka left exists krta hai tabhi left ko daalo else right daalo
            if(curr.left!=null){stack.add(curr.left);}
            else{
                stack.add(curr.right);
            }
        }

        return ans;
    }

    public static boolean isLeafNode(Node node){
        if(node==null){return false;}
        return node.right==null && node.left==null;
    }



}
