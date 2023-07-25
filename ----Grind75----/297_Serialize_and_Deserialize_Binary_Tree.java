/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// BFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode parent = q.poll();
            if (!str[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(str[i]));
                q.offer(parent.left);
            }
            if (!str[++i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(str[i]));
                q.offer(parent.right);
            }
        }
        return root;
    }
}

// DFS
public class Codec {
    private int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        seriDFS(root, list);
        return String.join(" ", list);
    }

    public void seriDFS(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("n");
            return;
        }
        list.add(String.valueOf(root.val));

        seriDFS(root.left, list);
        seriDFS(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(" ");
        return deseriDFS(str);
    }

    public TreeNode deseriDFS(String[] str) {
        String s = str[i];
        if (s.equals("n")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        i++;
        node.left = deseriDFS(str);
        node.right = deseriDFS(str);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));