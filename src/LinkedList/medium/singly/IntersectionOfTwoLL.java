package LinkedList.medium.singly;

import LinkedList.implementation.singly.Node;

import java.util.HashSet;

public class IntersectionOfTwoLL {
    // first way is simple brute force check every element of list1 to every element of list2 whether they are equal or not
    static Node intersectionPresent(Node head1, Node head2) {
        while(head2 != null) {
            Node temp = head1;
            while(temp != null) {
                //if both nodes are same
                if(temp == head2) return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        //intersection is not present between the lists return null
        return null;
    }

    // second way is iterate through list1 and store all its node in hashset. Then iterate list2 and check whether it is
    // in hashset or not

    static Node intersectionPresent2(Node head1,Node head2) {
        HashSet<Node> st=new HashSet<>();
        while(head1 != null) {
            st.add(head1);
            head1 = head1.next;
        }
        while(head2 != null) {
            if(st.contains(head2)) return head2;
            head2 = head2.next;
        }
        return null;

    }

    /**
     * Take two dummy nodes for each list. Point each to the head of the lists.
     * Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
     * */

    static Node intersectionPresent3(Node head1,Node head2) {
        Node d1 = head1;
        Node d2 = head2;

        while(d1 != d2) {
            d1 = d1 == null? head2:d1.next;
            d2 = d2 == null? head1:d2.next;
        }

        return d1;
    }


}
