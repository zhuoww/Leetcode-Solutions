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
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null)
            return res;
        que.offer(root);
        int depth = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            LinkedList<Integer> path = new LinkedList<>();
            while (size-- > 0) {
                TreeNode cur = que.poll();
                if (depth % 2 != 0) {
                    path.add(cur.val);
                } else {
                    path.addFirst(cur.val);
                }

                if (cur.left != null)
                    que.offer(cur.left);
                if (cur.right != null)
                    que.offer(cur.right);

            }
            res.add(new ArrayList(path));
        }
        return res;
    }
}