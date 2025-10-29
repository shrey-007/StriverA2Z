package LinkedList.hard;

import LinkedList.implementation.singly.Node;

public class ReverseNodesInKGroup {
    /** Pure Brute Force */

    public Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node endOfPreviousGroup = null;

        while (temp!=null){
            Node kthNode = getKthNode(temp,k);

            if(kthNode==null){
                if(endOfPreviousGroup!=null) endOfPreviousGroup.next = temp;
                break;
            }

            Node startOfNextGroup = kthNode.next;

            kthNode.next = null;

            reverse(temp);

            if(temp==head){
                head = kthNode;
            }
            else{
                endOfPreviousGroup.next = kthNode;
            }

            endOfPreviousGroup = temp;
            temp = startOfNextGroup;
        }

        return head;
    }

    public void reverse(Node node){
        Node before = null;
        Node curr = node;

        while (curr!=null){
            Node after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;
        }


    }

    public Node getKthNode(Node node,int k){
        Node temp = node;
        k--;
        while(k>0){
            if(temp==null){
                // means ye group mai kth node nhi hai, toh return null
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

}
