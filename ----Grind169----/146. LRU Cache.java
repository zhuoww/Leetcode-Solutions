class LRUCache {
    HashMap<Integer, Node> map;
    int cache_capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cache_capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node cur = map.get(key);
        remove(cur);
        add(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        Node cur = map.get(key);
        if (cur != null) {
            remove(cur);
            cur.val = value;
            add(cur);

        } else {
            if (map.size() == cache_capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node new_node = new Node(key, value);
            map.put(key, new_node);
            add(new_node);
        }
    }

    public void add(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }

    public void remove(Node node) {
        Node node_prev = node.prev;
        Node node_next = node.next;

        node_prev.next = node_next;
        node_next.prev = node_prev;
    }

}

class Node {
    int key;
    int val;

    Node next;
    Node prev;

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
