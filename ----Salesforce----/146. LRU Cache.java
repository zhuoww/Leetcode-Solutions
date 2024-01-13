/*
 * medium
 * 很重要
 */

class LRUCache {
    // doubly linked list -> next, pre
    // hashmap -> key, Node
    // remove and add function
    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.pre = head;
    }

    // check if the key is in the map
    // if so, get the node from map, remove it from the link list, then add it to
    // the link list
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);
        remove(cur);
        add(cur);

        return cur.val;

    }

    // check if the key is in the map
    // if so, get the node, remove it from the link list, change the val to value,
    // then add it to the link list
    // if not, check the capacity, if map.size() == capacity, remove the least
    // recently used node, and remove it from linklist as well
    // then create the newNode with key and value, put it to map and add it to link
    // list
    public void put(int key, int value) {
        Node cur = map.get(key);
        if (cur != null) {
            remove(cur);
            cur.val = value;
            add(cur);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                remove(tail.pre);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            add(newNode);
        }
    }

    // remove and add newNode to the doubly linked list
    public void remove(Node node) {
        Node node_pre = node.pre;
        Node node_next = node.next;

        node_pre.next = node_next;
        node_next.pre = node_pre;

    }

    public void add(Node node) {
        Node head_next = head.next;

        head.next = node;
        node.pre = head;

        node.next = head_next;
        head_next.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */