package LinkedList.medium.singly;

import LinkedList.implementation.singly.Node;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Give answer in iterative and recursive method
 */

public class ReverseLL {

    /**
    public static Node iterative(Node node){

        if(node==null){return node;}

        Node before=null;
        Node curr=node;
        Node after=node.next;  // but if node is null toh node.next error dega toh null ka check krlo

        while (curr!=null){
            curr.next=before;
            before=curr;
            curr=after;
            after=curr.next; // ye problem krega coz while loop mai apan ne curr!=null ka check lagay toh curr null nhi
            // hai but fir curr=after kr diya and after null ho skta hai toh curr null ho skta hai ab tum after=curr.next
            // kroge toh after=null.next ho skta hai toh error aaega. Toh is code mai 2 line modification hoga.
            // Hum after=curr.next is iterartion mai nhi agli iteration ke just start mai karege
        }

    }
    */

    public static Node iterative(Node node){

        if(node==null){return node;}

        Node before=null;
        Node curr=node;
        Node after=node;  // first change

        while (curr!=null){
            after=curr.next; // second change

            curr.next=before;
            before=curr;
            curr=after;
        }

        return before;

    }

    public static Node recursive(Node node,Node previous){

        if(node==null){return node;}

        Node after=node.next; // after can be null
        node.next=previous;   // previouscan be null
        recursive(after,node);
        return node;
    }

}
