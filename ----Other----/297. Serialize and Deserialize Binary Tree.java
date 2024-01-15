/*
 * hard
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                sb.append(cur.val + " ");
            } else {
                sb.append("n ");
                continue;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        String[] s = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < s.length; i++) {
            TreeNode parent = q.poll();
            if (!s[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(s[i]));
                q.offer(parent.left);
            }
            if (!s[++i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(s[i]));
                q.offer(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
