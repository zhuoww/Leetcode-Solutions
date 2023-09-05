class TrieNode {
    char val;
    String word;
    TrieNode[] children;

    public TrieNode(char val) {
        this.val = val;
        word = null;
        children = new TrieNode[26];
    }

    public void addWord(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
    }
}

class Solution {
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0)
            return res;

        int row = board.length;
        int col = board[0].length;

        TrieNode root = new TrieNode(' ');
        root.addWord(root, words);
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char x = board[i][j];
                if (root.children[x - 'a'] != null) {
                    dfs(board, root, i, j, res);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] board, TrieNode cur, int i, int j, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
            return;
        char x = board[i][j];
        if (cur.children[x - 'a'] == null)
            return;
        cur = cur.children[x - 'a'];

        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }

        visited[i][j] = true;
        dfs(board, cur, i + 1, j, res);
        dfs(board, cur, i - 1, j, res);
        dfs(board, cur, i, j + 1, res);
        dfs(board, cur, i, j - 1, res);
        visited[i][j] = false;
    }
}
