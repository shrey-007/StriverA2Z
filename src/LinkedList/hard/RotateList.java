package LinkedList.hard;

public class RotateList {

    /** brute force approach is simply delete last node and save its value in temporary value and then create new node
     *  with same value which now points to the head means simply last node ko delete kro and use first node bana do
     *  Esa tumhe k times krna padega and TC to delete last node is n and TC to create first node is 1
     *  toh TC = k(n)
     *
     *  Optimal approach is ki last ko first se jod do toh circular LL ban jaaegi and usme all possible rotations hoge.
     *  Ab LL ki ek iteration kro to find its length .= 0(n)
     *  (l-k+1)th node from starting will be new head toh (l-k)th node pr jaao and (l-k)thNode.next=null krdo
     */


}
