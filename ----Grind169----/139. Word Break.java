//Trie
class TrieNode {
    char val;
    TrieNode[] children;
    boolean isWord;

    public TrieNode(char val) {
        this.val = val;
        children = new TrieNode[26];
        isWord = false;
    }
}

class Solution {
    private TrieNode root;
    private int[] memo = new int[301];

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode(' ');
        for (String string : wordDict) {
            TrieNode cur = root;
            for (char c : string.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        return dfs(s, 0);
    }

    public boolean dfs(String s, int cur) {
        if (cur == s.length())
            return true;
        if (memo[cur] == 1)
            return false;
        TrieNode node = root;

        for (int i = cur; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
                if (node.isWord == true && dfs(s, i + 1)) {
                    return true;
                }
            } else {
                break;
            }
        }
        memo[cur] = 1;
        return false;
    }
}

// dp
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}