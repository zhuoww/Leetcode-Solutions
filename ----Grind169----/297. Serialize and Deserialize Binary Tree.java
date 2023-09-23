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
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        StringBuilder sb = new StringBuilder();

        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            que.offer(node.left);
            que.offer(node.right);
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        for (int i = 1; i < str.length; i++) {
            TreeNode parent = que.poll();
            if (!str[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(str[i]));
                que.offer(parent.left);
            }
            if (!str[++i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(str[i]));
                que.offer(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));