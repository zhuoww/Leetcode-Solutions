/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// recursion
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}

// bfs
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> que = new LinkedList<>();
        if (p == null && q == null)
            return true;
        que.offer(p);
        que.offer(q);

        while (!que.isEmpty()) {
            TreeNode curP = que.poll();
            TreeNode curQ = que.poll();

            if (curP == null && curQ == null)
                continue;
            if (curP == null || curQ == null || curP.val != curQ.val)
                return false;

            que.offer(curP.left);
            que.offer(curQ.left);
            que.offer(curP.right);
            que.offer(curQ.right);
        }
        return true;
    }
}
