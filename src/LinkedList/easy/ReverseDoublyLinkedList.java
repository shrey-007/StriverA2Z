package LinkedList.easy;

import LinkedList.implementation.doubly.Node;

public class ReverseDoublyLinkedList {

    /**
     * Reverse DLL = jese swap vaiables ka code hota hai ese hi swap next and previous of a node ka likh do.
     * Fir DLL traverse kro and ek ek krke sabpr vo vaala function run krvaa do.
     * But yaad rahe A->B->C hai and tumne B pr swap call kr diya ab tumhe C pr krna hai toh B se C pr jaane ke liye
     * B.next mat krna coz B ke next and previous swapped ho chuke hai toh B.previous kroge tab C pr jaaoge  */

    public static Node reverseDLL(Node node){
        Node newHead=null;

        while (node!=null){
            if(node.next==null){newHead=node;}
            swap(node);
            node=node.previous;
        }
        return newHead;
    }
    public static void swap(Node node){
        Node temp=node.next;
        node.next=node.previous;
        node.previous=temp;
    }
    /**
     *  A better way of doing this-:
     *  If the question was reverse an array/string toh easily ho jaata toh DLL bhi array jaisa hi hai coz usme bhi aage peeche jaa skte hai
     *  i=0;j=n-1; then swap(i,j) then i++ j--
     *  Ese hi isme krlo i=head; j=tail(iterate to find tail) the swap value of i,j then i=i.next ; j=j.prev;
     *
     * */

}
