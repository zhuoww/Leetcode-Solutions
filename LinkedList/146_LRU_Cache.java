package LinkedList;

import java.util.HashMap;

class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    // head and tail are Node objects representing the dummy head and tail of the
    // doubly linked list
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        // head and tail nodes are created with dummy key-value pairs (0, 0)
        head = new Node(0, 0);
        tail = new Node(0, 0);
        // this connects the head and tail nodes to form an empty linked list
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node n = map.get(key);
        remove(n);// remove the node from its current position in the linked list
        insert(n);// insert the node at the head of the linked list
        return n.val;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {// if the node exists
            remove(n);
            n.val = value;// the value of the existing node is updated with the new value
            insert(n);// the updated node is inserted at the head of the linked list
        } else {// if the node doesn't exist, meaning it's a new key
            if (map.size() == capacity) {// the cache is full
                // If the cache is full, remove the least recently used node
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            // Create a new node and add it to the HashMap and the head of the linked list
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);
        }
    }

    public void remove(Node n) {
        Node preNode = n.pre;
        Node nextNode = n.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    public void insert(Node n) {
        Node headNext = head.next;
        head.next = n;
        n.pre = head;
        n.next = headNext;
        headNext.pre = n;
    }
}

class Node {
    int key;
    int val;
    Node pre;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */