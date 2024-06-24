package LinkedList.implementation.singly;

public class Node {
    public Node next;
    public int value;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                ", value=" + value +
                '}';
    }
}
