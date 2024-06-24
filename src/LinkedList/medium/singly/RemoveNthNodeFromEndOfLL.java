package LinkedList.medium.singly;

import LinkedList.implementation.singly.Node;

public class RemoveNthNodeFromEndOfLL {

    // one way is count total number of nodes in LL and then find ki last se nth node starting se konsi node hai (let x)
    // Now you just have to remove xth node
    public void removeNthFromEnd(Node head, int n) {

        /**
         *  Better way is take 2 pointers start and end and intially end is n node ahead of start
         *  Now increase start and end one step at a time
         *  When end reaches end of LL(null) then start points to the nth node from the last
         * */

    }
}
