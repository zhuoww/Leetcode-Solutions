package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        if (set.size() == 0 || !set.contains(endWord))
            return 0;

        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);

        while (!que.isEmpty()) {
            String cur = que.poll();
            int path = map.get(cur);

            for (int i = 0; i < cur.length(); i++) {
                char[] ch = cur.toCharArray();
                for (char k = 'a'; k <= 'z'; k++) {
                    ch[i] = k;
                    String newWord = String.valueOf(ch);
                    if (newWord.equals(endWord))
                        return path + 1;
                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, path + 1);
                        que.offer(newWord);
                    }
                }
            }

        }
        return 0;

    }
}
