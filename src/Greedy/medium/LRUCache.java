package Greedy.medium;

import java.util.HashMap;

class LRUCache {

    // Node for Doubly Linked List
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // dummy head and tail to simplify operations
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToHead(node); // mark as recently used
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;  // update value
            moveToHead(node);    // move to front
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);

            if (map.size() > capacity) {
                Node lru = removeTail();
                map.remove(lru.key);
            }
        }
    }

    // helper: add node right after head
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // helper: remove a node
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // helper: move a node to head
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // helper: remove node before tail (least recently used)
    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}

