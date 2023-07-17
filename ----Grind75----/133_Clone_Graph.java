/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//DFS
class Solution {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);

        for (Node nei : node.neighbors) {
            Node cur = cloneGraph(nei);
            newNode.neighbors.add(cur);
        }
        return newNode;
    }
}

// BFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);

        Queue<Node> que = new LinkedList<>();
        que.add(node);

        while (!que.isEmpty()) {
            Node cur = que.poll();
            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val, new ArrayList<>()));
                    que.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
}
