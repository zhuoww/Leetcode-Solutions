class TrieNode {
    char val;
    boolean isWord;
    TrieNode[] children;

    public TrieNode(char val) {
        this.val = val;
        isWord = false;
        children = new TrieNode[26];
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode(' ');

    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, TrieNode cur, int index) {
        if (cur == null)
            return false;
        if (index == word.length())
            return cur.isWord;

        if (word.charAt(index) == '.') {
            for (TrieNode temp : cur.children) {
                if (temp != null && dfs(word, temp, index + 1)) {
                    return true;
                }
            }
        } else {
            int tempIndex = word.charAt(index) - 'a';
            TrieNode temp = cur.children[tempIndex];
            if (temp != null) {
                return dfs(word, temp, index + 1);
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
