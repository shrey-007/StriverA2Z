package BinarySearchTrees.concepts;

import BinaryTrees.Implementation.Node;

public class DeleteNodeInBST {
    /**
     * Remember one thing-: Uper vaali node ko neeche ki jis node se connect krna hai us node ko return kroge
     * Agar vo koi random node hai toh use hi return krdo coz uska parent change nhi hoga
     * JUST DRY RUN IT FOR BETTER UNDERSTANDING, AND TEST CASE KOI MIDDLE NODE DELETE KRNE KA RAKHNA*/
    public Node deleteNode(Node root, int key) {

        if (root==null){return null;}

        if(root.val>key){
            // means ye vo node nhi hai , but iska left mai hoga vo node toh iska left subtree change hoga
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            // means ye vo node nhi hai but iska right mai hoga vo node toh iska right subtree change hoga
            root.right=deleteNode(root.right,key);
        }
        else{
            // means yahi vo node hai(read this line later)
            // means ki agar koi ek hi children hai toh uper vaali node ko dono mai se kisi bhi node se connect krdo
            if(root.right==null){return root.left;}
            if(root.left==null){return root.right;}

            // means ki na toh left null hai na right, middle node hai

            //Get the inorder successor (smallest in the right subtree)
            root.val = minValue(root.right);

            // Ab tumhe inorder successor (smallest in the right subtree) ko delete krna hai(isliye key mai updated root.val pass kri hai), jo ki right subtree mai hai isliye(root.right) likha hai
            // jiska pakka right children null hoga toh use delete krne ke liye uper ki 2 if conditions hi kaam kr degi
            root.right=deleteNode(root.right,root.val);
        }

        // return current node
        return root;

    }

    public int minValue(Node node){
        int minValue=node.val;
        while (node.left!=null){
            minValue=node.left.val;
            node=node.left;
        }
        return minValue;
    }
}
