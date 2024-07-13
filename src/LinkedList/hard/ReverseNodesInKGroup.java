package LinkedList.hard;

import LinkedList.implementation.singly.Node;

public class ReverseNodesInKGroup {
    /** Pure Brute Force */

    // Function to reverse nodes in groups of K
    static Node kReverse(Node head, int k) {

        // Initialize a temporary node to traverse the list
        Node temp = head;

        // Initialize a pointer to track the last node of the previous group
        Node prevLast = null;

        // Traverse through the linked list
        while (temp != null) {

            // Get the Kth node of the current group
            Node kThNode = getKthNode(temp, k);

            // If the Kth node is NULL
            // (not a complete group)
            if (kThNode == null) {

                // If there was a previous group,
                // link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }

                // Exit the loop
                break;
            }

            // Store the next node after the Kth node(i.e store the starting of the new group because we are going to break the the link toh agge nhi jaa paaege agar store nhi kra toh )
            Node nextNode = kThNode.next;

            // Disconnect the Kth node to prepare for reversal(Ab vo group alag ho chuka hai ab usko reverse krdo)
            kThNode.next = null;

            // Reverse the nodes from temp to the Kth node
            reverseLinkedList(temp);

            // Adjust the head if the reversal starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous group to the reversed group
                prevLast.next = kThNode;
            }

            // Update the pointer to the last node of the previous group
            prevLast = temp;

            // Move to the next group
            temp = nextNode;
        }

        // Return the head of the modified linked list
        return head;

    }

    // function to reverse the LL , It is same as we did before
    static Node reverseLinkedList(Node head) {
        // Initialize'temp' at
        // head of linked list
        Node temp = head;

        // Initialize pointer 'prev' to NULL,
        // representing the previous node
        Node prev = null;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
        while (temp != null) {
            // Store the next node in
            // 'front' to preserve the reference
            Node front = temp.next;

            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev;

            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;

            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;
        }

        // Return the new head of
        // the reversed linked list
        return prev;

    }

    // Function to get the Kth node from
    // a given position in the linked list
    static Node getKthNode(Node temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        k -= 1;

        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;

            // Move to the next node
            temp = temp.next;
        }

        // Return the Kth node
        return temp;
    }

}
