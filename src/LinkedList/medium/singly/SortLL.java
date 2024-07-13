package LinkedList.medium.singly;

import LinkedList.implementation.singly.Node;

public class SortLL {

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into halves
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        // Recursively sort each half
        Node leftHead = mergeSort(head);
        Node rightHead = mergeSort(nextToMiddle);

        // Merge the sorted halves
        Node sortedList = merge(leftHead, rightHead);
        return sortedList;
    }

    public static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        /**Suppose these are two list which we have to combine
         * 3->9->4  and 1->5
         * l            r             where l=left and r=right
         *
         * Now since left.value > right.value toh result=1 and ab since apan ne 1 ko le liya hai toh r++ krna hoga
         * 3->9->4  and 1->5
         * l               r             where l=left and r=right
         * toh ye means ab l and new r pr krna hai same process toh isi ko likhne ke liye
         * result.next = merge(left, right.next); use kra l vahi hai and r++ hua hai isliye left and right.next kra hai
         *
         */

        Node result;
        if (left.value <= right.value) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

}
