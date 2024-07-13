package LinkedList.implementation.doubly;

public class DoublyLinkedList {
    // Node class represents each element in the list
    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail of the list
    private Node head;
    private Node tail;

    // Constructor to initialize the list
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to add a new node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to remove a node from the list by value
    public void remove(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List is now empty
            }
            return;
        }

        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev; // Removing the tail node
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }
    }

    // Method to print the list from head to tail
    public void printListForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to print the list from tail to head
    public void printListBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Main method to test the list
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.printListForward();  // Output: 1 2 3
        list.printListBackward(); // Output: 3 2 1

        list.remove(2);
        list.printListForward();  // Output: 1 3
        list.printListBackward(); // Output: 3 1

        list.remove(1);
        list.printListForward();  // Output: 3
        list.printListBackward(); // Output: 3

        list.remove(3);
        list.printListForward();  // Output: (empty list)
        list.printListBackward(); // Output: (empty list)
    }
}

