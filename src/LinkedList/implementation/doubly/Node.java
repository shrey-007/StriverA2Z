package LinkedList.implementation.doubly;

public class Node {
    public Node next;
    public Node previous;
    public int value;

    public Node(Node next, Node previous, int value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }
}
