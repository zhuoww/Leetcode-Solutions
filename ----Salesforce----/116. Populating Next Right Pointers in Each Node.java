/*
 * medium
 */

/*
// Definition for a Node.
class Node {
   public int val;
   public Node left;
   public Node right;
   public Node next;

   public Node() {}
   
   public Node(int _val) {
       val = _val;
   }

   public Node(int _val, Node _left, Node _right, Node _next) {
       val = _val;
       left = _left;
       right = _right;
       next = _next;
   }
};
*/

//time:O(n);space:O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node cur = root;
        Node nxt = root.left;

        while (cur != null && nxt != null) {
            cur.left.next = cur.right;
            if (cur.next != null) {
                cur.right.next = cur.next.left;
            }

            cur = cur.next;
            if (cur == null) {
                cur = nxt;
                nxt = cur.left;
            }
        }
        return root;
    }
}

// bfs:time:O(n);space:O(n)
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node pre = null;
        Node cur = null;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    pre = q.poll();
                    cur = pre;
                } else {
                    cur = q.poll();
                    pre.next = cur;
                    pre = pre.next;
                }

                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            pre.next = null;
        }
        return root;
    }
}

// dfs:time:O(n);space:O(1)
class Solution {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    public void dfs(Node node) {
        if (node == null)
            return;
        if (node.left != null)
            node.left.next = node.right;
        if (node.right != null) {
            if (node.next == null) {
                node.right.next = null;
            } else {
                node.right.next = node.next.left;
            }
        }

        dfs(node.left);
        dfs(node.right);
    }
}