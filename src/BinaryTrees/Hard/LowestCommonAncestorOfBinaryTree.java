package BinaryTrees.Hard;

import BinaryTrees.Implementation.Node;

import java.util.HashSet;

public class LowestCommonAncestorOfBinaryTree {
//    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
//        Node ans[]=new Node[1];
//        func(root,p,q,ans);
//        return ans[0];
//    }
//
//    public static HashSet<Integer> func(Node node,Node p, Node q,Node ans[]){
//        HashSet<Integer> leftDescendants=new HashSet<>();
//        HashSet<Integer> rightDescendants=new HashSet<>();
//        // find all its left descendants
//        if(node.left!=null){ leftDescendants=func(node.left,p,q,ans);}
//        if(node.right!=null){rightDescendants=func(node.right,p,q,ans);}
//
//        // find its all descendants including itself
//        HashSet<Integer> descendants=new HashSet<>();
//
//        descendants.addAll(leftDescendants);
//        descendants.addAll(rightDescendants);
//        descendants.add(node.val);
//
//        if(descendants.contains(p.val) && descendants.contains(q.val) && ans[0]==null){ans[0]=node;}
//
//        return descendants;
//    }
//
//    public static Node lowestCommonAncestor2(Node root, Node p, Node q) {
//        Node ans[]=new Node[1];
//        func2(root,p,q,ans);
//        return ans[0];
//    }
//
//
//    public static boolean[] func2(Node node,Node p, Node q,Node ans[]){
//        boolean[] leftDescendants=new boolean[2];
//        boolean[] rightDescendants=new boolean[2];
//
//        // find all its left descendants
//        if(node.left!=null){ leftDescendants=func2(node.left,p,q,ans);}
//        if(node.right!=null){rightDescendants=func2(node.right,p,q,ans);}
//
//        // find its all descendants including itself
//        boolean[] descendants=new boolean[2];
//
//        descendants[0]=leftDescendants[0] || rightDescendants[0] || node.val==p.val;
//        descendants[1]=leftDescendants[1] || rightDescendants[1] || node.val==q.val;
//
//        if(descendants[0] && descendants[1] && ans[0]==null){ans[0]=node;}
//
//        return descendants;
//    }
    /**
     * THE CONCEPT IS KI LCA VAHI HOGA JISKE DONO CALLS MAI P,Q AAYE i.e faith1, faith2 both are not null
     * Ek case esa hoga jisme kisi bhi node ke dono faith not null nhi hoge, means ek pakka null hoga, voh tabhi hoga jab p is parent q or q is parent of p, toh us case mai p and q ko hi return krdo, and jis faith ka answer aa rha hai use return krte jaao.*/

    /** DRY RUN OF THIS CODE IS DONE IN A VIDEO (IN VIDEOS PACKAGE)*/
    /**
     * Har node par jaao and check kro ki uske left ya right subtree mai p,q hai ki nhi.
     * Ye code node return kr rha hai.
     *
     * There can be few cases-:
     * Case 1. p is parent of q-: Toh jaise hi code p pe aaye toh p return hona chaiye ,and ho bhi rha hai , if(node==p || node==q){return node;}
     * Case 2. If p and q are in different subtree and lca is node A-: toh A ka faith1 p return krega, faith2 q return krega and since dono faith1,faith2 hi null nhi hai toh A return hoga
     *
     * Q-:What happens if code reaches to the parent Of A. How does it not make it lca?
     * CaseII-:Suppose code reaches to B(parent of A), since A ke faith1,faith2 dono hi null ni the isliye A return hua but yaha B ke dono faiths return nhi krega, ek faith A return krega and ek faith null, toh A hi return hoga
     * CaseI-: poore traversal mai koi node nhi hogi jiske dono faith not null ho. If code reaches to parent of p, toh ume ek faith p return krega and ek faith null toh effectively p hi return hoga.
     * */
    public static Node func3(Node node,Node p, Node q){

        if (node==null){return null;}

        // agar kahi par bhi node milti hai toh usi ko return krdo
        if(node==p || node==q){return node;}

        Node faith1=func3(node.left,p,q);
        Node faith2=func3(node.right,p,q);

        // agar kahi se bhi answer aaya hai toh vahi answer return kro
        // Agar is case mai faith1, faith2 dono hi null hai hai means kahi se bhi ans nhi aaya toh null return krdo.
        if(faith1==null && faith2==null){return null;}
        // means faith2 null nhi hai, vaha ans hai
        if(faith1==null){return faith2;}
        // means faith1 null nhi hai, vaha ans hai
        else if(faith2==null){return faith1;}

        // means ki faith1 and faith2 dono se ans aaya hai means yahi ancestor hai
        else{return node;}

    }

    public static void main(String[] args) {

    }
}
