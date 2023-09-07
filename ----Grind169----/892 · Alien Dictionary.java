import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] indegree = new int[26];

        buildMap(words, map, indegree);
        return topologicalSort(map, indegree);
    }

    public void buildMap(String[] words, Map<Character, Set<Character>> map, int[] indegree) {
        // Step 1: Initialize the map with empty sets
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }

        // Step 2: Build the graph
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int minLen = Math.min(prev.length(), curr.length());
            for (int j = 0; j < minLen; j++) {
                char prevChar = prev.charAt(j);
                char currChar = curr.charAt(j);
                if (prevChar != currChar) {
                    if (!map.get(prevChar).contains(currChar)) {
                        map.get(prevChar).add(currChar);
                        indegree[currChar - 'a']++;
                    }
                    break;
                }
                // Handle the case where the current word is a prefix of the previous word
                if (j == minLen - 1 && prev.length() > curr.length()) {
                    map.clear();
                    return;
                }
            }
        }
    }

    public String topologicalSort(Map<Character, Set<Character>> map, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> queue = new PriorityQueue<>();

        // Step 1: Initialize the queue with characters with 0 indegree
        for (char c : map.keySet()) {
            if (indegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        // Step 2: Perform topological sorting
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (map.containsKey(c)) {
                for (char neighbor : map.get(c)) {
                    indegree[neighbor - 'a']--;
                    if (indegree[neighbor - 'a'] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Step 3: Check for cycle
        if (sb.length() != map.size()) {
            return "";
        }

        return sb.toString();
    }
}
