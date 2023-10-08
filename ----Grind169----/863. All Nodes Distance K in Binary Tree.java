/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();

                if (cur.left != null) {
                    map.put(cur.left.val, cur);
                    que.offer(cur.left);
                }

                if (cur.right != null) {
                    map.put(cur.right.val, cur);
                    que.offer(cur.right);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        que.offer(target);
        while (k-- > 0 && !que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();

                visited.add(cur.val);
                if (cur.left != null && !visited.contains(cur.left.val)) {
                    que.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right.val)) {
                    que.offer(cur.right);
                }
                if (map.containsKey(cur.val) && !visited.contains(map.get(cur.val).val)) {
                    que.offer(map.get(cur.val));
                }
            }

        }

        while (!que.isEmpty()) {
            res.add(que.poll().val);
        }
        return res;

    }
}
